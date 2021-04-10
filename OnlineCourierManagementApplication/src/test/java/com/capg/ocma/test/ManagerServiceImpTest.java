package com.capg.ocma.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ocma.controller.ManagerController;
import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.entities.Customer;
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.StaffMemberNotFoundException;
import com.capg.ocma.service.IManagerService;

@SpringBootTest
class ManagerServiceImpTest {

	@Autowired
	IManagerService service;

	static CourierOfficeOutlet courierOfficeOutlet = null;
	static OfficeStaffMember officeStaffMember = null;
	static LocalTime openingTime = LocalTime.of(10, 43, 12);
	static LocalTime closingTime = LocalTime.of(15, 29, 10);

	final Logger logger = LoggerFactory.getLogger(ManagerController.class);

//	@Disabled
	@Test
	void testAddStaffMember() throws StaffMemberNotFoundException {

		logger.info("Testing testAddStaffMember");

		Address address = new Address("Ring Road", "Ongole", "Andhra Pradesh", "India", 540002);
		
		officeStaffMember = new OfficeStaffMember(101, "Yamini", address, "Analyst");

		assertEquals("Yamini", service.addStaffMember(officeStaffMember).getName());

	}

	
	@Disabled
	@Test
	void testRemoveStaffMember() throws StaffMemberNotFoundException {

		logger.info("Testing testRemoveStaffMember");

		try {
			service.removeStaffMember(3);
		} catch (StaffMemberNotFoundException exception) {
			assertEquals("No Staff Member found with given ID", exception.getMessage());
		}
	}

	
	@Disabled
	@Test
	void testRemoveStaffMember1() throws StaffMemberNotFoundException {

		logger.info("Testing testRemoveStaffMember1");

		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600062);
		  
		officeStaffMember = new OfficeStaffMember(101, "Yamini", address, "Analyst");
		  
	    assertNotNull(service.removeStaffMember(101));
		 
	}

	
	@Disabled
	@Test
	void testGetStaffMember() throws StaffMemberNotFoundException {

		logger.info("Testing testGetStaffMember");

		assertEquals("Yamini", service.getStaffMember(3).getName());
	}

	
	@Disabled
	@Test
	void testGetAllStaffMembers() {

		logger.info("Testing testGetAllStaffMembers");

		assertNotNull(service.getAllStaffMembers());
	}

	
	@Disabled
	@Test
	void testGetCourierStatus() throws CourierNotFoundException {

		logger.info("Testing testGetCourierStatus");

		LocalDate initiatedDate = LocalDate.of(2018, 1, 13);
		LocalDate deliveredDate = LocalDate.of(2019, 1, 13);

		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600062);

		BankAccount acct = new BankAccount(22334455, "Yamini", "Savings");

		Customer sender = new Customer(101, 12312, "Yamini", "C", address, 987321440, acct);

		Customer receiver = new Customer(102, 123012, "Jyothi", "S", address, 987654329, acct);

		Courier courier = new Courier(101, 1234, initiatedDate, deliveredDate, "Delivered", sender, receiver);

//		assertEquals("Delivered", service.getCourierStatus(courier));
	}

	
	@Disabled
	@Test
	void testGetRegistedComplaint() throws ComplaintNotFoundException {

		logger.info("Testing testGetRegistedComplaint");

		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600062);

		BankAccount acct = new BankAccount(22334455, "Yamini", "Savings");

		Customer customer = new Customer(101, 12312, "Yamini", "C", address, 987321440, acct);

		Complaint complaint = new Complaint(1234, 5678, "Late delivery", "Delivered after 1 week", customer);

		assertNotNull(service.getRegistedComplaint(1234));
	}

	
	@Disabled
	@Test
	void testGetAllComplaints() {

		logger.info("Testing testGetAllComplaints");

		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600062);

		BankAccount acct = new BankAccount(22334455, "Yamini", "Savings");

		Customer customer = new Customer(101, 12312, "Yamini", "C", address, 987321440, acct);

		Complaint complaint = new Complaint(1234, 5678, "Late delivery", "Delivered after 1 week", customer);

		assertNotNull(service.getAllComplaints());
	}

}
