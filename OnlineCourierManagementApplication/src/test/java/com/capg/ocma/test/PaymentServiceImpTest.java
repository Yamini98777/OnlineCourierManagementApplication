package com.capg.ocma.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.service.IPaymentService;

@SpringBootTest
class PaymentServiceImpTest {
	
	@Autowired
	private IPaymentService service;
	

	@Test
	void testProcessPaymentByCash() {
	
		assertTrue(service.processPaymentByCash());
	}
	
	@Test
	void testProcessPaymentByCard1() throws AccountNotFoundException {
		
		Address address = new Address ("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600062);
		
		BankAccount acct = new BankAccount(255, "Pradhieep", "Savings");
		
		Customer customer = new Customer(101, 12312, "Pradhieep", "K", address, 987321440, acct);
		
		try{
		    service.processPaymentByCard(255);
		}
		catch(AccountNotFoundException exception)
		{
		   assertEquals( "throw new AccountNotFoundException", exception.getMessage());
		}
		
		
	}
	
	@Test
	void testProcessPaymentByCard2() throws AccountNotFoundException {
		
		Address address = new Address ("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600062);
		
		BankAccount acct = new BankAccount(255, "Pradhieep", "Savings");
		
		Customer customer = new Customer(101, 12312, "Pradhieep", "K", address, 987321440, acct);
		
		try{
		    assertEquals(true,service.processPaymentByCard(255));
		}
		catch(AccountNotFoundException exception)
		{
		   assertEquals( "throw new AccountNotFoundException", exception.getMessage());
		}
		
		
	}
	
	@Test
	void testProcessPaymentByCard3() throws AccountNotFoundException {
		
		Address address = new Address ("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600062);
		
		BankAccount acct = new BankAccount(0, "Pradhieep", "Savings");
		
		Customer customer = new Customer(101, 12312, "Pradhieep", "K", address, 987321440, acct);
		
		try{
		    service.processPaymentByCard(acct.getAccountNo());
		}
		catch(AccountNotFoundException exception)
		{
			assertThrows(AccountNotFoundException.class, () -> {
				service.processPaymentByCard(acct.getAccountNo());
			});
		}
		
	}
	}