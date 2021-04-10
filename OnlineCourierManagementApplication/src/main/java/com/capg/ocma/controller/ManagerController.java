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
	
	
	@PostMapping("/add-staff")
	public ResponseEntity<OfficeStaffMemberDTO> addStaffMember(@RequestBody OfficeStaffMember staffMember) throws StaffMemberNotFoundException {
		
		logger.info("add-staff URL is opened");
		logger.info("addStaffMember() is initiated");
		
		OfficeStaffMemberDTO  staffMemberDTO= managerService.addStaffMember(staffMember);
		
		logger.info("addStaffMember() has executed");
		
		return new ResponseEntity<OfficeStaffMemberDTO>(staffMemberDTO, HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/delete-staff/{empId}")
	public ResponseEntity<OfficeStaffMemberDTO> removeStaffMember(@PathVariable int empId) throws StaffMemberNotFoundException  {
		
		logger.info("delete-staff URL is opened");
		logger.info("removeStaffMember() is initiated");
		
		OfficeStaffMemberDTO  staffMemberDTO= managerService.removeStaffMember(empId);
		
		logger.info("removeStaffMember() has executed");
		
		return new ResponseEntity<OfficeStaffMemberDTO>(staffMemberDTO, HttpStatus.ACCEPTED);
	}
	
//	@DeleteMapping("/delete-staff/{empId}")
//	public ResponseEntity<OfficeStaffMemberDTO> removeStaffMember(@PathVariable int empId) throws StaffMemberNotFoundException  {
//		
//		OfficeStaffMemberDTO staffMemberDTO = null;
//		ResponseEntity<OfficeStaffMemberDTO> staffMemberResponse = null;
//		
//		if(ManagerServiceImp.validateEmpId(empId))
//		{
//			staffMemberDTO = managerService.removeStaffMember(empId);
//			staffMemberResponse = new ResponseEntity<OfficeStaffMemberDTO>(staffMemberDTO, HttpStatus.ACCEPTED);
//			logger.info("Staff member deleted");
//		}
//		else
//			throw new StaffMemberNotFoundException("Invalid data");
//		
//		return staffMemberResponse;
//	}
	
	
	@GetMapping("/get-staff/{empId}")
	public ResponseEntity<OfficeStaffMemberDTO> getStaffMember(@PathVariable int empId) throws StaffMemberNotFoundException  {
		
		logger.info("get-staff URL is opened");
		logger.info("getStaffMember() is initiated");
		
		OfficeStaffMemberDTO staffMemberDTO = managerService.getStaffMember(empId);
		
		logger.info("getStaffMember() has executed");
		
		return new ResponseEntity<OfficeStaffMemberDTO>(staffMemberDTO, HttpStatus.ACCEPTED);

	}
	
//	@GetMapping("/get-staff/{empId}")
//	public ResponseEntity<OfficeStaffMemberDTO> getStaffMember(@PathVariable int empId) throws StaffMemberNotFoundException  {
//		
//		OfficeStaffMemberDTO staffMemberDTO = null;
//		ResponseEntity<OfficeStaffMemberDTO> staffMemberResponse = null;
//		
//		if(ManagerServiceImp.validateEmpId(empId))
//		{
//			staffMemberDTO = managerService.getStaffMember(empId);
//			staffMemberResponse = new ResponseEntity<OfficeStaffMemberDTO>(staffMemberDTO, HttpStatus.ACCEPTED);
//		}
//		else
//			throw new StaffMemberNotFoundException("No Staff Member available with given ID");
//		return staffMemberResponse;
//
//	}
	
	
	@GetMapping("/get-all-staff")
	public List<OfficeStaffMemberDTO> getAllStaffMembers() {
		
		logger.info("get-all-staff URL is opened");
		logger.info("getAllStaffMembers() is initiated");
		
		return managerService.getAllStaffMembers();
	}
	
	@GetMapping("/get-courier-status/{courierId}")
	public String getCourierStatus(@PathVariable int courierId) throws CourierNotFoundException{
		
		logger.info("get-courier-status URL is opened");
		logger.info("getCourierStatus() is initiated");
		
		String courierStatus = managerService.getCourierStatus(courierId);;
		
		logger.info("getCourierStatus() has executed");
		 
		return courierStatus;

	}
	
//	@GetMapping("/get-courier-status/{courierId}")
//	public String getCourierStatus(@PathVariable int courierId) throws CourierNotFoundException{
//		
//		String courierStatus;
//		
//		if(courierId <=0)
//			throw new CourierNotFoundException("Invalid data");
//		else
//			courierStatus = managerService.getCourierStatus(courierId);
//		return courierStatus;
//
//	}
	
	@GetMapping("/get-complaint-byid/{complaintId}")
	public ResponseEntity<ComplaintDTO> getRegistedComplaint(@PathVariable int complaintId) throws ComplaintNotFoundException{
		
		logger.info("get-complaint-byid URL is opened");
		logger.info("getRegistedComplaint() is initiated");
		
		ComplaintDTO complaintDTO = managerService.getRegistedComplaint(complaintId);
		
		logger.info("getRegistedComplaint() has executed");
			
		return new ResponseEntity<ComplaintDTO>(complaintDTO, HttpStatus.ACCEPTED);
	}
	
//	@GetMapping("/get-complaint-byid/{complaintId}")
//	public ResponseEntity<ComplaintDTO> getRegistedComplaint(@PathVariable int complaintId) throws ComplaintNotFoundException{
//		
//		ComplaintDTO complaintDTO = null;
//		ResponseEntity<ComplaintDTO> complaintResponse = null;
//		
//		if(complaintId<=0)
//		{
//			throw new ComplaintNotFoundException("No Complaint available with given ID");
//		}
//		else
//		{
//			complaintDTO = managerService.getRegistedComplaint(complaintId);
//			complaintResponse = new ResponseEntity<ComplaintDTO>(complaintDTO, HttpStatus.ACCEPTED);
//		}
//			
//		return complaintResponse;
//	}
	
	@GetMapping("/get-all-complaint")
	public List<ComplaintDTO> getAllComplaints() {
		
		logger.info("get-all-complaint URL is opened");
		logger.info("getAllComplaints() is initiated");
		
		return managerService.getAllComplaints();
	}
	
	
}
