package com.vamos.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("motorista")
public class Motorista extends Usuario {
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	
	private String cnh;
	
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

}
