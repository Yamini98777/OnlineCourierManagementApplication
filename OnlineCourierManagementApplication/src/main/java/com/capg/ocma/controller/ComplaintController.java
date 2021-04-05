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


@RestController
@RequestMapping("/api/Complaint")
public class ComplaintController {


		@Autowired
		CustomerServiceImp customerService;
		
		
		@GetMapping("/{customerid}/checkStatus/{consignmentno}")
		public ResponseEntity <CourierStatus> checkCourierStatusAction(@PathVariable("consignmentno") int consignmentno)  {

				CourierStatus status = customerService.checkOnlineTrackingStatus(consignmentno);
				ResponseEntity <CourierStatus> response = new ResponseEntity <> ( status, HttpStatus.OK);
				return response;
		}
		@PostMapping("/add-complaint")
		public ResponseEntity<ComplaintDTO> registerComplaint(@RequestBody Complaint complaint) throws ComplaintNotFoundException {
			
			ComplaintDTO  complaintDTO= null;
			ResponseEntity<ComplaintDTO> complaintResponse = null;
			
			if(CustomerServiceImp.validateComplaintId(complaint.getComplaintId()))
			{
				
				complaintDTO = customerService.registerComplaint(complaint);
				complaintResponse = new ResponseEntity<ComplaintDTO>(complaintDTO, HttpStatus.ACCEPTED);
			}
			else
				throw new ComplaintNotFoundException("Invalid Complaint Details");
			return complaintResponse;
		}
}