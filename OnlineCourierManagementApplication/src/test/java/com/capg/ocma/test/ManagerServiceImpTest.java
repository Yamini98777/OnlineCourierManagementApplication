package com.capg.ocma.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.StaffMemberNotFoundException;
import com.capg.ocma.service.IManagerService;

@SpringBootTest
class ManagerServiceImpTest {

	@Autowired
	IManagerService service;
	
	static CourierOfficeOutlet courierOfficeOutlet = null;
	static OfficeStaffMember officeStaffMember = null;
	
	@BeforeAll
	public static void beforeAll()
	{
		System.out.println("Before All executed...");
	}
	
	
	@Test
	void testAddStaffMember() throws StaffMemberNotFoundException {
		
		Address address = new Address ("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600062);
		LocalTime openingTime = LocalTime.of(10,43,12);
		LocalTime closingTime = LocalTime.of(15,29,10);
		List<OfficeStaffMember> staffMembers = new ArrayList<OfficeStaffMember>();
		staffMembers.add(new OfficeStaffMember(101, "Yamini", address, "Analyst", courierOfficeOutlet));
		
		
		courierOfficeOutlet = new CourierOfficeOutlet(101, address, openingTime, closingTime, staffMembers);
		
		officeStaffMember = new OfficeStaffMember(101, "Yamini", address, "Analyst", courierOfficeOutlet);
		
			assertNotNull(service.addStaffMember(officeStaffMember));
	
	}

	@Test
	void testGetCourierStatus() {
		
		
	}
	

}
