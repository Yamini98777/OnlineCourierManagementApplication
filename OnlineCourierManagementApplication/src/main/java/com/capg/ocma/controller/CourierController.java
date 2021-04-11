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
@RestController
@RequestMapping("/api/ocma/courier")
public class CourierController 
{
   
	@Autowired
	IShipmentService shipmentService;
	
	static String courierNotFound = "courier not Found";
	
	
	@PostMapping("/addCourier")
	 public ResponseEntity<CourierDTO> addCourier(@RequestBody Courier courier) throws CourierNotFoundException, DateNotFoundException, ComplaintNotFoundException{
		
		CourierDTO courierResponse = shipmentService.addCourier(courier);
		
		return new ResponseEntity<>(courierResponse,HttpStatus.ACCEPTED);
		
		}
	
	
	@GetMapping("/initiateShipment/{courierId}")
	
	public ResponseEntity<String> intiateShipmentTransaction(@PathVariable int courierId) throws CourierNotFoundException{
		
		boolean flag= shipmentService.initiateShipmentTransaction(courierId);
		if(flag) {
			
			return new ResponseEntity <> ("You have successfully initiated the shipment process for the courier with id " + courierId, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity <> (courierNotFound, HttpStatus.NOT_FOUND);
			
		}	
		
	}
	
	@GetMapping("/checkStatus/{courierId}")
	public ResponseEntity <String> checkShipmentStatus(@PathVariable int courierId) throws CourierNotFoundException {
		
			String status = shipmentService.checkShipmentStatus(courierId);
			return new ResponseEntity <> ("The status of the courier with courier id "+courierId +" is: " + status, HttpStatus.OK);
		
	}
	
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