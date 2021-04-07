package com.capg.ocma.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.capg.ocma.entities.OfficeStaffMember;

@Component
public class ManagerDTO {

	private int managerId;
	private List<OfficeStaffMember> reportingstaffmembers;

	public ManagerDTO() {
		super();
	}

	public ManagerDTO(int managerId, List<OfficeStaffMember> reportingstaffmembers) {
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
		return "ManagerDTO [managerId=" + managerId + ", reportingstaffmembers=" + reportingstaffmembers + "]";
	}

}
