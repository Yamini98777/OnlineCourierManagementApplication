package com.capg.ocma.model;

import org.springframework.stereotype.Component;

@Component
public class ManagerDTO {

	private int managerId;

	public ManagerDTO() 
	{
		super();
	}

	public ManagerDTO(int managerId) {
		super();
		this.managerId = managerId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	

	@Override
	public String toString() {
		return "ManagerDTO [managerId=" + managerId + "]";
	}

}
