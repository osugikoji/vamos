package com.vamos.dto.get;

import com.vamos.services.validation.MotoristaUpdate;

import java.io.Serializable;

/*DTO contendo a cidade*/
@MotoristaUpdate
public class CityDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
