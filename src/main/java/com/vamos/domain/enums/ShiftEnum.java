package com.vamos.domain.enums;

public enum ShiftEnum {
	
	MORNING(1,"Matutino"),
	AFTERNOON(2,"Vespertino"),
	NIGHT(3,"Noturno");
	
	private int cod;
	private String description;
	
	private ShiftEnum(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
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
