package com.capg.ocma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.model.CustomerDTO;
import com.capg.ocma.service.ICustomerService;


@RestController
@RequestMapping("/api/ocma/customer")
@CrossOrigin
public class ComplaintController {
	


		@Autowired
		private ICustomerService customerService;
		
		
		
		
		
		@GetMapping("/checkStatus/{consignmentNo}")
		public ResponseEntity <String> checkCourierStatusAction(@PathVariable int consignmentNo) throws CourierNotFoundException   {

				String status = customerService.checkOnlineTrackingStatus(consignmentNo);
				ResponseEntity <String> response = new ResponseEntity <String> ( status, HttpStatus.OK);
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
		
		@PostMapping("/add-customer")
		public ResponseEntity<CustomerDTO> addCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
			
			CustomerDTO  customerDTO= null;
			ResponseEntity<CustomerDTO> customerResponse = null;
			
		
				
			customerDTO = customerService.addCustomer(customer);
			customerResponse = new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.ACCEPTED);
			
			return customerResponse;
			
		}
}