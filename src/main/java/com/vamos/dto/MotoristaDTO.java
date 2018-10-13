package com.vamos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vamos.services.validation.MotoristaUpdate;

@MotoristaUpdate
public class MotoristaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	@Email(message = "Email invalido")
	private String email;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotNull(message = "Preenchimento obrigatorio")
	private Date dataNasc;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String cpf;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String cnh;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
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
}
