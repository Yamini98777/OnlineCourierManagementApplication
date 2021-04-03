package com.capg.ocma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.StaffMemberNotFoundException;
import com.capg.ocma.model.OfficeStaffMemberDTO;
import com.capg.ocma.repository.IComplaintDao;
import com.capg.ocma.repository.IStaffMemberDao;
import com.capg.ocma.util.OfficeStaffMemberUtil;

@Service
public class ManagerServiceImp implements IManagerService {

	@Autowired
	IStaffMemberDao repo;
	
	@Autowired
	IComplaintDao complaintRepo; 

	@Override
	public void addStaffMember(OfficeStaffMember staffMember) {
		repo.save(staffMember);
	}

	public static boolean validateOfficeStaffMember(OfficeStaffMember officeStaffMember) 
	{

		boolean flag = false;
		
		if (officeStaffMember.getName().length() > 5 && officeStaffMember.getEmpid() > 4) 
		{
			flag = true;
		}
		
		return flag;
	}

	@Override
	public void removeStaffMember(OfficeStaffMember staffMember) {
		repo.deleteById(staffMember.getEmpid());
	}

	@Override
	public OfficeStaffMemberDTO getStaffMember(int empId) throws StaffMemberNotFoundException {
		
		OfficeStaffMember officeStaffMember = repo.findById(empId).orElse(null);
		if(officeStaffMember.getName().matches("^[a-zA-Z]+$") && Integer.toString(officeStaffMember.getEmpid()).matches("^[0-9]+$"))	
		{
			return OfficeStaffMemberUtil.convertToOfficeStaffMemberDTO(officeStaffMember);
		}
		else
			throw new StaffMemberNotFoundException("Staff member not found.");
	}

	@Override
	public List<OfficeStaffMemberDTO> getAllStaffMembers() {
		List<OfficeStaffMember> list = repo.findAll();
		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDtoList(list);
	}

	@Override
	public boolean getCourierStatus(Courier courier) throws CourierNotFoundException {
		return repo.findById(courier.getCourierid()) != null;
	}

	@Override
	public Complaint getRegistedComplaint(int complaintId) throws ComplaintNotFoundException {
		return complaintRepo.findById(complaintId).orElse(null);
	}

	@Override
	public List<Complaint> getAllComplaints() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<ComplaintDTO> getAllComplaints() {
//		List<Complaint> list = complaintRepo.findAll();
//		return ComplaintUtil.convertToComplaintDtoList(list);
//	}

}
