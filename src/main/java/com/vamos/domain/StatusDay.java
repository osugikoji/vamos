package com.vamos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vamos.domain.enums.DayEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class StatusDay implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer description;

    private boolean going;

    private boolean turn;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="weeklySchedule_id")
    private WeeklySchedule weeklySchedule;

    public StatusDay(){

    }

    public StatusDay(Integer id, DayEnum description, boolean going, boolean turn, WeeklySchedule weeklySchedule) {
        this.id = id;
        this.description = (description == null) ? null : description.getCod();
        this.going = going;
        this.turn = turn;
        this.weeklySchedule = weeklySchedule;
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

    public WeeklySchedule getWeeklySchedule() {
        return weeklySchedule;
    }

    public void setWeeklySchedule(WeeklySchedule weeklySchedule) {
        this.weeklySchedule = weeklySchedule;
    }

    public boolean isGoing() {
        return going;
    }

    public void setGoing(boolean going) {
        this.going = going;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusDay statusDay = (StatusDay) o;
        return Objects.equals(id, statusDay.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
