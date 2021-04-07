package com.capg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.CourierStatus;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.exception.StaffMemberNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.repository.IComplaintDao;
import com.capg.ocma.repository.ICourierDao;
import com.capg.ocma.repository.ICustomerDao;
import com.capg.ocma.util.ComplaintUtil;

@Service
public class CustomerServiceImp implements ICustomerService{
	
	@Autowired
	ICustomerDao customerdao;
	@Autowired
	static
	IComplaintDao complaintdao;
	
	@Autowired
	ICourierDao courierdao;
	

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
				try {
					if(CustomerServiceImp.validateComplaintId(complaint.getComplaintId()))
					{	
					 
					}
					else
						throw new ComplaintNotFoundException("Invalid Complaint Details");
				} catch (ComplaintNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ComplaintUtil.convertToComplaintDTO(complaintEntity);
			}
	
	//validation customerid

	public boolean validateCustomerId(int customerid) throws CustomerNotFoundException
	{
		boolean flag = customerdao.existsById(customerid);
		if(flag == false)
			throw new CustomerNotFoundException("customerid not found");
		return flag;
	}

//validate mobno
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
	
	//validation complaintid

		public static boolean validateComplaintId(int complaintId) throws ComplaintNotFoundException
		{
			boolean flag = complaintdao.existsById(complaintId);
			if(flag == false)
				throw new ComplaintNotFoundException("complaintid not found");
			return flag;
		}
//validate consignmentno
		public static boolean validateConsignmentNo(int consignmentNo) throws ComplaintNotFoundException
		{
			boolean flag = false;
			String str=Integer.toString(consignmentNo);
			int size=str.length();
			if(str == null)
				throw new ComplaintNotFoundException("Consignment no cant be empty");
			else if(!str.matches("^[0-9a-zA-Z]+$" )&&(size==10))
				throw new ComplaintNotFoundException("Consignment no invalid");
			else
				flag = true;
			return flag;
		}
	
	
}
		

	

