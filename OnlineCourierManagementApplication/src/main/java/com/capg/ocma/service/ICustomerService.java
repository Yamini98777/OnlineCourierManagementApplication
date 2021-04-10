package com.capg.ocma.service;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.model.CustomerDTO;

public interface ICustomerService {


	
	
	public String checkOnlineTrackingStatus(int consignmentno) throws CourierNotFoundException;
	
	public ComplaintDTO registerComplaint(Complaint complaint) throws ComplaintNotFoundException;
	
	public CustomerDTO addcustomer(Customer customer);
	
	
}
