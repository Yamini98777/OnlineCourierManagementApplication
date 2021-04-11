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
import com.capg.ocma.repository.ICustomerDao;
import com.capg.ocma.service.ICustomerService;

@SpringBootTest
class CustomerServiceImpTest {

	final static Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpTest.class);

	@Autowired
	private ICustomerDao customerdao;
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
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		customerdao.save(customer);
		complaint = new Complaint(3, 120, "string", "string", customer);
		try
		{
			customerservice.registerComplaint(complaint);
		}
		catch(ComplaintNotFoundException exception)
		{
			assertEquals("Complaint num cannot be empty", exception.getMessage());
		}
	}
	
	@Test
	void testregisterComplaint1() throws ComplaintNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "save");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		customerdao.save(customer);
		complaint = new Complaint(5, 5, "string", "string", customer);
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
	void testregisterComplaint2() throws ComplaintNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "save");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		customerdao.save(customer);
		complaint = new Complaint(3, 120, "string", "string", customer);
		try
		{
			customerservice.registerComplaint(complaint);
		}
		catch(ComplaintNotFoundException exception)
		{
			assertEquals("Complaint num cannot be empty", exception.getMessage());
		}
	}
	
	@Test
	void testregisterComplaint3() throws ComplaintNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "save");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		customerdao.save(customer);
		complaint = new Complaint(3, 120, "string", "string", customer);
		try
		{
			
			assertEquals( 3,customerservice.registerComplaint(complaint).getComplaintid());
			
		}
		catch(ComplaintNotFoundException exception)
		{
			assertEquals("Complaint num cannot be empty", exception.getMessage());
		}
	}
	
	
	@Test
	void testcheckOnlineTrackingStatus() throws CourierNotFoundException {

		int consignmentNo=156;
		try {
			customerservice.checkOnlineTrackingStatus(consignmentNo);
		} catch (CourierNotFoundException exception) {
			assertEquals("Consignment no should not be empty", exception.getMessage());
		}

	}
	@Test
	void testcheckOnlineTrackingStatus2() throws CourierNotFoundException {

		int consignmentNo=156;
		try {
			customerservice.checkOnlineTrackingStatus(consignmentNo);
		} catch (CourierNotFoundException exception) {
			assertEquals("Consignment no should not be empty", exception.getMessage());
		}

	}
	@Test
	void testcheckOnlineTrackingStatus3() throws CourierNotFoundException {

		int consignmentNo=0;
		try {
			customerservice.checkOnlineTrackingStatus(consignmentNo);
		} catch (CourierNotFoundException exception) {
			assertNotEquals("Consignment no should not be empty", exception.getMessage());
		}

	}
	@AfterAll
	public static void init() {
		LOGGER.info("Customer Testing Initiated");
	}

	
}
