package com.vamos.domain.enums;

public enum UserProfileEnum {

	DRIVER(1,"ROLE_DRIVER"),
	STUDENT(2,"ROLE_STUDENT");

	private int cod;
	private String description;

	private UserProfileEnum(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static UserProfileEnum toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(UserProfileEnum x : UserProfileEnum.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
	}
}
