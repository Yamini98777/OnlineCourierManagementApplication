package com.capg.ocma.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "manager")
public class Manager  {

	@Id
	private int managerId;
	
	public Manager() {
		super();
	}
	public Manager(int managerId) {
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
		return "Manager [managerId=" + managerId  + "]";
	}

}
