package com.vamos.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PassengerPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "vanGroup_id")
    private VanGroup vanGroup;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public VanGroup getVanGroup() {
        return vanGroup;
    }

    public void setVanGroup(VanGroup vanGroup) {
        this.vanGroup = vanGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerPK that = (PassengerPK) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(vanGroup, that.vanGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, vanGroup);
    }
}
