package com.vamos.dto.get;

import com.vamos.services.validation.MotoristaUpdate;

import java.io.Serializable;

/*DTO contendo a instituicao*/
@MotoristaUpdate
public class InstitutionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String institution;

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
}
