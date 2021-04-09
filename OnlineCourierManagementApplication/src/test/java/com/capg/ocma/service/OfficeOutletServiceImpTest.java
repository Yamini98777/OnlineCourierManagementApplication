package com.capg.ocma.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.capg.ocma.controller.OfficeOutletController;
import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.entities.OfficeStaffMember;

import com.capg.ocma.exception.OutletClosedException;
import com.capg.ocma.exception.OutletNotFoundException;
import com.capg.ocma.model.CourierOfficeOutletDTO;
import com.capg.ocma.repository.IOfficeOutletDao;
import com.capg.ocma.service.IOfficeOutletService;
import com.capg.ocma.service.OfficeOutletServiceImp;
import com.capg.ocma.util.CourierOfficeOutletUtils;
@SpringBootTest
class OfficeOutletServiceImpTest{

	@Autowired
	 OfficeOutletServiceImp service;


	

	
	static OfficeStaffMember officeStaffMember = null;

	static LocalTime openingTime = LocalTime.of(10, 30, 00);
	static LocalTime closingTime = LocalTime.of(23, 30, 10);
	CourierOfficeOutletUtils util = new CourierOfficeOutletUtils();
	final Logger LOGGER = LoggerFactory.getLogger(OfficeOutletController.class);

	@Test
	void testAddNewOffice() {
		LOGGER.info("Testing testAddNewOffice");

		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600062);
		List<OfficeStaffMember> staffMembers = new ArrayList<OfficeStaffMember>();
		CourierOfficeOutlet	courierOfficeOutlet = new CourierOfficeOutlet(101, address, openingTime, closingTime, staffMembers);
		officeStaffMember = new OfficeStaffMember(101, "Yamini", address, "Analyst", courierOfficeOutlet);
 
		staffMembers.add(officeStaffMember);
		
CourierOfficeOutletDTO officedto = service.addNewOffice(courierOfficeOutlet);


		assertNotNull(service.addNewOffice(courierOfficeOutlet));

	}
	@Test 
	void testRemoveNewOffice() {
		
	}
	
	
	
	

}