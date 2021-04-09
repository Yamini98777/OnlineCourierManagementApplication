package com.capg.ocma.service;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.model.CustomerDTO;

public interface ICustomerService {


	public void initiateProcess();
	
	public void makePayment();
	
	public String checkOnlineTrackingStatus(int consignmentno) throws CourierNotFoundException;
	
	public ComplaintDTO registerComplaint(Complaint complaint) throws ComplaintNotFoundException;
	
	public CustomerDTO addCustomer(Customer customer) throws CustomerNotFoundException;
	
	
}
