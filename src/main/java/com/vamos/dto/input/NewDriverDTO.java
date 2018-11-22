package com.vamos.dto.input;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.vamos.domain.Driver;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vamos.services.validation.MotoristaInsert;

/*DTO que cria um novo motorista*/
@MotoristaInsert
public class NewDriverDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String name;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	@Email(message = "Email invalido")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String password;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String cpf;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String cnh;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String phone;
		
	public NewDriverDTO() {
		
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

	public void setPhone(String phone1) {
		this.phone = phone1;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public Driver convertToEntity() {
		Driver driver = new Driver(null, this.name, this.email, this.password, null, this.cpf, this.cnh);
		driver.getPhones().add(this.phone);

		return driver;
	}
}
