package com.capg.ocma.service;

import java.util.List;

import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.StaffMemberNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.model.OfficeStaffMemberDTO;


public interface IManagerService {

	public OfficeStaffMemberDTO addStaffMember(OfficeStaffMember staffmember) throws StaffMemberNotFoundException ;
	public OfficeStaffMemberDTO removeStaffMember(int empId)  throws StaffMemberNotFoundException;
	
	public OfficeStaffMemberDTO getStaffMember(int empid) throws StaffMemberNotFoundException;
	public List<OfficeStaffMemberDTO> getAllStaffMembers();
	
	public String getCourierStatus(int courierId) throws CourierNotFoundException;
	
	public ComplaintDTO getRegistedComplaint(int complaintid) throws ComplaintNotFoundException;
	public List<ComplaintDTO> getAllComplaints();
}
