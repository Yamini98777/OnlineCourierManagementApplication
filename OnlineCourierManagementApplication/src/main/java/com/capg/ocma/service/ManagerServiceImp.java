package com.capg.ocma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.CourierStatus;
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.StaffMemberNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.model.OfficeStaffMemberDTO;
import com.capg.ocma.repository.IComplaintDao;
import com.capg.ocma.repository.ICourierDao;
import com.capg.ocma.repository.IStaffMemberDao;
import com.capg.ocma.util.ComplaintUtil;
import com.capg.ocma.util.OfficeStaffMemberUtil;

@Service
public class ManagerServiceImp implements IManagerService {

	@Autowired
	IStaffMemberDao repo;
	
	@Autowired
	IComplaintDao complaintRepo;
	
	@Autowired
	ICourierDao courierRepo;
	
	static String staffMemberNotFound = "No Staff Member found with given ID";
	
	
	
	@Override
	public OfficeStaffMemberDTO addStaffMember(OfficeStaffMember staffMember) {

		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDTO(repo.save(staffMember));
	}

	
	@Override
	public OfficeStaffMemberDTO removeStaffMember(int empId) throws StaffMemberNotFoundException {
		
		OfficeStaffMember existStaffMember = repo.findById(empId).orElse(null);
				
		if(existStaffMember == null)
			throw new StaffMemberNotFoundException(staffMemberNotFound);
		else
			repo.delete(existStaffMember);
		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDTO(existStaffMember);
	}

	
	@Override
	public OfficeStaffMemberDTO getStaffMember(int empId) throws StaffMemberNotFoundException {
		
		OfficeStaffMember existStaffMember = repo.findById(empId).orElse(null);
		
		if(existStaffMember == null)
			throw new StaffMemberNotFoundException(staffMemberNotFound);
		
		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDTO(existStaffMember);
	}

	
	@Override
	public List<OfficeStaffMemberDTO> getAllStaffMembers() {
		List<OfficeStaffMember> list = repo.findAll();
		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDtoList(list);
	}

	
	@Override
	public CourierStatus getCourierStatus(Courier courier) throws CourierNotFoundException {
		
		CourierStatus status = courier.getStatus();
		
		courier= courierRepo.findById(courier.getCourierId()).orElse(null);
		
		if(courier == null)
			throw new CourierNotFoundException("No Courier found with given ID");
		
		return  status;
	}

	
	@Override
	public ComplaintDTO getRegistedComplaint(int complaintId) throws ComplaintNotFoundException {
		
		Complaint complaint = complaintRepo.findById(complaintId).orElse(null);
		
		if(complaint == null)
			throw new ComplaintNotFoundException("No Complaint found with given ID");
		
		return ComplaintUtil.convertToComplaintDTO(complaint);
	}

	
	@Override
	public List<ComplaintDTO> getAllComplaints() {
		List<Complaint> list = complaintRepo.findAll();
		return ComplaintUtil.convertToComplaintDtoList(list);
	}

	
	//VALIDATIONS 
	public static boolean validateOfficeStaffMember(OfficeStaffMember officeStaffMember) throws StaffMemberNotFoundException
	{
		boolean flag = false;
		if(officeStaffMember == null)
			throw new StaffMemberNotFoundException("Staff member details cannot be blank");
		
		else if(!(validateName(officeStaffMember.getName()) && validateRole(officeStaffMember.getRole())))
			throw new StaffMemberNotFoundException("Invalid Data");
		
		else
			flag = true;
		
		return flag;
	}
	
	//validate empId
	public static boolean validateEmpId(int empId) throws StaffMemberNotFoundException
	{
		boolean flag = false;
		if(empId<=0)
			throw new StaffMemberNotFoundException(staffMemberNotFound);
		else
			flag=true;
		return flag;
	}
	
	//validate name
	public static boolean validateName(String name) throws StaffMemberNotFoundException
	{
		boolean flag = false;
		if(name == null)
			throw new StaffMemberNotFoundException("Name cannot be empty");
		else if(!name.matches("^[a-zA-Z]+$"))
			throw new StaffMemberNotFoundException("Name cannot contain Numbers or Special Characters");
		else
			flag = true;
		return flag;
	}
	
	//validate role
	public static boolean validateRole(String role) throws StaffMemberNotFoundException
	{
		boolean flag = false;
		if(role == null)
			throw new StaffMemberNotFoundException("Role cannot be empty");
		
		else if(!role.matches("^[a-zA-Z]+$"))
			throw new StaffMemberNotFoundException("Role cannot contain Numbers or Special Characters");
		
		else if(role.equals("Analyst") || role.equals("Senior Analyst") || role.equals("Manager"))
			flag = true;
		
		return flag;
	}
}

