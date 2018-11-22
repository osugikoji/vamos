package com.vamos.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.vamos.domain.VanGroup;
import com.vamos.domain.Institution;
import com.vamos.domain.Driver;
import com.vamos.domain.enums.ShiftEnum;
import org.hibernate.validator.constraints.Length;

/*DTO que cria um novo grupo da van*/
public class GroupNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String name;
	
	@NotNull(message = "Preenchimento obrigatório")
	private Integer maxCapacity;
	
	@NotNull(message = "Preenchimento obrigatório")
	private Integer institutionId;
	
	@NotNull(message = "Preenchimento obrigatório")
	private Integer shift;
	
	public GroupNewDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public Integer getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}

	public Integer getShift() {
		return shift;
	}

	public void setShift(Integer shift) {
		this.shift = shift;
	}

	public VanGroup convertToEntity(Integer driverId) {
		Institution institution = new Institution(this.institutionId, null);
		Driver driver = new Driver(driverId, null, null, null, null, null, null);
		VanGroup vanGroup = new VanGroup(null, this.name, this.maxCapacity, institution, ShiftEnum.toEnum(this.shift), driver);
		return vanGroup;
	}
}
