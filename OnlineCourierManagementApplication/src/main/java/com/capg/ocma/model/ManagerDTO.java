package com.capg.ocma.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ManagerDTO extends OfficeStaffMemberDTO {

	private int managerId;
	private List<OfficeStaffMemberDTO> reportingstaffmembers;

	public ManagerDTO() {
		super();
	}

	public ManagerDTO(int managerId, List<OfficeStaffMemberDTO> reportingstaffmembers) {
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

	public List<OfficeStaffMemberDTO> getReportingstaffmembers() {
		return reportingstaffmembers;
	}

	public void setReportingstaffmembers(List<OfficeStaffMemberDTO> reportingstaffmembers) {
		this.reportingstaffmembers = reportingstaffmembers;
	}

	@Override
	public String toString() {
		return "ManagerDTO [managerId=" + managerId + ", reportingstaffmembers=" + reportingstaffmembers + "]";
	}

}
