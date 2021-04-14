package com.capg.ocma.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.service.ICustomerService;

@SpringBootTest
class CustomerServiceImpTest {

	final static Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpTest.class);


	@Autowired
	private ICustomerService customerservice;

	Complaint complaint = null;
	Customer customer = null;
	BankAccount bank = null;
	Address addr = null;

	@BeforeAll
	public static void init1() {
		LOGGER.info("Customer Testing Initiated");
	}

	@Test
	void testregisterComplaint() throws ComplaintNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "save");
		customer = new Customer(35, 123456789, "arthy", "M", addr, 908067282, bank);
		complaint = new Complaint(52, 120, "string", "string", customer);
	
		assertEquals(120, customerservice.registerComplaint(complaint).getConsignmentno());
	
	}
	
	@Test
	void testregisterComplaint1() throws ComplaintNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "save");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		customerservice.addCustomer(customer);
		complaint = new Complaint(0, 120, "string", "string", customer);
		try
		{
			customerservice.registerComplaint(complaint);
		}
		catch(ComplaintNotFoundException exception)
		{
			assertNotEquals("Complaint num cannot be empty", exception.getMessage());
		}
	}
	
	@Test
	void testregisterComplaint2() throws ComplaintNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "save");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		customerservice.addCustomer(customer);
		complaint = new Complaint(3, 120, "string", "string", customer);
		try
		{
			customerservice.registerComplaint(complaint);
		}
		catch(ComplaintNotFoundException exception)
		{
			assertEquals("Consignment num cannot be empty", exception.getMessage());
		}
	}

	@Test
	void testregisterComplaint3() throws ComplaintNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "save");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		customerservice.addCustomer(customer);
		complaint = new Complaint(3, 0, "string", "string", customer);
		try
		{
			customerservice.registerComplaint(complaint);
		}
		catch(ComplaintNotFoundException exception)
		{
			assertNotEquals("Consignment num cannot be empty", exception.getMessage());
		}
	}
	
	@Test
	void testregisterComplaint4() throws ComplaintNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "save");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		customerservice.addCustomer(customer);
		complaint = new Complaint(3, 0, "string", "string", customer);
		try
		{
			customerservice.registerComplaint(complaint);
		}
		catch(ComplaintNotFoundException exception)
		{
			assertEquals("Consignment num cannot be empty", exception.getMessage());
		}
	}
	@Test
	void testcheckOnlineTrackingStatus() throws CourierNotFoundException {

		int consignmentNo=156;
		try {
			customerservice.checkOnlineTrackingStatus(consignmentNo);
		} catch (CourierNotFoundException exception) {
			assertEquals("No complaint with this consignment number exists...enter valid consignment number", exception.getMessage());
		}

	}
	
	@Test
	void testaddCustomer() throws CustomerNotFoundException {
		LOGGER.info("Testing addCustomer()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "save");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		assertEquals("arthy", customerservice.addCustomer(customer).getFirstname());
		
	}
	
	@Test
	void testaddCustomer1() throws CustomerNotFoundException {
		LOGGER.info("Testing addCustomer()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "arthy", "save");
		customer = new Customer(2, 123456789, "gomathi", "M", addr, 908067282, bank);
		assertEquals("gomathi", customerservice.addCustomer(customer).getFirstname());
		
	}
	
	@Test
	void testaddCustomer2() throws CustomerNotFoundException {
		LOGGER.info("Testing addCustomer()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "arthy", "save");
		customer = new Customer(2, 123456789, "gomathi", "M", addr, 908067282, bank);
		assertEquals(908067282, customerservice.addCustomer(customer).getMobileno());
		
	}
	
	
	@AfterAll
	public static void init() {
		LOGGER.info("Customer Testing Successful");
	}

}