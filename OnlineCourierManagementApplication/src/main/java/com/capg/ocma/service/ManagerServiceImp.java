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
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.model.OfficeStaffMemberDTO;
import com.capg.ocma.repository.IComplaintDao;
import com.capg.ocma.repository.ICourierDao;
import com.capg.ocma.repository.IStaffMemberDao;
import com.capg.ocma.util.ComplaintUtil;
import com.capg.ocma.util.OfficeStaffMemberUtil;


/*
 * Author : YAMINI C
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Manager Service Layer
*/


@Service
public class ManagerServiceImp implements IManagerService {

	@Autowired
	private IStaffMemberDao repo;
	
	@Autowired
	private IComplaintDao complaintRepo;
	
	@Autowired
	private ICourierDao courierRepo;
	
	static String staffMemberNotFound = "No Staff Member found with given ID";
	
	/*
	 * Description : This method adds new Office Staff Member
	 * Input Param : OfficeStaffMember Object 
	 * Return Value : OfficeStaffMemberDTO Object 
	 */
	
	@Override
	public OfficeStaffMemberDTO addStaffMember(OfficeStaffMember staffMember) {

		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDTO(repo.save(staffMember));
	}

	/*
	 * Description : This method deletes existing Office Staff Member
	 * Input Param : Integer 
	 * Return Value : OfficeStaffMemberDTO Object 
	 * Exception : StaffMemberNotFoundException
	 */
	
	@Override
	public OfficeStaffMemberDTO removeStaffMember(int empId) throws StaffMemberNotFoundException {
		
		OfficeStaffMember existStaffMember = repo.findById(empId).orElse(null);
				
		if(existStaffMember == null)
			throw new StaffMemberNotFoundException(staffMemberNotFound);
		else
			repo.delete(existStaffMember);
		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDTO(existStaffMember);
	}

	/*
	 * Description : This method shows existing Office Staff Member by their ID
	 * Input Param : Integer
	 * Return Value : OfficeStaffMemberDTO Object 
	 * Exception : StaffMemberNotFoundException
	 */
	
	@Override
	public OfficeStaffMemberDTO getStaffMember(int empId) throws StaffMemberNotFoundException {
		
		OfficeStaffMember existStaffMember = repo.findById(empId).orElse(null);
		
		if(existStaffMember == null)
			throw new StaffMemberNotFoundException(staffMemberNotFound);
		
		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDTO(existStaffMember);
	}

	/*
	 * Description : This method shows all existing Office Staff Member
	 * Return Value : List<OfficeStaffMemberDTO>
	 */
	
	@Override
	public List<OfficeStaffMemberDTO> getAllStaffMembers() {
		List<OfficeStaffMember> list = repo.findAll();
		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDtoList(list);
	}

	/*
	 * Description : This method shows existing Office Staff Member by their ID
	 * Input Param : Courier Object
	 * Return Value : String 
	 * Exception : CourierNotFoundException
	 */
	
	@Override
	public String getCourierStatus(Courier courier) throws CourierNotFoundException {
		
		String status = courier.getStatus();
		
		courier= courierRepo.findById(courier.getCourierId()).orElse(null);
		
		if(courier == null)
			throw new CourierNotFoundException("No Courier found with given ID");
		
		return  status;
	}

	/*
	 * Description : This method shows registered Complaint by ID
	 * Input Param : Integer
	 * Return Value : ComplaintDTO Object 
	 * Exception : ComplaintNotFoundException
	 */
	
	@Override
	public ComplaintDTO getRegistedComplaint(int complaintId) throws ComplaintNotFoundException {
		
		Complaint complaint = complaintRepo.findById(complaintId).orElse(null);
		
		if(complaint == null)
			throw new ComplaintNotFoundException("No Complaint found with given ID");
		
		return ComplaintUtil.convertToComplaintDTO(complaint);
	}

	/*
	 * Description : This method shows all registered Complaints
	 * Return Value : List<ComplaintDTO>
	 */
	
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

