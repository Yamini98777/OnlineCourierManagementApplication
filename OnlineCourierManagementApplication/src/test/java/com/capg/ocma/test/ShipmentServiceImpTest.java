package com.capg.ocma.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ocma.entities.Address;
import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.DateNotFoundException;
import com.capg.ocma.model.CourierDTO;
import com.capg.ocma.service.IShipmentService;

@SpringBootTest
class ShipmentServiceImpTest {
	
	@Autowired
	private IShipmentService service;

	@Test
	void testAddCourier() throws CourierNotFoundException, DateNotFoundException, ComplaintNotFoundException {

		LocalDate initiatedDate = LocalDate.of(2017, 1, 13);

		LocalDate deliveryDate = LocalDate.of(2017, 1, 20);

		Address address1 = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600052);
		Address address2 = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600063);
		BankAccount acct = new BankAccount(70808060, "Sai Kiran", "Savings");
		Customer sender = new Customer(3, 494949949, "sai", "kiran", address1, 64278235, acct);
		Customer reciever = new Customer(4, 585858585, "Krishna", "Kumar", address2, 64358545, acct);
		Courier courier = new Courier(6, 9000, initiatedDate, deliveryDate, "INITIATED", sender, reciever);
		CourierDTO dto = service.addCourier(courier);
		
		assertEquals(9000, dto.getConsignmentno());
	}

	@Test
	void testInitiateShipmentTransaction() throws CourierNotFoundException {

		LocalDate initiatedDate = LocalDate.of(2017, 1, 13);
		LocalDate deliveryDate = LocalDate.of(2017, 1, 20);
		Address address1 = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600052);
		Address address2 = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600063);
		BankAccount acct = new BankAccount(70808060, "Sai Kiran", "Savings");
		Customer sender = new Customer(20200301, 494949949, "sai", "kiran", address1, 64278235, acct);
		Customer reciever = new Customer(202320222, 585858585, "Krishna", "Kumar", address2, 64358545, acct);
		Courier courier = new Courier(6, 202, initiatedDate, deliveryDate, "INITIATED", sender, reciever);

		boolean initiate = service.initiateShipmentTransaction(courier.getCourierId());
		assertTrue(initiate);
	}

	@Test
	void testCheckShipmentStatus() throws CourierNotFoundException {
		LocalDate initiatedDate = LocalDate.of(2017, 1, 13);
		LocalDate deliveryDate = LocalDate.of(2017, 1, 20);
		Address address1 = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600052);
		Address address2 = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600063);
		BankAccount acct = new BankAccount(70808060, "Sai Kiran", "Savings");
		Customer sender = new Customer(4, 494949949, "sai", "kiran", address1, 64278235, acct);
		Customer reciever = new Customer(2, 585858585, "Krishna", "Kumar", address2, 64358545, acct);
		Courier courier = new Courier(6, 202, initiatedDate, deliveryDate, "DELIVERED", sender, reciever);
		String check = service.checkShipmentStatus(courier.getCourierId());
		assertEquals("DELIVERED", check);
	}

	@Test
	void testCloseShipmentTransaction() throws CourierNotFoundException {
		LocalDate initiatedDate = LocalDate.of(2017, 1, 13);
		LocalDate deliveryDate = LocalDate.of(2017, 1, 20);
		Address address1 = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600052);
		Address address2 = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600063);
		BankAccount acct = new BankAccount(70808060, "Sai Kiran", "Savings");
		Customer sender = new Customer(4, 494949949, "sai", "kiran", address1, 64278235, acct);
		Customer reciever = new Customer(2, 585858585, "Krishna", "Kumar", address2, 64358545, acct);
		Courier courier = new Courier(6, 202, initiatedDate, deliveryDate, "INITIATED", sender, reciever);
		boolean close = service.closeShipmentTransaction(courier.getCourierId());
		assertTrue(close);
	}

	@Test
	void testRejectShipmentTransaction() throws CourierNotFoundException {
		LocalDate initiatedDate = LocalDate.of(2017, 1, 13);
		LocalDate deliveryDate = LocalDate.of(2017, 1, 20);
		Address address1 = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600052);
		Address address2 = new Address("Avadi High Rd", "Chennai", "Tamil Nadu", "India", 600063);
		BankAccount acct = new BankAccount(70808060, "Sai Kiran", "Savings");
		Customer sender = new Customer(4, 494949949, "sai", "kiran", address1, 64278235, acct);
		Customer reciever = new Customer(2, 585858585, "Krishna", "Kumar", address2, 64358545, acct);
		Courier courier = new Courier(6, 202, initiatedDate, deliveryDate, "INITIATED", sender, reciever);
		boolean close = service.rejectShipmentTransaction(courier.getCourierId());
		assertTrue(close);
	}

}