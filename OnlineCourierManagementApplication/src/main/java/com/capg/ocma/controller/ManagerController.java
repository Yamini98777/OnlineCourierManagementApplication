package com.capg.ocma.controller;

import java.util.List;
import java.util.Optional;

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

import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.CourierStatus;
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.StaffMemberNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.model.OfficeStaffMemberDTO;
import com.capg.ocma.service.IManagerService;
import com.capg.ocma.service.ManagerServiceImp;

@RestController
@RequestMapping("/api/ocma/manager")
public class ManagerController {

	@Autowired
	IManagerService managerService;
	
	ManagerServiceImp service;
	
	
	@PostMapping("/add-staff")
	public ResponseEntity<OfficeStaffMemberDTO> addStaffMember(@RequestBody OfficeStaffMember staffMember) throws StaffMemberNotFoundException {
		
		OfficeStaffMemberDTO  staffMemberDTO= null;
		ResponseEntity<OfficeStaffMemberDTO> staffMemberResponse = null;
		
			if(ManagerServiceImp.validateOfficeStaffMember(staffMember))
			{
				staffMemberDTO = managerService.addStaffMember(staffMember);
				staffMemberResponse = new ResponseEntity<OfficeStaffMemberDTO>(staffMemberDTO, HttpStatus.ACCEPTED);
			}
			else
				throw new StaffMemberNotFoundException("Invalid data");
		return staffMemberResponse;
	}
		
	
	@DeleteMapping("/delete-staff")
	public ResponseEntity<OfficeStaffMemberDTO> removeStaffMember(@PathVariable int empId) throws StaffMemberNotFoundException  {
		
		OfficeStaffMemberDTO staffMemberDTO = null;
		ResponseEntity<OfficeStaffMemberDTO> staffMemberResponse = null;
		
		Optional<OfficeStaffMemberDTO> optional;
		optional = Optional.of(managerService.removeStaffMember(empId));
		if(optional.isPresent())
		{
			staffMemberDTO = optional.get();
			staffMemberResponse = new ResponseEntity<OfficeStaffMemberDTO>(staffMemberDTO, HttpStatus.ACCEPTED);
		}
		else
			throw new StaffMemberNotFoundException("Invalid data");
		
		return staffMemberResponse;
	}
	
	
	@GetMapping("/get-staff/{empId}")
	public ResponseEntity<OfficeStaffMemberDTO> getStaffMember(@PathVariable int empId) throws StaffMemberNotFoundException  {
		
		OfficeStaffMemberDTO staffMemberDTO = null;
		ResponseEntity<OfficeStaffMemberDTO> staffMemberResponse = null;
		
		if(service.validateEmpId(empId))
		{
			staffMemberDTO = managerService.getStaffMember(empId);
			staffMemberResponse = new ResponseEntity<OfficeStaffMemberDTO>(staffMemberDTO, HttpStatus.ACCEPTED);
		}
		else
			throw new StaffMemberNotFoundException("No Staff Member available with given ID");
		return staffMemberResponse;

	}
	
	
	@GetMapping("/get-all-staff")
	public List<OfficeStaffMemberDTO> getAllStaffMembers() {
		
		return managerService.getAllStaffMembers();
	}
	
	
	@GetMapping("/get-courier-status/")
	public CourierStatus getCourierStatus(@RequestBody Courier courier) throws CourierNotFoundException{
		
		CourierStatus courierStatus;
		
		if(courier == null)
			throw new CourierNotFoundException("Invalid data");
		else
			courierStatus = managerService.getCourierStatus(courier);
		return courierStatus;

	}
	
	
	@GetMapping("/get-complaint-byid/{complaintId}")
	public ResponseEntity<ComplaintDTO> getRegistedComplaint(int complaintId) throws ComplaintNotFoundException{
		
		ComplaintDTO complaintDTO = null;
		ResponseEntity<ComplaintDTO> complaintResponse = null;
		
		Optional<ComplaintDTO> optional = Optional.of(managerService.getRegistedComplaint(complaintId));
		if(optional.isPresent())
		{
			complaintDTO = optional.get();
			complaintResponse = new ResponseEntity<ComplaintDTO>(complaintDTO, HttpStatus.ACCEPTED);
		}
		else
			throw new ComplaintNotFoundException("No Complaint available with given ID");
		return complaintResponse;
	}
	
	@GetMapping("/get-all-complaint")
	public List<ComplaintDTO> getAllComplaints() {
		
		return managerService.getAllComplaints();
	}
	
	
}
