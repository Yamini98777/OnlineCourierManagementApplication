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
import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.model.CustomerDTO;
import com.capg.ocma.service.ICustomerService;


@RestController
@RequestMapping("/api/ocma/customer")
public class ComplaintController {
	


		@Autowired
		private ICustomerService customerService;
		/********************************************
		 * Method              : checkCourierStatusAction 
		 * Description         : It is used to check the status of the courier
		 * @param courier      : Courier consignmentNo
		 * @returns            : It returns status of the  Response Entity of the courier  
		 * @GetMapping         : It is used to handle the HTTP POST requests matched with given URI expression.
		 * @RequestBody        : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
		 * @exception          : CourierNotFoundException
		 * Created By          : GOMATHI M 
	     * Created Date        : 05-04-2021 
		 * 
		 *******************************************/
		
		
		
		
		@GetMapping("/checkStatus/{consignmentNo}")
		public ResponseEntity <String> checkCourierStatusAction(@PathVariable int consignmentNo) throws CourierNotFoundException   {

				String status = customerService.checkOnlineTrackingStatus(consignmentNo);
				ResponseEntity <String> response = new ResponseEntity <String> ( status, HttpStatus.OK);
				return response;
		}
		
		/********************************************
		 * Method              : registerComplaint 
		 * Description         : It is used to registerComplaint into complaint table
		 * @param staffMember  : Complaint Object
		 * @returns            : It returns ComplaintDTO Object with details
		 * @PostMapping        : It is used to handle the HTTP POST requests matched with given URI expression.
		 * @RequestBody        : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
		 * @exception          : ComplaintNotFoundException
		 * Created By          : GOMATHI M
	     * Created Date        : 05-04-2021 
		 * 
		 *******************************************/
		
		
		@PostMapping("/add-complaint")
		public ResponseEntity<ComplaintDTO> registerComplaint(@RequestBody Complaint complaint) throws ComplaintNotFoundException {
			
			ComplaintDTO  complaintDTO= null;
			ResponseEntity<ComplaintDTO> complaintResponse = null;
			
		
				
				complaintDTO = customerService.registerComplaint(complaint);
				complaintResponse = new ResponseEntity<ComplaintDTO>(complaintDTO, HttpStatus.ACCEPTED);
			
			return complaintResponse;
			
		}
		
		/********************************************
		 * Method              : addcustomer 
		 * Description         : It is used to add Customer into Customer table
		 * @param staffMember  : Customer Object
		 * @returns            : It returns CustomerDTO Object with details
		 * @PostMapping        : It is used to handle the HTTP POST requests matched with given URI expression.
		 * @RequestBody        : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
		 * @exception          : CustomerNotFoundException
		 * Created By          : GOMATHI M
	     * Created Date        : 05-04-2021 
		 * 
		 *******************************************/
		
		
		@PostMapping("/add-customer")
		public ResponseEntity<CustomerDTO> addcustomer(@RequestBody Customer customer) throws CustomerNotFoundException{
			CustomerDTO customerDTO=null;
			ResponseEntity<CustomerDTO> customerResponse=null;
			
			customerDTO=customerService.addCustomer(customer);
			customerResponse=new ResponseEntity<CustomerDTO>(customerDTO,HttpStatus.ACCEPTED);
			return customerResponse;
		}
}