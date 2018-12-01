package com.vamos.dto.input;

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
public class NewStudentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=20, message="O tamanho deve ser entre 5 e 20 caracteres")
	private String name;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String password;

	@NotNull(message = "Preenchimento obrigatório")
	private String institutionId;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String phone;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String stateId;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String cityId;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String street;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String district;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String number;
	
	public NewStudentDTO() {
		
	}

	public NewStudentDTO(String name, String email, String password, String institutionId, String phone, String stateId,
	 String cityId, String street, String district, String number) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.institutionId = institutionId;
		this.phone = phone;
		this.stateId = stateId;
		this.cityId = cityId;
		this.street = street;
		this.district = district;
		this.number = number;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
