package com.vamos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.*;
import java.util.*;

@Entity
@JsonTypeName("estudante")
public class Estudante extends Usuario{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="estudante", cascade=CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="instituicao_id")
	private Instituicao instituicao;

	@JsonIgnore
	@OneToMany(mappedBy = "id.estudante")
	private Set<IntegranteGrupo> grupos = new HashSet<>();
	
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

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Set<IntegranteGrupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<IntegranteGrupo> grupos) {
		this.grupos = grupos;
	}
}
