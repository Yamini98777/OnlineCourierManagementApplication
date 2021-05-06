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

import com.capg.ocma.entities.Courier;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.DateNotFoundException;
import com.capg.ocma.model.CourierDTO;
import com.capg.ocma.service.IShipmentService;


/*
 * Author : SRINIVAS MADIVAL
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Shipment Controller
*/
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/ocma/courier")
public class CourierController 
{
   
	@Autowired
	private IShipmentService shipmentService;
	
	static String courierNotFound = "courier not Found";
	
	/********************************************
	 * Method              : addCourier
	 * Description         : It is used to add new courier details into courier table
	 * @param courier      : Courier Object
	 * @returns            : It returns CourierDTO Object with details
	 * @PostMapping        : It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody        : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception          : CourierNotFoundException, DateNotFoundException, ComplaintNotFoundException
	 * Created By          : SRINIVAS MADIVAL
     * Created Date        : 05-04-2021 
	 * 
	 *******************************************/
	
	
	
	@PostMapping("/addCourier")
	 public ResponseEntity<CourierDTO> addCourier(@RequestBody Courier courier) throws CourierNotFoundException, DateNotFoundException, ComplaintNotFoundException{
		
		CourierDTO courierResponse = shipmentService.addCourier(courier);
		
		return new ResponseEntity<>(courierResponse,HttpStatus.ACCEPTED);
		
		}
	
	/********************************************
	 * Method           : initiateShipmentTransaction
	 * Description      : This operation enables to initiate the shipment transaction by setting the shipment status as INITIATED
	 * @param courierId : int courierId
	 * @returns         : It returns String Object with details
	 * @GetMapping      : It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody     : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception       : CourierNotFoundException
	 * Created By       : SRINIVAS MADIVAL
     * Created Date     : 05-04-2021
	 * 
	 *******************************************/
	
	
	@GetMapping("/initiateShipment/{courierId}")
	
	public ResponseEntity<String> intiateShipmentTransaction(@PathVariable int courierId) throws CourierNotFoundException{
		
		boolean flag= shipmentService.initiateShipmentTransaction(courierId);
		if(flag) {
			
			return new ResponseEntity <> ("You have successfully initiated the shipment process for the courier with id " + courierId, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity <> (courierNotFound, HttpStatus.NOT_FOUND);
			
		}	
		
	}
	

	/********************************************
	 * Method           : checkShipmentStatus
	 * Description      : This operation provides facility to check the shipment status 
	 * @param courierId : int courierId
	 * @returns         : It returns String Object with details
	 * @GetMapping      : It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody     : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception       : CourierNotFoundException
	 * Created By       : SRINIVAS MADIVAL
     * Created Date     : 05-04-2021
	 * 
	 *******************************************/
	
	
	@GetMapping("/checkStatus/{courierId}")
	public ResponseEntity <String> checkShipmentStatus(@PathVariable int courierId) throws CourierNotFoundException {
		
			String status = shipmentService.checkShipmentStatus(courierId);
			return new ResponseEntity <> ("The status of the courier with courier id "+courierId +" is: " + status, HttpStatus.OK);
		
	}
	
	/********************************************
	 * Method           : closeShipmentTransaction
	 * Description      : This operation enables to Close the shipment transaction by setting the shipment status as DELIVERED
	 * @param courierId : int courierId
	 * @returns         : It returns String Object with details
	 * @GetMapping      : It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody     : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception       : CourierNotFoundException
	 * Created By       : SRINIVAS MADIVAL
     * Created Date     : 05-04-2021
	 * 
	 *******************************************/
	
	@GetMapping("/closeShipment/{courierId}")
	public ResponseEntity <String> closeShipmentTransaction(@PathVariable int courierId) throws CourierNotFoundException
	 {
		
			boolean flag = shipmentService.closeShipmentTransaction(courierId);
			if(flag) {
				
				return new ResponseEntity <> ("You have successfully closed the shipment process for the courier with id " + courierId, HttpStatus.OK);
				
			} else {
				
				return new ResponseEntity <> (courierNotFound, HttpStatus.NOT_FOUND);	
			}
	}


	/********************************************
	 * Method           : rejectShipmentTransaction
	 * Description      : This operation enables to Close the shipment transaction by setting the shipment status as REJECTED
	 * @param courierId : int courierId
	 * @returns         : It returns String Object with details
	 * @GetMapping      : It is used to handle the HTTP GET requests matched with given URI expression.
	 * @RequestBody     : It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @exception       : CourierNotFoundException
	 * Created By       : SRINIVAS MADIVAL
     * Created Date     : 05-04-2021
	 * 
	 *******************************************/
	
	@GetMapping("/rejectShipment/{courierId}")
	public ResponseEntity <String> rejectShipmentTransaction(@PathVariable int courierId) throws CourierNotFoundException {
		
			boolean flag = shipmentService.rejectShipmentTransaction(courierId);
			if(flag) {
				
				return new ResponseEntity <> ("You have successfully rejected the shipment process for the courier with id "+courierId , HttpStatus.OK);
				
			} else {
				
				return new ResponseEntity <> (courierNotFound, HttpStatus.NOT_FOUND);
			
			}
		
	}
	
	
}