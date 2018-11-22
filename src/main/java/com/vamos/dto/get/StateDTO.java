package com.vamos.dto.get;

import com.vamos.services.validation.MotoristaUpdate;

import java.io.Serializable;

/*DTO contendo o estado*/
@MotoristaUpdate
public class StateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
