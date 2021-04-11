package com.capg.ocma.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.controller.ManagerController;
import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.exception.InvalidAddressException;
import com.capg.ocma.exception.OfficeDetailsNullException;
import com.capg.ocma.exception.OutletClosedException;
import com.capg.ocma.exception.OutletNotFoundException;
import com.capg.ocma.model.CourierOfficeOutletDTO;
import com.capg.ocma.repository.IOfficeOutletDao;
import com.capg.ocma.util.CourierOfficeOutletUtils;
/*
 * Author : JEGANNATH P S
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Office outlet service Implementation layer which has implementaions from 
 * interface IOfficeOutletService.
*/

@Service
public class OfficeOutletServiceImp implements IOfficeOutletService {
	
	static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	@Autowired
	IOfficeOutletDao repo;
	
	/*
	 * Description  : This method adds new Office Outlet
	 * Input Param  : CourierOfficeOutlet
	 * Return Value : CourierOfficeOutletDTO Object 
	 */
	@Override
	public CourierOfficeOutletDTO addNewOffice(CourierOfficeOutlet officeOutlet) throws OfficeDetailsNullException,InvalidAddressException  {
		logger.info(" addNewOffice() service is initiated");
		CourierOfficeOutlet officeOutletEntity;
		
		if (!validateOfficeDetails(officeOutlet)) 
		     throw new OfficeDetailsNullException("Office Details cannot contain null fields");
		
		else if(!validateAddressZip(officeOutlet))
			throw new InvalidAddressException("Invalid Address Zip");

		else 
			officeOutletEntity = repo.save(officeOutlet);
		
		return CourierOfficeOutletUtils.converttoCourierOfficeOutletDTO(officeOutletEntity);
	}
	
	/*
	 * Description  : This method deletes existing Office outlet by taking the office id has reference.
	 * Input Param  : Integer 
	 * Return Value : CourierOfficeOutletDTO Object 
	 * Exception    : OutletNotFoundException
	 */
	

	@Override
	public CourierOfficeOutletDTO removeNewOffice(int officeId ) throws OutletNotFoundException
	{
		logger.info(" removeNewOffice() service is initiated");
		
		CourierOfficeOutlet existOffice = repo.findById(officeId).orElse(null);
		
		if(existOffice == null)
		        throw new OutletNotFoundException("Office outlet not found");
		else
			repo.delete(existOffice);
		
		logger.info(" removeNewOffice() service has executed");
		
		return CourierOfficeOutletUtils.converttoCourierOfficeOutletDTO(existOffice);

	}
	
	/*
	 * Description  : This method will fetch the details of existing office by using office ID has reference.
	 * Input Param  : Integer
	 * Return Value : CourierOfficeOutletDTO object
	 * Exception    : OutletNotFoundException
	 */

	@Override
	public CourierOfficeOutletDTO getOfficeInfo(int officeId) throws OutletNotFoundException {
		logger.info(" getOfficeInfo() service has executed");
		
		CourierOfficeOutlet existOffice = repo.findById(officeId).orElse(null);
		
		if (existOffice == null) 
			throw new OutletNotFoundException("Office doesn't exist");
			
		 else 
			logger.info(" getOfficeInfo() service has executed");
		
		return CourierOfficeOutletUtils.converttoCourierOfficeOutletDTO(existOffice);
		
	}
	/*
	 * Description  : This method shows all existing Office outlets in the database
	 * Return Value : List<OfficeStaffMemberDTO>
	 * Exception    : OutletNotFoundException
	 */
	@Override
	public List<CourierOfficeOutletDTO> getAllOfficesData() throws OutletNotFoundException
	{
		logger.info(" getAllOfficesData() service has executed");
		List<CourierOfficeOutlet> list;
		if (repo.count() == 0) 
			throw new OutletNotFoundException("No Offices Exist");
		
		else
			list = repo.findAll();
		
		return CourierOfficeOutletUtils.converttoCourierOfficeOutletDtoList(list);
	}
	/*
	 * Description  : This method checks whether the office is opened now by taking the current system time as reference.
	 * Input Param  : Integer
	 * Return Value : boolean
	 * Exception    : 
	 */
	

	@Override
	public boolean isOfficeOpenorClosed(int officeId) throws OutletClosedException {
		
		boolean flag = false;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.nnn");
		CourierOfficeOutlet office = repo.findById(officeId).orElse(null);
		String openTime = office.getOpeningTime();
		String closeTime = office.getClosingTime();
		
	    
		LocalTime open = LocalTime.parse(openTime, formatter);
		LocalTime close = LocalTime.parse(closeTime, formatter);
		
		if((close.equals(LocalTime.now()) || close.isBefore(LocalTime.now())) && open.isAfter(LocalTime.now()))  
                 flag = true;
			 else 
				flag = false;

		return flag;	
			
		}
	
	//Validations
	//VALIDATIONS 
		
		public static boolean validateOfficeDetails(CourierOfficeOutlet officeOutlet) throws OfficeDetailsNullException
		{
		            boolean flag = false;
		            if(officeOutlet.getOfficeId() == 0||officeOutlet.getOpeningTime()==null||officeOutlet.getClosingTime()==null)
		            	logger.error("Office fields should not be null");
		            else
		            	flag = true;
		            return flag;
		}
		public static boolean validateAddressZip( CourierOfficeOutlet officeOutlet) throws InvalidAddressException {
			
			boolean flag = false;
			String str = Integer.toString(officeOutlet.getAddress().getZip());
			int size = str.length();
			if (size == 0) 
				throw new InvalidAddressException("Address Zip should not be empty");
			
			else if(size > 0 && size <7) 
				throw new InvalidAddressException("Please Enter a valid Address Zip(within 7 digits)");
			else
				flag = true;
			return flag;
					
				
			}
		}