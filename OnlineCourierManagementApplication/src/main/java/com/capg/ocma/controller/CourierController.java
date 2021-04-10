package com.capg.ocma.controller;

	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ocma.entities.Courier;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.model.CourierDTO;
import com.capg.ocma.service.IShipmentService;

@RestController
@RequestMapping("/api/ocma/courier")

/*
 * Author : SRINIVAS MADIVAL
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Shipment Service Layer
*/

public class CourierController 
{
   
	@Autowired
	private IShipmentService shipmentService;
	

	@PostMapping("/add-courier")
	public ResponseEntity<CourierDTO> addCourier(@RequestBody Courier courier) throws CourierNotFoundException{
	
		CourierDTO  courierDTO= null;
		ResponseEntity<CourierDTO> courierResponse = null;
		
		courierDTO = shipmentService.addCourier(courier);
		courierResponse = new ResponseEntity<CourierDTO>(courierDTO, HttpStatus.ACCEPTED);
		
		return 	courierResponse;
	
	
	}
		
	@PostMapping("/initiate")
	public ResponseEntity<String> intiateShipmentTransaction(@RequestBody Courier courier) throws CourierNotFoundException{
		
		boolean flag= shipmentService.initiateShipmentTransaction(courier);
		if(flag) {
			
			return new ResponseEntity <> ("You have successfully initiated the shipment process for the courier with id " + courier, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity <> ("courier notFound", HttpStatus.NOT_FOUND);
			
		}	
		
	}
	
	@GetMapping("/checkStatus")
	public ResponseEntity <String> checkShipmentStatusAction(@RequestBody Courier courier) throws CourierNotFoundException {
		
			String status = shipmentService.checkShipmentStatus(courier);
			return new ResponseEntity <> ("The status of the courier with courier id is: " + status, HttpStatus.OK);
		
	}
	
	@PostMapping("/close")
	public ResponseEntity <String> closeShipmentTransaction(@RequestBody Courier courier) throws CourierNotFoundException
	 {
		
			boolean flag = shipmentService.closeShipmentTransaction(courier);
			if(flag) {
				
				return new ResponseEntity <> ("You have successfully closed the shipment process for the courier with id " + courier, HttpStatus.OK);
				
			} else {
				
				return new ResponseEntity <> ("courier not Found", HttpStatus.NOT_FOUND);	
			}
	}

	@PostMapping("/reject")
	public ResponseEntity <String> rejectShipmentTransaction(@RequestBody Courier courier) throws CourierNotFoundException {
		
			boolean flag = shipmentService.rejectShipmentTransaction(courier);
			if(flag) {
				
				return new ResponseEntity <> ("You have successfully rejected the shipment process for the courier with id ", HttpStatus.OK);
				
			} else {
				
				return new ResponseEntity <> ("courier not Found", HttpStatus.NOT_FOUND);
			
			}
		
	}
	
	
}
