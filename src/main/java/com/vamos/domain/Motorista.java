package com.vamos.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("motorista")
public class Motorista extends Usuario {
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	
	private String cnh;

	@JsonIgnore
	@OneToMany(mappedBy="motorista")
	private List<Grupo> grupos = new ArrayList<>();

	public Motorista( ) {
		
	}
	
	public Motorista(Integer id, String nome, String email, String senha, Date dataNasc, String cpf, String cnh) {
		super(id, nome, email, senha, dataNasc);
		this.cpf = cpf;
		this.cnh = cnh;
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

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
}
