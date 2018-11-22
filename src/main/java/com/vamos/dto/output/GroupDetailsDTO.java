package com.vamos.dto.output;

import com.vamos.services.validation.MotoristaUpdate;

import java.io.Serializable;

/*DTO contendo os detalhes do Grupo da Van*/
@MotoristaUpdate
public class GroupDetailsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String groupName;

	private int maxCapacity;

	private String institution;

	private String shift;

	private String driverName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
}
