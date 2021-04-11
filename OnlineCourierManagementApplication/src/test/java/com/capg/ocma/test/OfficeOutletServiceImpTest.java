package com.capg.ocma.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ocma.controller.OfficeOutletController;
import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.InvalidAddressException;
import com.capg.ocma.exception.OfficeDetailsNullException;
import com.capg.ocma.exception.OutletNotFoundException;
import com.capg.ocma.model.CourierOfficeOutletDTO;
import com.capg.ocma.service.OfficeOutletServiceImp;

@Disabled
@SpringBootTest
class OfficeOutletServiceImpTest {
	
	@Autowired
	private OfficeOutletServiceImp service;
	
	final Logger LOGGER = LoggerFactory.getLogger(OfficeOutletController.class);
	static OfficeStaffMember officeStaffMember = null;

	@Test
	void testAddNewOffice() throws OfficeDetailsNullException, InvalidAddressException {
		LOGGER.info("Testing testAddNewOffice");

		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 6000628);
		List<OfficeStaffMember> staffMembers = new ArrayList<OfficeStaffMember>();
		CourierOfficeOutlet courierOfficeOutlet = new CourierOfficeOutlet(101, address, "08:00:00.987", "20:00:00.567");
		officeStaffMember = new OfficeStaffMember(101, "Yamini", "Analyst", address, courierOfficeOutlet);

		staffMembers.add(officeStaffMember);

		CourierOfficeOutletDTO officedto = service.addNewOffice(courierOfficeOutlet);

		assertEquals(6000628, officedto.getAddress().getZip());

	}

	@Test
	void testAddNewOffice1() throws OfficeDetailsNullException, InvalidAddressException {
		LOGGER.info("Testing testAddNewOffice");

		Address address = new Address("Hughs road", "Trichy", "Tamil Nadu", "India", 6000629);
		List<OfficeStaffMember> staffMembers = new ArrayList<OfficeStaffMember>();
		CourierOfficeOutlet courierOfficeOutlet = new CourierOfficeOutlet(102, address, "08:45:00.987", "17:00:00.567");
		officeStaffMember = new OfficeStaffMember(105, "jegan", "Manager", address, courierOfficeOutlet);

		staffMembers.add(officeStaffMember);

		CourierOfficeOutletDTO officedto = service.addNewOffice(courierOfficeOutlet);

		assertNotNull(officedto);

	}

	@Test
	void testAddNewOffice3() throws OfficeDetailsNullException, InvalidAddressException {
		LOGGER.info("Testing testAddNewOffice");

		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 6000629);
		List<OfficeStaffMember> staffMembers = new ArrayList<OfficeStaffMember>();
		CourierOfficeOutlet courierOfficeOutlet = new CourierOfficeOutlet(189, address, "08:00:00.987", "20:00:00.567");
		officeStaffMember = new OfficeStaffMember(156, "Yamini", "Analyst", address, courierOfficeOutlet);

		staffMembers.add(officeStaffMember);

		CourierOfficeOutletDTO officedto = service.addNewOffice(courierOfficeOutlet);

		assertEquals(courierOfficeOutlet.getAddress().getCity(), officedto.getAddress().getCity());

	}

	@Test
	void testAddNewOffice4() throws OfficeDetailsNullException, InvalidAddressException {
		LOGGER.info("Testing testAddNewOffice");

		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 6000629);
		CourierOfficeOutlet courierOfficeOutlet = new CourierOfficeOutlet(0, address, "08:00:00.987", "20:00:00.567");

		assertThrows(OfficeDetailsNullException.class, () -> service.addNewOffice(courierOfficeOutlet));

	}

	@Test
	void testAddNewOffice5() throws OfficeDetailsNullException, InvalidAddressException {
		LOGGER.info("Testing testAddNewOffice");
		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 1);

		CourierOfficeOutlet courierOfficeOutlet = new CourierOfficeOutlet(678, address, "08:00:00.987", "20:00:00.567");

		assertThrows(InvalidAddressException.class, () -> service.addNewOffice(courierOfficeOutlet));

	}

	@Test
	void testRemoveNewOffice() throws OutletNotFoundException {
		LOGGER.info("Testing testAddNewOffice");

		assertNull(service.removeNewOffice(1050));
	}

	@Disabled
	@Test
	void testGetOfficeInfo() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testGetAllOfficesData() {
		fail("Not yet implemented");
	}

	@Disabled
	@Test
	void testIsOfficeOpenorClosed() {
		fail("Not yet implemented");
	}

}