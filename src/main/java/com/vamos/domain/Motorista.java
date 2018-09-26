package com.vamos.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("motorista")
public class Motorista extends Usuario {
	private static final long serialVersionUID = 1L;
	
	private String cpfOuCnpj;
	private String cnh;
	
	public Motorista( ) {
		
	}
	
	public Motorista(Integer id, String nome, String email, String senha, Date dataNasc, String cpfOuCnpj, String cnh) {
		super(id, nome, email, senha, dataNasc);
		this.cpfOuCnpj = cpfOuCnpj;
		this.cnh = cnh;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

}
