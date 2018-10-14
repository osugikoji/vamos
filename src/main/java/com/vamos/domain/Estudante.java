package com.vamos.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.vamos.domain.enums.EstadoPagamento;

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
	@ManyToOne
	@JoinColumn(name="grupo_id")
	private Grupo grupo;
	
	private Integer estadoPagamento;
	
	public Estudante() {
		
	}

	public Estudante(Integer id, String nome, String email, String senha, Date dataNasc, Instituicao instituicao, Grupo grupo, EstadoPagamento estadoPagamento) {
		super(id, nome, email, senha, dataNasc);
		this.instituicao = instituicao;
		this.grupo = grupo;
		this.estadoPagamento = (estadoPagamento==null) ? null : estadoPagamento.getCod();
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

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public EstadoPagamento getEstadoPagamento() {
		return EstadoPagamento.toEnum(this.estadoPagamento);
	}

	public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento.getCod();
	}
}
