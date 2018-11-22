package com.vamos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.vamos.domain.Driver;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vamos.services.validation.MotoristaUpdate;

/*DTO que atualiza os dados de um estudante existente*/
@MotoristaUpdate
public class DriverUpdateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String name;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	@Email(message = "Email invalido")
	private String email;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotNull(message = "Preenchimento obrigatorio")
	private Date birthDate;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String cpf;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String cnh;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpfOuCnpj) {
		this.cpf = cpfOuCnpj;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public Driver convertToEntity() {
		return new Driver(null,this.name,this.email,null,this.birthDate,this.cpf, this.cnh);
	}
}
