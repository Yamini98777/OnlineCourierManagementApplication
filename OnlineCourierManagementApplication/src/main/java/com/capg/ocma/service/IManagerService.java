package com.capg.ocma.service;

import java.util.List;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.StaffMemberNotFoundException;
import com.capg.ocma.model.OfficeStaffMemberDTO;


public interface IManagerService {

	public void addStaffMember(OfficeStaffMember staffmember);
	public void removeStaffMember(OfficeStaffMember staffmember);
	
	public OfficeStaffMemberDTO getStaffMember(int empid) throws StaffMemberNotFoundException;
	public List<OfficeStaffMemberDTO> getAllStaffMembers();
	
	public boolean getCourierStatus(Courier courier) throws CourierNotFoundException;
	
	public Complaint getRegistedComplaint(int complaintid) throws ComplaintNotFoundException;
	public List<Complaint> getAllComplaints();
}
