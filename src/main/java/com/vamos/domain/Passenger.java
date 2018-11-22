package com.vamos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vamos.domain.enums.PaymentStatusEnum;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Passenger implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private PassengerPK id = new PassengerPK();

    private Integer paymentStatus;

    @OneToOne
    @JoinColumn(name="weeklySchedule_id")
    private WeeklySchedule weeklySchedule;

    public Passenger(){

    }

    public Passenger(Student student, VanGroup vanGroup, PaymentStatusEnum paymentStatusEnum, WeeklySchedule weeklySchedule) {
        this.id.setStudent(student);
        this.id.setVanGroup(vanGroup);
        this.paymentStatus = (paymentStatusEnum == null) ? null : paymentStatusEnum.getCod();
        this.weeklySchedule = weeklySchedule;
    }

    public Student getStudent(){
        return this.id.getStudent();
    }

    public void setStudent(Student student){
        this.id.setStudent(student);
    }

    @JsonIgnore
    public VanGroup getGroup(){
        return this.id.getVanGroup();
    }

    public void setGroup(VanGroup vanGroup){
        this.id.setVanGroup(vanGroup);
    }

    public PaymentStatusEnum getPaymentStatus() {
        return PaymentStatusEnum.toEnum(this.paymentStatus);
    }

    public void setPaymentStatus(PaymentStatusEnum paymentStatusEnum) {
        this.paymentStatus = paymentStatusEnum.getCod();
    }

    public WeeklySchedule getWeeklySchedule() {
        return weeklySchedule;
    }

    public void setWeeklySchedule(WeeklySchedule weeklySchedule) {
        this.weeklySchedule = weeklySchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger that = (Passenger) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
