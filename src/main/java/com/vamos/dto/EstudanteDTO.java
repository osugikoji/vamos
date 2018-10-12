package com.vamos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EstudanteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatorio")
	private String email;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotNull(message = "Preenchimento obrigatorio")
	private Date dataNasc;
	
	@NotNull(message = "Preenchimento obrigatorio")
	private Integer instituicaoId;

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

	public Integer getInstituicaoId() {
		return instituicaoId;
	}

	public void setInstituicaoId(Integer instituicaoId) {
		this.instituicaoId = instituicaoId;
	}
}
