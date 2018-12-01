package com.vamos.domain.enums;

public enum PaymentStatusEnum {
	
	PENDING(1, "Pendente"),
	PAID(2, "Pago");
	
	private int cod;
	private String description;
	
	private PaymentStatusEnum(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
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
