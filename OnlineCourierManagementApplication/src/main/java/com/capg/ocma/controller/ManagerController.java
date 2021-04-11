package com.capg.ocma.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.StaffMemberNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.model.OfficeStaffMemberDTO;
import com.capg.ocma.service.IManagerService;


/*
 * Author : YAMINI C
 * Version : 1.0
 * Date : 05-04-2021
 * Description : This is Manager Controller
*/


@RestController
@RequestMapping("/api/ocma/manager")
public class ManagerController {

	@Autowired
	private IManagerService managerService;
	
	final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	/********************************************************************************************************************************
	 * Method              : addStaffMember 
	 * Description         : It is used to add Office Staff Members into office_staff_member table
	 * @param staffMember  : OfficeStaffMember Object
	 * @returns            : It returns OfficeStaffMemberDTO Object with details
	 * @PostMapping        : It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody        : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception          : StaffMemberNotFoundException
	 * Created By          : YAMINI C
     * Created Date        : 05-04-2021 
	 * 
	 *********************************************************************************************************************************/
	
	@PostMapping("/add-staff")
	public ResponseEntity<OfficeStaffMemberDTO> addStaffMember(@RequestBody OfficeStaffMember staffMember) throws StaffMemberNotFoundException {
		
		logger.info("add-staff URL is opened");
		logger.info("addStaffMember() is initiated");
		
		OfficeStaffMemberDTO  staffMemberDTO= managerService.addStaffMember(staffMember);
		
		logger.info("addStaffMember() has executed");
		
		return new ResponseEntity<>(staffMemberDTO, HttpStatus.ACCEPTED);
	}
	
	/********************************************************************************************************************************
	 * Method        : removeStaffMember
	 * Description   : It is used to remove Staff Member from office_staff_member table
	 * @param empId  : int empId
	 * @returns      : It returns OfficeStaffMemberDTO Object with details
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URI expression.
	 * @RequestBody  : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception    : StaffMemberNotFoundException
	 * Created By    : YAMINI C
     * Created Date  : 05-04-2021
	 * 
	 *********************************************************************************************************************************/
	
	@DeleteMapping("/delete-staff/{empId}")
	public ResponseEntity<OfficeStaffMemberDTO> removeStaffMember(@PathVariable int empId) throws StaffMemberNotFoundException  {
		
		logger.info("delete-staff URL is opened");
		logger.info("removeStaffMember() is initiated");
		
		OfficeStaffMemberDTO  staffMemberDTO= managerService.removeStaffMember(empId);
		
		logger.info("removeStaffMember() has executed");
		
		return new ResponseEntity<>(staffMemberDTO, HttpStatus.ACCEPTED);
	}
	
	/********************************************************************************************************************************
	 * Method        : getStaffMember
	 * Description   : It is used to view Staff Member from office_staff_member table
	 * @param empId  : int empId
	 * @returns      : It returns OfficeStaffMemberDTO Object with details
	 * @GetMapping   : It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody  : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception    : StaffMemberNotFoundException
	 * Created By    : YAMINI C
     * Created Date  : 05-04-2021
	 * 
	 *********************************************************************************************************************************/
	
	@GetMapping("/get-staff/{empId}")
	public ResponseEntity<OfficeStaffMemberDTO> getStaffMember(@PathVariable int empId) throws StaffMemberNotFoundException  {
		
		logger.info("get-staff URL is opened");
		logger.info("getStaffMember() is initiated");
		
		OfficeStaffMemberDTO staffMemberDTO = managerService.getStaffMember(empId);
		
		logger.info("getStaffMember() has executed");
		
		return new ResponseEntity<>(staffMemberDTO, HttpStatus.ACCEPTED);

	}
	
	/********************************************************************************************************************************
	 * Method        : getAllStaffMembers
	 * Description   : It is used to view all Staff Member from office_staff_member table
	 * @returns      : It returns all List<OfficeStaffMemberDTO> Object with details
	 * @GetMapping   : It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody  : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By    : YAMINI C
     * Created Date  : 05-04-2021
	 * 
	 *********************************************************************************************************************************/
	
	@GetMapping("/get-all-staff")
	public List<OfficeStaffMemberDTO> getAllStaffMembers() {
		
		logger.info("get-all-staff URL is opened");
		logger.info("getAllStaffMembers() is initiated");
		
		return managerService.getAllStaffMembers();
	}
	
	/********************************************************************************************************************************
	 * Method           : getCourierStatus
	 * Description      : It is used to view Courier Status from courier table
	 * @param courierId : int courierId
	 * @returns         : It returns String with courier status
	 * @GetMapping      : It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody     : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception       : CourierNotFoundException
	 * Created By       : YAMINI C
     * Created Date     : 05-04-2021
	 * 
	 *********************************************************************************************************************************/
	
	@GetMapping("/get-courier-status/{courierId}")
	public String getCourierStatus(@PathVariable int courierId) throws CourierNotFoundException{
		
		logger.info("get-courier-status URL is opened");
		logger.info("getCourierStatus() is initiated");
		
		String courierStatus = managerService.getCourierStatus(courierId);
		
		logger.info("getCourierStatus() has executed");
		 
		return courierStatus;

	}

	/********************************************************************************************************************************
	 * Method             : getRegistedComplaint
	 * Description        : It is used to view Complaint from complaint table
	 * @param complaintId : int complaintId
	 * @returns           : It returns ComplaintDTO Object with details
	 * @GetMapping        : It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody       : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception         : ComplaintNotFoundException
	 * Created By         : YAMINI C
     * Created Date       : 05-04-2021
	 * 
	 *********************************************************************************************************************************/
	
	@GetMapping("/get-complaint-byid/{complaintId}")
	public ResponseEntity<ComplaintDTO> getRegistedComplaint(@PathVariable int complaintId) throws ComplaintNotFoundException{
		
		logger.info("get-complaint-byid URL is opened");
		logger.info("getRegistedComplaint() is initiated");
		
		ComplaintDTO complaintDTO = managerService.getRegistedComplaint(complaintId);
		
		logger.info("getRegistedComplaint() has executed");
			
		return new ResponseEntity<>(complaintDTO, HttpStatus.ACCEPTED);
	}
	
	/********************************************************************************************************************************
	 * Method       : getAllComplaints
	 * Description  : It is used to view all Complaint details present in complaint table
	 * @returns     : It returns all List<ComplaintDTO> Object with details
	 * @GetMapping  : It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By   : YAMINI C
     * Created Date : 05-04-2021 
	 * 
	 *********************************************************************************************************************************/
	
	@GetMapping("/get-all-complaint")
	public List<ComplaintDTO> getAllComplaints() {
		
		logger.info("get-all-complaint URL is opened");
		logger.info("getAllComplaints() is initiated");
		
		return managerService.getAllComplaints();
	}
	
	
}
