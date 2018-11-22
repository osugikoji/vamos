package com.vamos.domain.enums;

public enum PaymentStatusEnum {
	
	PENDING(1, "Pendente"),
	PAID(2, "Pago");
	
	private int cod;
	private String descricao;
	
	private PaymentStatusEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static PaymentStatusEnum toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(PaymentStatusEnum x : PaymentStatusEnum.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
	}
}
