package com.capg.ocma.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.service.IPaymentService;
import com.capg.ocma.service.PaymentServiceImp;

@SpringBootTest
class PaymentServiceImpTest {
	
	@Autowired
	private IPaymentService service;
	

	@Test
	void testProcessPaymentByCash() {
	
		assertTrue(service.processPaymentByCash());
	}

	@Test
	void testProcessPaymentByCard() throws CustomerNotFoundException {
		
		Address address = new Address ("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600062);
		
		BankAccount acct = new BankAccount(255, "Pradhieep", "Savings");
		
		Customer customer = new Customer(101, 12312, "Pradhieep", "K", address, 987321440, acct);
		
		assertTrue(service.processPaymentByCard(101));
		
		
	}

}
