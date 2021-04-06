package com.capg.ocma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.CourierStatus;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.service.CustomerServiceImp;
import com.capg.ocma.service.ICustomerService;


@RestController
@RequestMapping("/api/ocma/customer")
public class ComplaintController {


		@Autowired
		ICustomerService customerService;
		
		
		@GetMapping("/checkStatus/{consignmentNo}")
		public ResponseEntity <CourierStatus> checkCourierStatusAction(@PathVariable int consignmentNo)  {

				CourierStatus status = customerService.checkOnlineTrackingStatus(consignmentNo);
				ResponseEntity <CourierStatus> response = new ResponseEntity <CourierStatus> ( status, HttpStatus.OK);
				return response;
		}
		@PostMapping("/add-complaint")
		public ResponseEntity<ComplaintDTO> registerComplaint(@RequestBody Complaint complaint) throws ComplaintNotFoundException {
			
			ComplaintDTO  complaintDTO= null;
			ResponseEntity<ComplaintDTO> complaintResponse = null;
			
		
				
				complaintDTO = customerService.registerComplaint(complaint);
				complaintResponse = new ResponseEntity<ComplaintDTO>(complaintDTO, HttpStatus.ACCEPTED);
			
			return complaintResponse;
			
		}
}