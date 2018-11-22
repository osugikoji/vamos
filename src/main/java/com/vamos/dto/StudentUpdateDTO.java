package com.vamos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.vamos.domain.Student;
import com.vamos.domain.Institution;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vamos.services.validation.EstudanteUpdate;

/*DTO que atualiza os dados de um estudante existente*/
@EstudanteUpdate
public class StudentUpdateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	@NotEmpty(message = "Preenchimento obrigatório")
	private String name;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotNull(message = "Preenchimento obrigatório")
	private Date birthDate;
	
	@NotNull(message = "Preenchimento obrigatório")
	private Integer institutionId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}

	public Student convertToEntity() {
		return new Student(null,this.name,this.email,null,this.birthDate,new Institution(this.institutionId,null));
	}
}
