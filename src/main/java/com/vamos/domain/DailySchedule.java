package com.vamos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vamos.domain.enums.DayEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class DailySchedule implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer description;

    private boolean going;

    private boolean returning;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="student_id")
    private Student student;

    public DailySchedule(){

    }

    public DailySchedule(Integer id, DayEnum description, boolean going, boolean returning, Student passenger) {
        this.id = id;
        this.description = (description == null) ? null : description.getCod();
        this.going = going;
        this.returning = returning;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DayEnum getDescription() {
        return DayEnum.toEnum(this.description);
    }

    public void setDescription(DayEnum description) {
        this.description = description.getCod();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isGoing() {
        return going;
    }

    public void setGoing(boolean going) {
        this.going = going;
    }

    public boolean isReturning() {
        return returning;
    }

    public void setReturning(boolean returning) {
        this.returning = returning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailySchedule dailySchedule = (DailySchedule) o;
        return Objects.equals(id, dailySchedule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
