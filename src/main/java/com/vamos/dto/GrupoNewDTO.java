package com.vamos.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class GrupoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotNull(message = "Preenchimento obrigatório")
	private Integer capacidadeMax;
	
	@NotNull(message = "Preenchimento obrigatório")
	private Integer instituicaoId;
	
	@NotNull(message = "Preenchimento obrigatório")
	private Integer turno;
	
	public GrupoNewDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCapacidadeMax() {
		return capacidadeMax;
	}

	public void setCapacidadeMax(Integer capacidadeMax) {
		this.capacidadeMax = capacidadeMax;
	}

	public Integer getInstituicaoId() {
		return instituicaoId;
	}

	public void setInstituicaoId(Integer instituicaoId) {
		this.instituicaoId = instituicaoId;
	}

	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}
}
