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
	@Length(min=3, max=20, message="O tamanho deve ser entre 5 e 20 caracteres")
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
	
	public NewStudentDTO() {
		
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

}
