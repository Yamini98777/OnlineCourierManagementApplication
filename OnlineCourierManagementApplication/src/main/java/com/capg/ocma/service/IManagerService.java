package com.capg.ocma.service;

import java.util.List;

import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.CourierStatus;
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.model.OfficeStaffMemberDTO;


public interface IManagerService {

	public OfficeStaffMemberDTO addStaffMember(OfficeStaffMember staffmember);
	public OfficeStaffMemberDTO removeStaffMember(int empId);
	
	public OfficeStaffMemberDTO getStaffMember(int empid);
	public List<OfficeStaffMemberDTO> getAllStaffMembers();
	
	public CourierStatus getCourierStatus(Courier courier) throws CourierNotFoundException;
	
	public ComplaintDTO getRegistedComplaint(int complaintid) throws ComplaintNotFoundException;
	public List<ComplaintDTO> getAllComplaints();
}
