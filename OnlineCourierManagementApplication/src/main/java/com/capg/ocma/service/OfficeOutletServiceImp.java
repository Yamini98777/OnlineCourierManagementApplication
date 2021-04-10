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
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.OutletClosedException;
import com.capg.ocma.exception.OutletNotFoundException;
import com.capg.ocma.exception.StaffMemberNotFoundException;
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
	
	final Logger Logger = LoggerFactory.getLogger(ManagerController.class);
	@Autowired
	IOfficeOutletDao repo;
	/*
	 * Description  : This method adds new Office Outlet
	 * Input Param  : CourierOfficeOutlet
	 * Return Value : CourierOfficeOutletDTO Object 
	 */
	@Override
	public CourierOfficeOutletDTO addNewOffice(CourierOfficeOutlet officeoutlet) {
		Logger.info(" addNewOffice() service is initiated");
		CourierOfficeOutlet officeoutletEntity;
		if (officeoutlet == null) {
			officeoutletEntity = null;
		} else {
			officeoutletEntity = repo.save(officeoutlet);
		}
		return CourierOfficeOutletUtils.converttoCourierOfficeOutletDTO(officeoutletEntity);
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
		Logger.info(" removeNewOffice() service is initiated");
		
		CourierOfficeOutlet existOffice = repo.findById(officeId).orElse(null);
		
		if(existOffice == null)
		        throw new OutletNotFoundException("Office outlet not found");
		else
			repo.delete(existOffice);
		
		Logger.info(" removeNewOffice() service has executed");
		
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
		Logger.info(" getOfficeInfo() service has executed");
		
		CourierOfficeOutlet existOffice = repo.findById(officeId).orElse(null);
		
		if (existOffice == null) {
			
			throw new OutletNotFoundException("Office doesn't exist");
			
		} else 
			Logger.info(" getOfficeInfo() service has executed");
		
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
		Logger.info(" getAllOfficesData() service has executed");
		if (repo.count() == 0) {
			throw new OutletNotFoundException("No Offices Exist");
		}
		else
		{
			List<CourierOfficeOutlet> list = repo.findAll();
		
		return CourierOfficeOutletUtils.converttoCourierOfficeOutletDtoList(list);
		}
	}
	/*
	 * Description  : This method checks whether the office is opened now by taking the current system time as reference.
	 * Input Param  : Integer
	 * Return Value : boolean
	 * Exception    : 
	 */

	@Override
	public boolean isOfficeOpen(int officeId) throws OutletClosedException {
		
			CourierOfficeOutlet officedto = repo.findById(officeId).orElse(null);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		
			String openTime = officedto.getOpeningTime();
			String closeTime = officedto.getClosingTime();
			LocalTime time = LocalTime.now();
			
		    
			LocalTime openingTime  = LocalTime.parse(openTime, formatter);
			LocalTime closingTime = LocalTime.parse(closeTime, formatter);
			
			if ((openingTime.equals(time) || closingTime.isBefore(time)) && closingTime.isAfter(time))
				{

				return true;
			} else 
			{
				return false;
			}
		}
	

	@Override
	public boolean isOfficeClosed(int officeId) throws OutletClosedException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		CourierOfficeOutlet officeDto = repo.findById(officeId).orElse(null);
		String openTime = officeDto.getOpeningTime();
		String closeTime = officeDto.getClosingTime();
		LocalTime time = LocalTime.now();
		
	    
		LocalTime openingTime  = LocalTime.parse(openTime, formatter);
		LocalTime closingTime = LocalTime.parse(closeTime, formatter);
		
		
		
			if ((closingTime.equals(time) || closingTime.isBefore(time)) && openingTime.isAfter(time)) {

				return true;
			} else {

				return false;

			}
			
		}
	
	//Validations
	//VALIDATIONS 
		public static boolean validateOfficeStaffMember(OfficeStaffMember officeStaffMember) throws StaffMemberNotFoundException
		{
			boolean flag = false;
			if(officeStaffMember == null)
				throw new StaffMemberNotFoundException("Staff member details cannot be blank");
			
			else if(!(validateName(officeStaffMember.getName()) && validateRole(officeStaffMember.getRole())))
				throw new StaffMemberNotFoundException("Invalid Data");
			
			else
				flag = true;
			
			return flag;
		}
		
		//validate empId
		public boolean validateEmpId(int empId) throws StaffMemberNotFoundException
		{
			boolean flag = repo.existsById(empId);
			if(flag == false)
				throw new StaffMemberNotFoundException("Staff member not found");
			return flag;
		}
		
		//validate name
		public static boolean validateName(String name) throws StaffMemberNotFoundException
		{
			boolean flag = false;
			if(name == null)
				throw new StaffMemberNotFoundException("Name cannot be empty");
			else if(!name.matches("^[a-zA-Z]+$"))
				throw new StaffMemberNotFoundException("Name cannot contain Numbers or Special Characters");
			else
				flag = true;
			return flag;
		}
		
		//validate role
		public static boolean validateRole(String role) throws StaffMemberNotFoundException
		{
			boolean flag = false;
			if(role == null)
				throw new StaffMemberNotFoundException("Name cannot be empty");
			
			else if(!role.matches("^[a-zA-Z]+$"))
				throw new StaffMemberNotFoundException("Name cannot contain Numbers or Special Characters");
			
			else if(role.equals("Analyst") || role.equals("Senior Analyst") || role.equals("Manager"))
				flag = true;
			
			return flag;
		}
		public static boolean ValidateOfficeDetails(CourierOfficeOutlet officeoutlet) 
		{
		            boolean flag = false;
		            if(officeoutlet.getOfficeId() == 0||officeoutlet.getOpeningTime()==null||officeoutlet.getClosingTime()==null)
		            	System.out.println("Office details should not be empty");
		            else
		            	flag = true;
		            return flag;
		}
		
		
		
	
}