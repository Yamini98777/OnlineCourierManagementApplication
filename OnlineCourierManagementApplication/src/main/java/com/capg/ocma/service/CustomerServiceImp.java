package com.capg.ocma.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.model.ComplaintDTO;
import com.capg.ocma.repository.IComplaintDao;
import com.capg.ocma.repository.ICourierDao;
import com.capg.ocma.repository.ICustomerDao;
import com.capg.ocma.util.ComplaintUtil;

/*
 * Author : GOMATHI M
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Customer Service Layer that provides services to Add New COmplaint,Checking tracking status, validating the entities
*/







@Service
public class CustomerServiceImp implements ICustomerService{
	
	final static Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImp.class);

	
	@Autowired
	ICustomerDao customerdao;
	@Autowired
	
	IComplaintDao complaintdao;
	
	@Autowired
	ICourierDao courierdao;
	
public void initiateProcess() {
	LOGGER.info(" service is initiated");
	
}
	
	public void makePayment() {
		
		LOGGER.info("makepayment() service is initiated");
		
	}
	
	/*
	 * Description : This method Checking the status of the Courier
	 * Input Param : int 
	 * Return Value : Courier status
	 * Exception : CourierNotFoundException
	 */
	public String checkOnlineTrackingStatus(int consignmentno) throws CourierNotFoundException  {
		Courier courier = courierdao.findById(consignmentno).orElse(null);
		String status=null;
		
		if(courier==null)
			throw new CourierNotFoundException("No courier with this consignment number exists...enter valid consignment number");
		else	
			status=courier.getStatus();
			
		return status;
	}
	
	/*
	 * Description : This method registers the complaint
	 * Input Param : Complaint object
	 * Return Value : ComplaintDTO object
	 * Exception : ComplaintNotFoundException
	 */
	public ComplaintDTO registerComplaint(Complaint complaint) throws ComplaintNotFoundException {
		
		LOGGER.info("registerComplaint() service is initiated");
		Complaint complaintEntity;
		
		if(complaint==null)
			complaintEntity=null;
		else if(!validateComplaintId(complaint))
			throw new ComplaintNotFoundException("Invalid complaintId");
		else
			complaintEntity=complaintdao.save(complaint);
				
			LOGGER.info("registerComplaint() service has executed");
					
				
				return ComplaintUtil.convertToComplaintDTO(complaintEntity);
			}
	
	//validation customerid

	public boolean validateCustomerId(int customerid) throws CustomerNotFoundException
	{
		boolean flag = customerdao.existsById(customerid);
		if(flag == false)
			throw new CustomerNotFoundException("customerid not found");
		else {
			LOGGER.info("Validation Successful");
		
			flag=true;
		}
		return flag;
	}

//validate mobno
		public static boolean validateNumber(long mobileNo) throws CustomerNotFoundException
		{
		boolean flag = false;
		String str=Long.toString(mobileNo);
		int size=str.length();
		if(size == 0)
			throw new CustomerNotFoundException("Mobileno cannot be empty");
		else if(size<=10 ||size>15)
			throw new CustomerNotFoundException("Mobileno not valid");
		else 
			flag = true;
		LOGGER.info("Validation Successful");
		
		return flag;
	}
	
	//validate aadharno
	public static boolean validatesetAadharno(long aadharNo) throws CustomerNotFoundException
	{
		boolean flag = false;
		String str=Long.toString(aadharNo);
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
	public static boolean validateComplaintId(Complaint complaint) throws ComplaintNotFoundException  {
		

		LOGGER.info("validateTenant() is initiated");
		boolean flag = false;
		if (complaint == null) {
			LOGGER.error("Tenant details cannot be blank");
			throw new ComplaintNotFoundException("Complaint details cannot be blank");
		} else if (!(validateConsignmentNo(complaint.getConsignmentNo()))) {
			LOGGER.error("Invalid Address");
			throw new ComplaintNotFoundException("Invalid consignment");
		} else {
			LOGGER.info("Validation Successful");
			flag = true;
		}
		LOGGER.info("validateTenant() has executed");
		return flag;
	}

		
//validate consignmentno
		public static boolean validateConsignmentNo(int consignmentNo) throws ComplaintNotFoundException
		{
			boolean flag = false;
			String str=Integer.toString(consignmentNo);
			int size=str.length();
			if(size == 0)
				throw new ComplaintNotFoundException("Consignment no cant be empty");
			else if(!str.matches("^[0-9a-zA-Z]+$" ))
				throw new ComplaintNotFoundException("Consignment no invalid");
			else
				flag = true;
			return flag;
		}
	
		
}
		

	

