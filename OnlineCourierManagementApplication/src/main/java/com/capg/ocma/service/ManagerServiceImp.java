package com.capg.ocma.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.controller.ManagerController;
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
 * Author      : YAMINI C
 * Version     : 1.0
 * Date        : 04-04-2021
 * Description : This is Manager Service Layer that provides operations such as add, delete and view staff members, view complaints and courier status.
*/


@Service
public class ManagerServiceImp implements IManagerService {

	final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	@Autowired
	private IStaffMemberDao staffRepo;
	
	@Autowired
	private IComplaintDao complaintRepo;
	
	@Autowired
	private ICourierDao courierRepo;
	
	static String staffMemberNotFound = "No Staff Member found with given ID";
	
	/*
	 * Description     : This method adds new Office Staff Member
	 * Input Parameter : OfficeStaffMember Object 
	 * Return Value    : OfficeStaffMemberDTO Object 
	 * Exception       : StaffMemberNotFoundException
	 */
	
	@Override
	public OfficeStaffMemberDTO addStaffMember(OfficeStaffMember staffMember) throws StaffMemberNotFoundException  {
		
		logger.info("addStaffMember() service is initiated");

		OfficeStaffMember staffMemberEntity = null;
		if (staffMember == null)
			staffMemberEntity = null;
		else
		{
			validateOfficeStaffMember(staffMember);
			staffMemberEntity = staffRepo.save(staffMember);
		}
		logger.info("addStaffMember() service has executed");
		
		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDTO(staffMemberEntity);
	}

	/*
	 * Description     : This method deletes existing Office Staff Member
	 * Input Parameter : Integer 
	 * Return Value    : OfficeStaffMemberDTO Object 
	 * Exception       : StaffMemberNotFoundException
	 */
	
	@Override
	public OfficeStaffMemberDTO removeStaffMember(int empId) throws StaffMemberNotFoundException {
		
		logger.info("removeStaffMember() service is initiated");
		
		OfficeStaffMember existStaffMember = staffRepo.findById(empId).orElse(null);
				
		if(existStaffMember == null)
			throw new StaffMemberNotFoundException(staffMemberNotFound);
		else
			staffRepo.delete(existStaffMember);
		
		logger.info("removeStaffMember() service has executed");
		
		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDTO(existStaffMember);
	}

	/*
	 * Description     : This method shows existing Office Staff Member by their ID
	 * Input Parameter : Integer
	 * Return Value    : OfficeStaffMemberDTO Object 
	 * Exception       : StaffMemberNotFoundException
	 */
	
	@Override
	public OfficeStaffMemberDTO getStaffMember(int empId) throws StaffMemberNotFoundException {
		
		logger.info("getStaffMember() service is initiated");
		
		OfficeStaffMember existStaffMember = staffRepo.findById(empId).orElse(null);
		
		if(existStaffMember == null)
			throw new StaffMemberNotFoundException(staffMemberNotFound);
		
		logger.info("getStaffMember() service has executed");
		
		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDTO(existStaffMember);
	}

	/*
	 * Description  : This method shows all existing Office Staff Member
	 * Return Value : List<OfficeStaffMemberDTO>
	 */
	
	@Override
	public List<OfficeStaffMemberDTO> getAllStaffMembers() {
		
		logger.info("getAllStaffMembers() service is initiated");
		
		List<OfficeStaffMember> list = staffRepo.findAll();
		
		logger.info("getAllStaffMembers() service has executed");
		
		return OfficeStaffMemberUtil.convertToOfficeStaffMemberDtoList(list);
	}

	/*
	 * Description     : This method shows existing Office Staff Member by their ID
	 * Input Parameter : Courier Object
	 * Return Value    : String 
	 * Exception       : CourierNotFoundException
	 */
	
	@Override
	public String getCourierStatus(int courierId) throws CourierNotFoundException {
		
		logger.info("getCourierStatus() service is initiated");
		
		Courier courier= courierRepo.findById(courierId).orElse(null);
		
		String status;
		
		if(courier == null)
			throw new CourierNotFoundException("No Courier found with given ID");
		else
			status = courier.getStatus();
		logger.info("getCourierStatus() service has executed");
		
		return  status;
	}

	/*
	 * Description     : This method shows registered Complaint by ID
	 * Input Parameter : Integer
	 * Return Value    : ComplaintDTO Object 
	 * Exception       : ComplaintNotFoundException
	 */
	@Override
	public ComplaintDTO getRegistedComplaint(int complaintId) throws ComplaintNotFoundException {
		
		logger.info("getRegistedComplaint() service is initiated");
		
		Complaint complaint = complaintRepo.findById(complaintId).orElse(null);
		
		if(complaint == null)
			throw new ComplaintNotFoundException("No Complaint found with given ID");
		
		logger.info("getRegistedComplaint() service has executed");
		
		return ComplaintUtil.convertToComplaintDTO(complaint);
	}
	

	/*
	 * Description  : This method shows all registered Complaints
	 * Return Value : List<ComplaintDTO>
	 */
	
	@Override
	public List<ComplaintDTO> getAllComplaints() {
		
		logger.info("getAllComplaints() service is initiated");
		
		List<Complaint> list = complaintRepo.findAll();
		
		logger.info("getAllComplaints() service has executed");
		
		return ComplaintUtil.convertToComplaintDtoList(list);
	}

	/*
	 * VALIDATIONS
	 */
	
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
	
   /*
	* NAME VALIDATION
	*/
	
	public static boolean validateName(String name) throws StaffMemberNotFoundException
	{
		boolean flag = false;
		if(name == null)
			throw new StaffMemberNotFoundException("Name cannot be empty");
		else if(!name.matches("^[a-zA-Z ]+$"))
			throw new StaffMemberNotFoundException("Name cannot contain Numbers or Special Characters");
		else
			flag = true;
		return flag;
	}
	
   /*
	* ROLE VALIDATION
	*/
	
	public static boolean validateRole(String role) throws StaffMemberNotFoundException
	{
		boolean flag = false;
		if(role == null)
			throw new StaffMemberNotFoundException("Role cannot be empty");
		
		else if(!role.matches("^[a-zA-Z ]+$"))
			throw new StaffMemberNotFoundException("Role cannot contain Numbers or Special Characters");
		
		else if(role.equals("Analyst") || role.equals("Senior Analyst") || role.equals("Manager"))
			flag = true;
		else
			throw new StaffMemberNotFoundException("Invalid role");
		return flag;
	}

	
}

