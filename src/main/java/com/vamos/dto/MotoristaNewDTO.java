package com.vamos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vamos.services.validation.MotoristaInsert;

@MotoristaInsert
public class MotoristaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	@Email(message = "Email invalido")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String senha;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotNull(message = "Preenchimento obrigatorio")
	private Date dataNasc;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String cpf;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String cnh;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String telefone1;
	
	private String telefone2;
		
	public MotoristaNewDTO() {
		
	}

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}


	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
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
}
