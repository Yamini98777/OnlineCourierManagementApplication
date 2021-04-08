package com.capg.ocma.service;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.model.ComplaintDTO;

public interface ICustomerService {


	public void initiateProcess();
	
	public void makePayment();
	
	public String checkOnlineTrackingStatus(int consignmentno) throws CourierNotFoundException;
	
	public ComplaintDTO registerComplaint(Complaint complaint) throws ComplaintNotFoundException;
	
	
}
