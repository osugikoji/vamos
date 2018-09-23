package com.vamos.domain;

public class Motorista extends UsuarioAbstract {
	
	private String cpfOuCnpj;
	private String cnh;
	
	public Motorista( ) {}
	
	public Motorista(String cpfOuCnpj, String cnh) {
		super();
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnh == null) ? 0 : cnh.hashCode());
		result = prime * result + ((cpfOuCnpj == null) ? 0 : cpfOuCnpj.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorista other = (Motorista) obj;
		if (cnh == null) {
			if (other.cnh != null)
				return false;
		} else if (!cnh.equals(other.cnh))
			return false;
		if (cpfOuCnpj == null) {
			if (other.cpfOuCnpj != null)
				return false;
		} else if (!cpfOuCnpj.equals(other.cpfOuCnpj))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Motorista [cpfOuCnpj=" + cpfOuCnpj + ", cnh=" + cnh + "]";
	}
}
