package com.vamos.dto.output;

import com.vamos.domain.VanGroup;
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

	public GroupDetailsDTO(){

	}

	public GroupDetailsDTO(VanGroup group){
		this.groupName = group.getName();
		this.maxCapacity = group.getMaxCapacity();
		this.institution = group.getInstitution().getDescription();
		this.shift = group.getShift().getDescription();
		this.driverName = group.getDriver().getName();
	}

	public GroupDetailsDTO(String groupName, int maxCapacity, String institution, String shift, String driverName) {
		this.groupName = groupName;
		this.maxCapacity = maxCapacity;
		this.institution = institution;
		this.shift = shift;
		this.driverName = driverName;
	}

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
