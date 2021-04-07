package com.capg.ocma.service;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.CourierStatus;
import com.capg.ocma.model.ComplaintDTO;

public interface ICustomerService {


	public CourierStatus checkOnlineTrackingStatus(int consignmentno);
	
	public ComplaintDTO registerComplaint(Complaint complaint);
	
	
}
