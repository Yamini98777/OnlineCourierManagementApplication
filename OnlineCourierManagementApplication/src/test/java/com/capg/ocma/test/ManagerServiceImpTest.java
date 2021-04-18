package com.capg.ocma.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ocma.controller.ManagerController;
import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.entities.Manager;
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.StaffMemberNotFoundException;
import com.capg.ocma.service.IManagerService;

//@Disabled
@SpringBootTest
class ManagerServiceImpTest {

	@Autowired
	private IManagerService service;

	static CourierOfficeOutlet courierOfficeOutlet = null;
	static OfficeStaffMember officeStaffMember = null;

	final static Logger logger = LoggerFactory.getLogger(ManagerController.class);

	@BeforeAll
	public static void init() {

		logger.info("Manager Testing Initiated");
	}

//	@Disabled
	@Test
	void testAddStaffMember() throws StaffMemberNotFoundException {

		logger.info("Testing testAddStaffMember()");

		Manager managerId = new Manager(1);
		
		Address address = new Address("Ring Road", "Ongole", "Andhra Pradesh", "India", 540002);

		courierOfficeOutlet = new CourierOfficeOutlet(1001, address, "09:30:12.345", "08:30:33");

		officeStaffMember = new OfficeStaffMember(101, "Yamini", "Analyst", address, courierOfficeOutlet, managerId);

		assertEquals("Yamini", service.addStaffMember(officeStaffMember).getName());

	}

	@Disabled
	@Test
	void testAddStaffMember1() throws StaffMemberNotFoundException {

		logger.info("Testing testAddStaffMember1()");

		Manager managerId = new Manager(1);
		
		Address address = new Address("Ring Road", "Ongole", "Andhra Pradesh", "India", 129056);

		courierOfficeOutlet = new CourierOfficeOutlet(80, address, "16:25:21", "08:30:33");

		officeStaffMember = new OfficeStaffMember(101, "Yamini", "Analyst", address, courierOfficeOutlet, managerId);

		assertNotNull(service.addStaffMember(officeStaffMember));
	}

	@Disabled
	@Test
	void testAddStaffMember2() throws StaffMemberNotFoundException {

		logger.info("Testing testAddStaffMember2()");

		Manager managerId = new Manager(1);
		
		Address address = new Address("Ring Road", "Ongole", "Andhra Pradesh", "India", 129156);

		courierOfficeOutlet = new CourierOfficeOutlet(70, address, "16:25:21", "08:30:33");

		officeStaffMember = new OfficeStaffMember(101, "Yamini", "CEO", address, courierOfficeOutlet, managerId);

		try {
			service.addStaffMember(officeStaffMember);
		} catch (StaffMemberNotFoundException exception) {
			assertEquals("Invalid role", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testAddStaffMember3() throws StaffMemberNotFoundException {

		logger.info("Testing testAddStaffMember3()");

		Manager managerId = new Manager(1);
		
		Address address = new Address("Ring Road", "Ongole", "Andhra Pradesh", "India", 129156);

		courierOfficeOutlet = new CourierOfficeOutlet(70, address, "16:25:21", "08:30:33");

		officeStaffMember = new OfficeStaffMember(101, null, "CEO", address, courierOfficeOutlet, managerId);

		try {
			service.addStaffMember(officeStaffMember);
		} catch (StaffMemberNotFoundException exception) {
			assertEquals("Name cannot be empty", exception.getMessage());
		}
	}

//	@Disabled
	@Test
	void testAddStaffMember4() throws StaffMemberNotFoundException {

		logger.info("Testing testAddStaffMember4()");

		Manager managerId = new Manager(1);
		
		Address address = new Address("Ring Road", "Ongole", "Andhra Pradesh", "India", 129156);

		courierOfficeOutlet = new CourierOfficeOutlet(70, address, "16:25:21", "08:30:33");

		officeStaffMember = new OfficeStaffMember(101, "Jyothi22", "CEO", address, courierOfficeOutlet, managerId);

		try {
			service.addStaffMember(officeStaffMember);
		} catch (StaffMemberNotFoundException exception) {
			assertEquals("Name cannot contain Numbers or Special Characters", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testAddStaffMember5() throws StaffMemberNotFoundException {

		logger.info("Testing testAddStaffMember5()");

		Manager managerId = new Manager(1);
		
		Address address = new Address("Ring Road", "Ongole", "Andhra Pradesh", "India", 129156);

		courierOfficeOutlet = new CourierOfficeOutlet(70, address, "16:25:21", "08:30:33");

		officeStaffMember = new OfficeStaffMember(101, "Jyothi", "Analyst#1", address, courierOfficeOutlet, managerId);

		try {
			service.addStaffMember(officeStaffMember);
		} catch (StaffMemberNotFoundException exception) {
			assertEquals("Role cannot contain Numbers or Special Characters", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testAddStaffMember6() throws StaffMemberNotFoundException {

		logger.info("Testing testAddStaffMember6()");

		Manager managerId = new Manager(1);
		
		Address address = new Address("Ring Road", "Ongole", "Andhra Pradesh", "India", 129156);

		courierOfficeOutlet = new CourierOfficeOutlet(70, address, "16:25:21", "08:30:33");

		officeStaffMember = new OfficeStaffMember(101, "Jyothi", null, address, courierOfficeOutlet, managerId);

		try {
			service.addStaffMember(officeStaffMember);
		} catch (StaffMemberNotFoundException exception) {
			assertEquals("Role cannot be empty", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testRemoveStaffMember() throws StaffMemberNotFoundException {

		logger.info("Testing testRemoveStaffMember");

		try {
			service.removeStaffMember(17);
		} catch (StaffMemberNotFoundException exception) {
			assertEquals("No Staff Member found with given ID", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testRemoveStaffMember1() throws StaffMemberNotFoundException {

		logger.info("Testing testRemoveStaffMember1");

		assertNotNull(service.removeStaffMember(16));

	}

	@Disabled
	@Test
	void testGetStaffMember1() throws StaffMemberNotFoundException {

		logger.info("Testing testGetStaffMember1()");

		assertEquals("Jasmine", service.getStaffMember(14).getName());
	}

	@Disabled
	@Test
	void testGetStaffMember2() throws StaffMemberNotFoundException {

		logger.info("Testing testGetStaffMember2()");

		try {
			service.getStaffMember(0);
		} catch (StaffMemberNotFoundException exception) {
			assertEquals("No Staff Member found with given ID", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testGetStaffMember3() throws StaffMemberNotFoundException {

		logger.info("Testing testGetStaffMember3()");

		assertNotNull(service.getStaffMember(14));

	}

	@Disabled
	@Test
	void testGetAllStaffMembers1() {

		logger.info("Testing testGetAllStaffMembers1()");

		assertNotNull(service.getAllStaffMembers());
	}

	@Disabled
	@Test
	void testGetCourierStatus1() throws CourierNotFoundException {

		logger.info("Testing testGetCourierStatus1()");

		assertEquals("Delivered", service.getCourierStatus(9));
	}

	@Disabled
	@Test
	void testGetCourierStatus2() throws CourierNotFoundException {

		logger.info("Testing testGetCourierStatus2()");

		try {
			service.getCourierStatus(0);
		} catch (CourierNotFoundException exception) {
			assertEquals("No Courier found with given ID", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testGetRegistedComplaint1() throws ComplaintNotFoundException {

		logger.info("Testing testGetRegistedComplaint1()");

		assertNotNull(service.getRegistedComplaint(2));
	}

	@Disabled
	@Test
	void testGetRegistedComplaint2() throws ComplaintNotFoundException {

		logger.info("Testing testGetRegistedComplaint2()");

		try {
			service.getRegistedComplaint(0);
		} catch (ComplaintNotFoundException exception) {
			assertEquals("No Complaint found with given ID", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testGetAllComplaints() {

		logger.info("Testing testGetAllComplaints");

		assertNotNull(service.getAllComplaints());
	}

	@AfterAll
	public static void end() {

		logger.info("Manager Testing Terminated");
	}

}