package com.capg.ocma.test;


import static org.junit.jupiter.api.Assertions.*;

import com.capg.ocma.exception.AccountNotFoundException;

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
	private ICustomerService customerService;

	Complaint complaint = null;
	Customer customer = null;
	BankAccount bank = null;
	Address addr = null;

	@BeforeAll
	public static void init1() {
		LOGGER.info("Customer Testing Initiated");
	}

	@Test
	void testregisterComplaint() throws ComplaintNotFoundException, AccountNotFoundException, CustomerNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "save");
		customer = new Customer(35, 123456789, "arthy", "M", addr, 908067282, bank);
		complaint = new Complaint(52, 120, "string", "string", customer);
	
		assertEquals(120, customerService.registerComplaint(complaint).getConsignmentno());
	
	}
	
	@Test
	void testregisterComplaint1() throws ComplaintNotFoundException,AccountNotFoundException,CustomerNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "Savings");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		customerService.addCustomer(customer);
		complaint = new Complaint(0, 120, "string", "string", customer);
		try
		{
			customerService.registerComplaint(complaint);
		}
		catch(ComplaintNotFoundException exception)
		{
			assertNotEquals("Complaint num cannot be empty", exception.getMessage());
		}
	}
	
	@Test
	void testregisterComplaint2() throws ComplaintNotFoundException,AccountNotFoundException, CustomerNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "Savings");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		customerService.addCustomer(customer);
		complaint = new Complaint(3, 100, "string", "string", customer);
		try
		{
			customerService.registerComplaint(complaint);
		}
		catch(ComplaintNotFoundException exception)
		{
			assertEquals(100, customerService.registerComplaint(complaint).getConsignmentno());
		}
	}

	@Test
	void testregisterComplaint3() throws ComplaintNotFoundException,AccountNotFoundException,CustomerNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "Savings");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		customerService.addCustomer(customer);
		complaint = new Complaint(3, 0, "string", "string", customer);
		try
		{
			customerService.registerComplaint(complaint);
		}
		catch(ComplaintNotFoundException exception)
		{
			assertNotEquals(120, customerService.registerComplaint(complaint).getConsignmentno());
		}
	}
	
	@Test
	void testregisterComplaint4() throws ComplaintNotFoundException,AccountNotFoundException,CustomerNotFoundException {

		LOGGER.info("Testing registerComplaint()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "Savings");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		customerService.addCustomer(customer);
		complaint = new Complaint(3, 0, "string", "string", customer);
		try
		{
			customerService.registerComplaint(complaint);
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
			customerService.checkOnlineTrackingStatus(consignmentNo);
		} catch (CourierNotFoundException exception) {
			assertEquals("No complaint with this consignment number exists...enter valid consignment number", exception.getMessage());
		}

	}
	
	@Test
	void testcheckOnlineTrackingStatus1() throws CourierNotFoundException {

		int consignmentNo=123;
		try {
			customerService.checkOnlineTrackingStatus(consignmentNo);
		} catch (CourierNotFoundException exception) {
			assertEquals("No complaint with this consignment number exists...enter valid consignment number", exception.getMessage());
		}

	}
	
	@Test
	void testaddCustomer() throws CustomerNotFoundException,AccountNotFoundException {
		LOGGER.info("Testing addCustomer()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "art", "Savings");
		customer = new Customer(2, 123456789, "arthy", "M", addr, 908067282, bank);
		assertEquals("arthy", customerService.addCustomer(customer).getFirstname());
		
	}
	
	@Test
	void testaddCustomer1() throws CustomerNotFoundException, AccountNotFoundException {
		LOGGER.info("Testing addCustomer()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "arthy", "Savings");
		customer = new Customer(2, 123456789, "gomathi", "M", addr, 908067282, bank);
		assertEquals("gomathi", customerService.addCustomer(customer).getFirstname());
		
	}
	
	@Test
	void testaddCustomer2() throws CustomerNotFoundException,AccountNotFoundException{
		LOGGER.info("Testing addCustomer()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "arthy", "Savings");
		customer = new Customer(2, 123456789, "gomathi", "M", addr, 908067282, bank);
		assertEquals(908067282, customerService.addCustomer(customer).getMobileno());
		
	}
	
	@Test
	void testaddCustomer3() throws CustomerNotFoundException,AccountNotFoundException {
		LOGGER.info("Testing addCustomer()");
		addr = new Address("east street", "Chennai", "Tamil Nadu", "India", 666666);
		bank = new BankAccount(122, "arthy", "Savings");
		customer = new Customer(2, 123456789, "gomathi", "M", addr, 908067282, bank);
		assertEquals(123456789, customerService.addCustomer(customer).getAadharno());
		
	}
	
// VALIDATIONS FOR BANK ACCOUNT	

	@Test
	void testaddCustomer4() throws AccountNotFoundException,CustomerNotFoundException {
		
		LOGGER.info("Testing testaddCustomer4()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(654753, "Pradhieep", "Savings");
		customer = new Customer(2, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		
		try
		{
			customerService.addCustomer(customer);
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Number cannot be 0 or Negative", exception.getMessage());
		}	
	}
	
	@Test
	void testaddCustomer5() throws AccountNotFoundException,CustomerNotFoundException {
		
		LOGGER.info("Testing testaddCustomer5()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(0, "Pradhieep", "Savings");
		customer = new Customer(2, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		
		try
		{
			customerService.addCustomer(customer);
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Number cannot be 0 or Negative", exception.getMessage());
		}	
	}
		
	
	
	@Test
	void testaddCustomer6() throws AccountNotFoundException,CustomerNotFoundException {
		
		LOGGER.info("Testing testaddCustomer6()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(-1, "Pradhieep", "Savings");
		customer = new Customer(2, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		try
		{
			customerService.addCustomer(customer);
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Number cannot be 0 or Negative", exception.getMessage());
		}	
	}
	
	@Test
	void testaddCustomer7() throws AccountNotFoundException,CustomerNotFoundException {
		
		LOGGER.info("Testing testaddCustomer7()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(9, "Pradhieep", "Savings");
		customer = new Customer(2, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		try
		{
			customerService.addCustomer(customer);
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Number size cannot be below 2 or above 9", exception.getMessage());
		}	
	} 
	
	@Test
	void testaddCustomer8() throws AccountNotFoundException,CustomerNotFoundException {
		
		LOGGER.info("Testing testaddCustomer8()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(1111111111, "Pradhieep", "Savings");
		customer = new Customer(2, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		try
		{
			customerService.addCustomer(customer);
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Number size cannot be below 2 or above 9", exception.getMessage());
		}	
	}
	
	@Test
	void testaddCustomer9() throws AccountNotFoundException,CustomerNotFoundException {
		
		LOGGER.info("Testing testaddCustomer9()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(654753, "Pradhieep$", "Savings");
		customer = new Customer(2, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		try
		{
			customerService.addCustomer(customer);
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Holder Name cannot contain Numbers or Special Characters", exception.getMessage());
		}	
	}
	
	@Test
	void testaddCustomer10() throws AccountNotFoundException,CustomerNotFoundException {
		
		LOGGER.info("Testing testaddCustomer10()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(654753, "Pradhieep01", "Savings");
		customer = new Customer(2, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		try
		{
			customerService.addCustomer(customer);
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Holder Name cannot contain Numbers or Special Characters", exception.getMessage());
		}	
	}
	
	@Test
	void testaddCustomer11() throws AccountNotFoundException,CustomerNotFoundException {
		
		LOGGER.info("Testing testaddCustomer11()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(654753, "Pradhieep", "Savings%");
		customer = new Customer(2, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		try
		{
			customerService.addCustomer(customer);
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Type cannot contain Numbers or Special Characters", exception.getMessage());
		}	
	}
	
	@Test
	void testaddCustomer12() throws AccountNotFoundException,CustomerNotFoundException {
		
		LOGGER.info("Testing testaddCustomer12()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(654753, "Pradhieep", "Savings01");
		customer = new Customer(2, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		try
		{
			customerService.addCustomer(customer);
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Account Type cannot contain Numbers or Special Characters", exception.getMessage());
		}	
	}
	
	@Test
	void testaddCustomer13() throws AccountNotFoundException,CustomerNotFoundException {
		
		LOGGER.info("Testing testaddCustomer13()");
		
		addr = new Address("East street", "Chennai", "Tamil Nadu", "India", 600021);
		bank = new BankAccount(654753, "Pradhieep", "Pradhieep");
		customer = new Customer(2, 175956895, "Pradhieep", "K", addr, 1807774755, bank);
		try
		{
			customerService.addCustomer(customer);
		}
		catch(AccountNotFoundException exception)
		{
			assertEquals( "Invalid Data", exception.getMessage());
		}	
	}
	
	@AfterAll
	public static void init() {
		LOGGER.info("Customer Testing Successful");
	}

}