package com.vamos.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("estudante")
public class Estudante extends Usuario{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="estudante", cascade=CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	
	@ManyToOne
	private Instituicao instituicao;
	
	public Estudante() {
		
	}

	public Estudante(Integer id, String nome, String email, String senha, Date dataNasc, Instituicao instituicao) {
		super(id, nome, email, senha, dataNasc);
		this.instituicao = instituicao;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
