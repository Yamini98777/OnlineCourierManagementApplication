package com.capg.ocma.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ocma.controller.OfficeOutletController;
import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.entities.Manager;
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.InvalidAddressException;
import com.capg.ocma.exception.OfficeDetailsNullException;
import com.capg.ocma.exception.OutletClosedException;
import com.capg.ocma.exception.OutletNotFoundException;
import com.capg.ocma.model.CourierOfficeOutletDTO;
import com.capg.ocma.service.OfficeOutletServiceImp;

@SpringBootTest
class OfficeOutletServiceImpTest {
	@Autowired
	 OfficeOutletServiceImp service;
	final static Logger LOGGER = LoggerFactory.getLogger(OfficeOutletController.class);
	static OfficeStaffMember officeStaffMember = null;
	
	
	@BeforeAll
	public static void init() {
		LOGGER.info("OfficeServiceImp Testing Initiated");

	}
	
	@Test
	void testAddNewOffice() throws OfficeDetailsNullException, InvalidAddressException {
		LOGGER.info("Testing testAddNewOffice");

		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 6000628);

		CourierOfficeOutlet	courierOfficeOutlet = new CourierOfficeOutlet(101, address, "08:00:00.987", "20:00:00.567");


		assertEquals( 6000628, service.addNewOffice(courierOfficeOutlet).getAddress().getZip());

	}
	
	@Test
	void testAddNewOffice1() throws OfficeDetailsNullException, InvalidAddressException {
		LOGGER.info("Testing testAddNewOffice");

		Address address = new Address("Hughs road", "Trichy", "Tamil Nadu", "India", 6000629);
		
		CourierOfficeOutlet	courierOfficeOutlet = new CourierOfficeOutlet(102, address, "08:45:00.987", "17:00:00.567");
		
		CourierOfficeOutletDTO officedto = service.addNewOffice(courierOfficeOutlet);


		assertNotNull(officedto);

	}

	@Test
	void testAddNewOffice3() throws OfficeDetailsNullException, InvalidAddressException {
		LOGGER.info("Testing testAddNewOffice");

		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 6000629);
		
		CourierOfficeOutlet	courierOfficeOutlet = new CourierOfficeOutlet(189, address, "08:00:00.987", "20:00:00.567");
		
		CourierOfficeOutletDTO officedto = service.addNewOffice(courierOfficeOutlet);


		assertEquals(courierOfficeOutlet.getAddress().getCity(), officedto.getAddress().getCity());
		

	}
	
	@Test
	void testAddNewOffice4() throws OfficeDetailsNullException, InvalidAddressException {
		LOGGER.info("Testing testAddNewOffice");


		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 6000629);
		CourierOfficeOutlet	courierOfficeOutlet = new CourierOfficeOutlet(0, address, "08:00:00.987", "20:00:00.567");
		
		assertThrows(OfficeDetailsNullException.class, () ->  service.addNewOffice(courierOfficeOutlet));
		
}
	
	@Test
	void testAddNewOffice5() throws OfficeDetailsNullException, InvalidAddressException {
		LOGGER.info("Testing testAddNewOffice");
		Address address = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 1);
		
		CourierOfficeOutlet	courierOfficeOutlet = new CourierOfficeOutlet(678, address, "08:00:00.987", "20:00:00.567");
		
	assertThrows(InvalidAddressException.class, () ->  service.addNewOffice(courierOfficeOutlet));
		
}
	
    
	@Test
	void testRemoveNewOffice() throws  OutletNotFoundException {
		LOGGER.info("Testing testAddNewOffice");

     assertNotNull(service.removeNewOffice(101));
	}
    
	@Test
	void testRemoveNewOffice1() throws  OutletNotFoundException {
		LOGGER.info("Testing testAddNewOffice");

     assertThrows(OutletNotFoundException.class,() -> service.removeNewOffice(107));
	}
   
	@Test
	void testRemoveNewOffice2() throws OutletNotFoundException {
		LOGGER.info("Testing RemoveNewOffice1() ");
		assertDoesNotThrow(()-> service.removeNewOffice(11));
	}
   
	@Test
	void testGetOfficeInfo1() throws OutletNotFoundException {
		LOGGER.info("testGetOfficeInfo1() ");
		assertNotNull(service.getOfficeInfo(102));
		
	}

	@Test
	void testGetOfficeInfo2() throws OutletNotFoundException {
		LOGGER.info("testGetOfficeInfo2() ");
		
		assertEquals("17:00:00.567",service.getOfficeInfo(102).getClosingTime());
	}
	

	@Test
	void testGetOfficeInfo3() throws OutletNotFoundException {
		LOGGER.info("testGetOfficeInfo3() ");
		
		assertEquals("08:45:00.987",service.getOfficeInfo(102).getOpeningTime());
	}
	@Test
	void testGetOfficeInfo4() throws OutletNotFoundException {
		LOGGER.info("testGetOfficeInfo4() ");
		
		 assertThrows(OutletNotFoundException.class,() -> service.getOfficeInfo(234));
	}
	
 
	@Test
	void testGetAllOfficesData1() throws OutletNotFoundException 
	{
		LOGGER.info("testAllOfficesData1 ");
		assertNotNull(service.getAllOfficesData());
	}
	
    
	@Test
	void testIsOfficeOpenorClosed() throws OutletClosedException {
		LOGGER.info("testIsOfficeOpenorClosed");
		assertFalse(service.isOfficeOpenorClosed(102));
		
	}
	
	@AfterAll 
	public static void end() {
		LOGGER.info("OfficeServiceImpl Testing terminated");
	}
	
	

}