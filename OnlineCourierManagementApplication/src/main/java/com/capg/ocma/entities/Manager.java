package com.capg.ocma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager extends OfficeStaffMember {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "manager_id")
	private int managerId;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "manager_id")
	private List<OfficeStaffMember> reportingstaffmembers;

	public Manager() {
		super();
	}
	public Manager(int managerId, List<OfficeStaffMember> reportingstaffmembers) {
		super();
		this.managerId = managerId;
		this.reportingstaffmembers = reportingstaffmembers;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public List<OfficeStaffMember> getReportingstaffmembers() {
		return reportingstaffmembers;
	}

	public void setReportingstaffmembers(List<OfficeStaffMember> reportingstaffmembers) {
		this.reportingstaffmembers = reportingstaffmembers;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", reportingstaffmembers=" + reportingstaffmembers + "]";
	}

}
