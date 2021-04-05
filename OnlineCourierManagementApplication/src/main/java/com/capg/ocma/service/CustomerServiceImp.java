package com.capg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.CourierStatus;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.repository.IComplaintDao;
import com.capg.ocma.repository.ICourierDao;
import com.capg.ocma.util.ComplaintUtil;

@Service
public class CustomerServiceImp implements ICustomerService{
	
	
	@Autowired
	IComplaintDao complaintdao;
	
	@Autowired
	ICourierDao courierdao;
	
	public void initiateProcess() {
		
	}
	public void makePayment() {
		
	}
	

	public CourierStatus checkOnlineTrackingStatus(int consignmentno) {
		Courier courier = courierdao.findById(consignmentno).orElse(null);
		CourierStatus status=null;
		
		if(courier==null)
			System.out.println("No courier with this consignment number exists...enter valid consignment number");
		else	
			status=courier.getStatus();
			
		return status;
	}
	

	public ComplaintDTO registerComplaint(Complaint complaint) {
		 complaintdao.save(complaint);
			 Complaint complaintEntity;
				if(complaint == null)
					complaintEntity = null;
				else
					complaintEntity = complaintdao.save(complaint);
				return ComplaintUtil.convertToComplaintDTO(complaintEntity);
			}
		
	}
	

