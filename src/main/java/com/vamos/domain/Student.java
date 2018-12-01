package com.vamos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.vamos.domain.enums.PaymentStatusEnum;

import javax.persistence.*;
import java.util.*;

@Entity
@JsonTypeName("student")
public class Student extends User {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @JsonIgnore
    @ManyToMany
    private Set<VanGroup> groups = new HashSet<>();

    private Integer paymentStatus;

    @OneToMany
    private List<DailySchedule> dailySchedules = new ArrayList<>();

    public Student() {
    }

    public Student(Integer id, String name, String email, String password,
                   Date birthDate, Institution institution, PaymentStatusEnum paymentStatusEnum) {
        super(id, name, email, password, birthDate);
        this.institution = institution;
        this.paymentStatus = (paymentStatusEnum == null) ? null : paymentStatusEnum.getCod();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public PaymentStatusEnum getPaymentStatus() {
        return PaymentStatusEnum.toEnum(this.paymentStatus);
    }

    public void setPaymentStatus(PaymentStatusEnum paymentStatusEnum) {
        this.paymentStatus = paymentStatusEnum.getCod();
    }

    public Set<VanGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<VanGroup> groups) {
        this.groups = groups;
    }

    public List<DailySchedule> getDailySchedules() {
        return dailySchedules;
    }

    public void setDailySchedules(List<DailySchedule> dailySchedules) {
        this.dailySchedules = dailySchedules;
    }
}
