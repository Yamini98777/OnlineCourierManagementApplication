package com.capg.ocma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "manager")
public class Manager  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "manager_id")
	private int managerId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<OfficeStaffMember> reportingStaffMembers;

	public Manager() {
		super();
	}
	public Manager(int managerId, List<OfficeStaffMember> reportingStaffMembers) {
		super();
		this.managerId = managerId;
		this.reportingStaffMembers = reportingStaffMembers;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public List<OfficeStaffMember> getReportingStaffMembers() {
		return reportingStaffMembers;
	}

	public void setReportingStaffMembers(List<OfficeStaffMember> reportingStaffMembers) {
		this.reportingStaffMembers = reportingStaffMembers;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", reportingStaffMembers=" + reportingStaffMembers + "]";
	}

}
