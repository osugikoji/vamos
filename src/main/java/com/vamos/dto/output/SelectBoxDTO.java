package com.vamos.dto.output;

import com.vamos.services.validation.MotoristaUpdate;

import java.io.Serializable;

/*DTO contendo dados do selectbox*/
@MotoristaUpdate
public class SelectBoxDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String description;

	public SelectBoxDTO(){

	}

	public SelectBoxDTO(String id, String description) {
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
