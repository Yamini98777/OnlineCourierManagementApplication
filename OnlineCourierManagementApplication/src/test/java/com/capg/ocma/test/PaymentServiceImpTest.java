package com.capg.ocma.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.service.IPaymentService;

@SpringBootTest
class PaymentServiceImpTest {
	
	final static Logger logger = LoggerFactory.getLogger(PaymentServiceImpTest.class);
	
	@Autowired
	private IPaymentService service;	
	
	@BeforeAll
	public static void init() {
		
		logger.info("Payment Testing Initiated");
		
	}
	
	@Test
	void testProcessPaymentByCash() {
		logger.info("Testing testProcessPaymentByCash()");
		
		 //
	}
	
	@Test
	void testProcessPaymentByCard01() throws AccountNotFoundException {
		
		logger.info("Testing testProcessPaymentByCard01()");
		
		BankAccount acct = new BankAccount(255, "Pradhieep", "Savings");
		try
		{
		    service.processPaymentByCard(255);
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "No Account found with given account number", exception.getMessage());
		}	
	}
	
	@Test
	void testProcessPaymentByCard02() throws AccountNotFoundException {
		
		logger.info("Testing testProcessPaymentByCard02()");
		
		BankAccount acct = new BankAccount(255, "Pradhieep", "Savings");
		try
		{
		    assertEquals(true,service.processPaymentByCard(255));
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "No Account found with given account number", exception.getMessage());
		}	
	}
	
	@Test
	void testProcessPaymentByCard03() throws AccountNotFoundException {
		
		logger.info("Testing testProcessPaymentByCard03()");
		
		BankAccount acct = new BankAccount(0, "Pradhieep", "Savings");
		try
		{
		    service.processPaymentByCard(acct.getAccountNo());
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "No Account found with given account number", exception.getMessage());
		}
	}
	
	@Test
	void testProcessPaymentByCard04() throws AccountNotFoundException {
		
		logger.info("Testing testProcessPaymentByCard04()");
		
		BankAccount acct = new BankAccount('a', "Pradhieep", "Savings");
		try
		{
		    service.processPaymentByCard(acct.getAccountNo());
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "No Account found with given account number", exception.getMessage());
		}
	}
	
	@Test
	void testProcessPaymentByCard05() throws AccountNotFoundException {
		
		logger.info("Testing testProcessPaymentByCard05()");
		
		BankAccount acct = new BankAccount(10l, "Pradhieep", "Savings");
		try
		{
		    service.processPaymentByCard(acct.getAccountNo());
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "No Account found with given account number", exception.getMessage());
		}
	}
			
			
}