package com.capg.ocma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.model.BankAccountDTO;
import com.capg.ocma.service.IPaymentService;
import com.capg.ocma.service.PaymentServiceImp;

@RestController
@RequestMapping("/api/ocma/payment")
public class PaymentController {
	
	@Autowired
	IPaymentService paymentService;
	
	
	@GetMapping("/byCash")
	public ResponseEntity<String> processPaymentByCash() {
		
		return new ResponseEntity<String> ("You have selected cash on delivery payment method",HttpStatus.OK);
		
	}
	
	@GetMapping("/byCard/{customerId}")
	public ResponseEntity<String> processPaymentByCard(@PathVariable int customerId) throws CustomerNotFoundException{
		  
		boolean flag = paymentService.processPaymentByCard(customerId);
		if(flag) {
			return new ResponseEntity<String> ("You have selected card payment method and paid successfully ",HttpStatus.OK);
		}else {
			throw new CustomerNotFoundException("Cannot able to pay by card");
		}
	}

	@GetMapping("/get-accountNo/{accountNo}")
	public ResponseEntity<BankAccountDTO> getAccountNo(@PathVariable int accountNo) throws AccountNotFoundException{
		
		BankAccountDTO bankAccountNo = null;
		ResponseEntity<BankAccountDTO> bankAccountResponse = null;
		
		accountNo = BankAccount.getAccountNo();
		
		if(PaymentServiceImp.validateAccountNo(accountNo)) {
			
			bankAccountResponse = new ResponseEntity<BankAccountDTO>(bankAccountNo,HttpStatus.ACCEPTED);
			
		}else {
			
			throw new AccountNotFoundException("No Account available with the given Account Number");
		}
		return bankAccountResponse;
		
	}  

}
