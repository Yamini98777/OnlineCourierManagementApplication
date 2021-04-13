package com.capg.ocma.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.service.ICustomerService;
import com.capg.ocma.service.IPaymentService;
import com.capg.ocma.service.IShipmentService;

@SpringBootTest
class PaymentServiceImpTest {
	
	final static Logger logger = LoggerFactory.getLogger(PaymentServiceImpTest.class);
	
	@Autowired
	private IPaymentService paymentService;	
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IShipmentService shipmentService;
	
	Customer customer = null;
	BankAccount bank = null;
	Address addr = null;
	
	@BeforeAll
	public static void init() {
		
		logger.info("Payment Testing Initiated");
		
	}
	
	@Test
	void testProcessPaymentByCash01() throws CourierNotFoundException {
		
		logger.info("Testing testProcessPaymentByCash01()");
		
		LocalDate initiateddate = LocalDate.of(2021, 04, 8);
		LocalDate deliverydate  = LocalDate.of(2021, 04, 11);
		Address address1 = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		Address address2 = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
	    BankAccount acct = new BankAccount(654753, "Pradhieep", "Savings" );
	    Customer sender = new Customer(16, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
  	    Customer reciever = new Customer(17, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
	    Courier courier = new Courier(0, 202, initiateddate, deliverydate , "INITIATED", sender, reciever);
	    shipmentService.addCourier(courier);
	  
	    try
	    {
	    	paymentService.processPaymentByCash(courier.getCourierId());
	    }
		catch(CourierNotFoundException exception)
		{
			assertEquals("Invalid Courier ID",exception.getMessage());
		}
	}
	
	@Test
	void testProcessPaymentByCash02() throws CourierNotFoundException {
		
		logger.info("Testing testProcessPaymentByCash02()");
		
		LocalDate initiateddate = LocalDate.of(2021, 04, 8);
		LocalDate deliverydate  = LocalDate.of(2021, 04, 11);
		Address address1 = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		Address address2 = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
	    BankAccount acct = new BankAccount(654753, "Pradhieep", "Savings" );
	    Customer sender = new Customer(16, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
  	    Customer reciever = new Customer(17, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
	    Courier courier = new Courier(-1, 202, initiateddate, deliverydate , "INITIATED", sender, reciever);
	    shipmentService.addCourier(courier);
	  
	    try
	    {
	    	paymentService.processPaymentByCash(courier.getCourierId());
	    }
		catch(CourierNotFoundException exception)
		{
			assertEquals("Invalid Courier ID",exception.getMessage());
		}
	}
	
	@Test
	void testProcessPaymentByCard01() throws AccountNotFoundException {
		
		logger.info("Testing testProcessPaymentByCard01()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(654753, "Pradhieep", "Savings");
		customer = new Customer(140, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		customerService.addcustomer(customer);
		try
		{
		    paymentService.processPaymentByCard(bank.getAccountNo());
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "No Account found with given account number", exception.getMessage());
		}	
	}
	
	@Test
	void testProcessPaymentByCard02() throws AccountNotFoundException {
		
		logger.info("Testing testProcessPaymentByCard02()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(0, "Pradhieep", "Savings");
		customer = new Customer(140, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		customerService.addcustomer(customer);
		try
		{
			paymentService.processPaymentByCard(bank.getAccountNo());
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Number cannot be 0 or Negative", exception.getMessage());
		}	
	}
	
	@Test
	void testProcessPaymentByCard03() throws AccountNotFoundException {
		
		logger.info("Testing testProcessPaymentByCard03()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(-1, "Pradhieep", "Savings");
		customer = new Customer(140, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		customerService.addcustomer(customer);
		try
		{
			paymentService.processPaymentByCard(bank.getAccountNo());
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Number cannot be 0 or Negative", exception.getMessage());
		}	
	}
	
	@Test
	void testProcessPaymentByCard04() throws AccountNotFoundException {
		
		logger.info("Testing testProcessPaymentByCard04()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(99, "Pradhieep", "Savings");
		customer = new Customer(140, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		customerService.addcustomer(customer);
		try
		{
			paymentService.processPaymentByCard(654753);
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Number Range cannot be below 100 or above 10000000", exception.getMessage());
		}	
	} 
	
	@Test
	void testProcessPaymentByCard05() throws AccountNotFoundException {
		
		logger.info("Testing testProcessPaymentByCard05()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(10000001, "Pradhieep", "Savings");
		customer = new Customer(140, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		customerService.addcustomer(customer);
		try
		{
			paymentService.processPaymentByCard(bank.getAccountNo());
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Number Range cannot be below 100 or above 10000000", exception.getMessage());
		}	
	}
	
			
}