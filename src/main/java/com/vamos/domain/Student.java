package com.vamos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import java.util.*;

@Entity
@JsonTypeName("student")
public class Student extends User {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL)
	private List<Address> addresses = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="institution_id")
	private Institution institution;

	@JsonIgnore
	@OneToMany(mappedBy = "id.student")
	private Set<Passenger> groups = new HashSet<>();
	
	public Student() {
		
	}

	public Student(Integer id, String name, String email, String password, Date birthDate, Institution institution) {
		super(id, name, email, password, birthDate);
		this.institution = institution;
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

	public Set<Passenger> getGroups() {
		return groups;
	}

	public void setGroups(Set<Passenger> groups) {
		this.groups = groups;
	}
}
