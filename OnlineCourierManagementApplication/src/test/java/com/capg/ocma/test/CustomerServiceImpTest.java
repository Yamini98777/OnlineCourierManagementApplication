package com.capg.ocma.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
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
	public static void init() {
		LOGGER.info("Customer Testing Initiated");
	}

	@Test
	void testregisterComplaint() throws ComplaintNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "save");
		customer = new Customer(121, 123456789, "arthy", "M", addr, 908067282, bank);
		complaint = new Complaint(0, 120, "string", "string", customer);
		try
		{
			customerservice.registerComplaint(complaint);
		}
		catch(ComplaintNotFoundException exception)
		{
			assertEquals("Tenant name cannot be empty", exception.getMessage());
		}
	}

	@Test
	void testcheckOnlineTrackingStatus(int consignmentno) throws CourierNotFoundException {

		complaint = new Complaint(101, 0, "string", "string", customer);
		try {
			customerservice.checkOnlineTrackingStatus(consignmentno);
		} catch (CourierNotFoundException exception) {
			assertEquals("Consignment no should not be empty", exception.getMessage());
		}

	}

}
