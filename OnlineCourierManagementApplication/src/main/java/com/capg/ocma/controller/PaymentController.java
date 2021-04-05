package com.capg.ocma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ocma.service.IPaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired
	private IPaymentService paymentService;
	
	@GetMapping("byCash")
	public ResponseEntity<String> processPaymentByCash() {
		
		return new ResponseEntity<String> ("You have selected cash on delivery payment method",HttpStatus.OK);
		
	}
	
	public ResponseEntity<String> processPaymentByCard(@RequestBody int customerid){
		  
		boolean flag = paymentService.processPaymentByCard(customerid);
		if(flag) {
			return new ResponseEntity<String> ("You have selected card payment method and paid successfully ",HttpStatus.OK);
		}else {
			return new ResponseEntity<String> ("Cannot able to pay by card",HttpStatus.OK);
		}
	}

}
