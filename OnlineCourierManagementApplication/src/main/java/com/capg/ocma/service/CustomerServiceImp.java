package com.capg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.CourierStatus;
import com.capg.ocma.exception.CustomerNotFoundException;
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
	//validation customerid

		public boolean validateCustomerid(int customerid) throws CustomerNotFoundException
		{
			boolean flag = complaintdao.existsById(customerid);
			if(flag == false)
				throw new CustomerNotFoundException("customerid not found");
			return flag;
		}

	//validate name
			public static boolean validateNumber(int mobileNo) throws CustomerNotFoundException
			{
			boolean flag = false;
			String str=Integer.toString(mobileNo);
			int size=str.length();
			if(size == 0)
				throw new CustomerNotFoundException("Mobileno cannot be empty");
			else if(size<10 ||size>15)
				throw new CustomerNotFoundException("Mobileno not valid");
			else 
				flag = true;
			return flag;
		}
		
		//validate aadharno
		public static boolean validatesetAadharno(int aadharNo) throws CustomerNotFoundException
		{
			boolean flag = false;
			String str=Integer.toString(aadharNo);
			int size=str.length();
			if(size ==0)
				throw new CustomerNotFoundException("AAdhaarno cannot be empty");
			
			else if(size>12|| size<12)
				throw new CustomerNotFoundException("Enter valid aadhar number");
			
			else if(size==12)
				flag = true;
			
			return flag;
		}
	}


