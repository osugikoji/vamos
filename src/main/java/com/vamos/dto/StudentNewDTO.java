package com.vamos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.vamos.domain.Student;
import com.vamos.domain.Institution;
import org.hibernate.validator.constraints.Length;

import com.vamos.services.validation.EstudanteInsert;

/*DTO que cria um novo estudante*/
@EstudanteInsert
public class StudentNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String name;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String password;
	
//	@JsonFormat(pattern="dd/MM/yyyy")
//	@NotNull(message = "Preenchimento obrigatório")
	private Date birthDate;
	
	//@NotNull(message = "Preenchimento obrigatório")
	//private Integer institutionId;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String phone;

//	private Integer cityId;
	
	public StudentNewDTO() {
		
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

//	public Integer getInstitutionId() {
//		return institutionId;
//	}

//	public void setInstitutionId(Integer institutionId) {
//		this.institutionId = institutionId;
//	}

	public Student convertToEntity() {
	//	Institution institution = new Institution(this.institutionId, null);
		Student student = new Student(null, this.name, this.email, this.password, this.birthDate, null);
		student.getPhones().add(this.phone);
		return student;
	}
}
