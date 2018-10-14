package com.vamos.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.vamos.domain.enums.Turno;

@Entity
public class Grupo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private int capacidadeMax;
	
	@ManyToOne
	@JoinColumn(name="instituicao_id")
	private Instituicao instituicao;
	
	private Integer turno;
	
	@ManyToOne
	@JoinColumn(name="motorista_id")
	private Motorista motorista;
	
	public Grupo() {
		
	}

	public Grupo(Integer id, String nome, int capacidadeMax, Instituicao instituicao, Turno turno,
			Motorista motorista) {
		super();
		this.id = id;
		this.nome = nome;
		this.capacidadeMax = capacidadeMax;
		this.instituicao = instituicao;
		this.turno = (turno==null) ? null : turno.getCod();
		this.motorista = motorista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCapacidadeMax() {
		return capacidadeMax;
	}

	public void setCapacidadeMax(int capacidadeMax) {
		this.capacidadeMax = capacidadeMax;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Turno getTurno() {
		return Turno.toEnum(this.turno);
	}

	public void setTurno(Turno turno) {
		this.turno = turno.getCod();
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
