package com.vamos.domain;

import com.vamos.domain.enums.ShiftEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class VanGroup implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private int maxCapacity;
	
	@ManyToOne
	@JoinColumn(name="institution_id")
	private Institution institution;
	
	private Integer shift;

	@ManyToOne
	@JoinColumn(name="driver_id")
	private Driver driver;
	
	@ManyToMany()
	private Set<Student> students = new HashSet<>();

	
	public VanGroup() {
		
	}

	public VanGroup(Integer id, String name, int maxCapacity, Institution institution, ShiftEnum shiftEnum, Driver driver) {
		super();
		this.id = id;
		this.name = name;
		this.maxCapacity = maxCapacity;
		this.institution = institution;
		this.shift = (shiftEnum == null) ? null : shiftEnum.getCod();
		this.driver = driver;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public ShiftEnum getShift() {
		return ShiftEnum.toEnum(this.shift);
	}

	public void setShift(ShiftEnum shiftEnum) {
		this.shift = shiftEnum.getCod();
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VanGroup other = (VanGroup) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
