package com.vamos.domain.enums;

public enum ShiftEnum {
	
	MORNING(1,"Matutino"),
	AFTERNOON(2,"Vespertino"),
	NIGHT(3,"Noturno");
	
	private int cod;
	private String descricao;
	
	private ShiftEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static ShiftEnum toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(ShiftEnum x : ShiftEnum.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
	}
}
