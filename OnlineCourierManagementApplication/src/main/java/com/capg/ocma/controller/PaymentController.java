package com.capg.ocma.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.model.CourierDTO;
import com.capg.ocma.service.IPaymentService;
import com.capg.ocma.service.IShipmentService;

/*
 * Author : PRADHIEEP K
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Payment Controller
 */ 


@RestController
@RequestMapping("/api/ocma/payment")
public class PaymentController {
	
	@Autowired
	private IPaymentService paymentService;
	
	
	@GetMapping("/byCash/{courierid}")
	public ResponseEntity<CourierDTO> processPaymentByCash(@PathVariable int courierId)  throws CourierNotFoundException {
		
		CourierDTO courierDTO = paymentService.processPaymentByCash(courierId);
		
		
		return new ResponseEntity<CourierDTO> (courierDTO ,HttpStatus.OK);
		
	}
	
	@GetMapping("/byCard/{accountNo}")
	public ResponseEntity<String> processPaymentByCard(@PathVariable long accountNo) throws AccountNotFoundException{
		 boolean flag = false;
		ResponseEntity<String> response = null;
		
		if(accountNo > 0) {
			flag = paymentService.processPaymentByCard(accountNo);
			if(flag == true)
				response = new ResponseEntity<String> ("You have selected card payment method and paid successfully ",HttpStatus.OK);
			else 
				throw new AccountNotFoundException("Cannot able to pay by card");
		}
		
		return response;
	}


}