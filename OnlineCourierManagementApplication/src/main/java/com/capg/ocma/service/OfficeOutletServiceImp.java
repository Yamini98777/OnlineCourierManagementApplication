package com.capg.ocma.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.exception.OutletClosedException;
import com.capg.ocma.exception.OutletNotFoundException;
import com.capg.ocma.exception.StaffMemberNotFoundException;
import com.capg.ocma.model.CourierOfficeOutletDTO;
import com.capg.ocma.repository.IOfficeOutletDao;
import com.capg.ocma.util.CourierOfficeOutletUtils;

@Service
public class OfficeOutletServiceImp implements IOfficeOutletService {
	@Autowired
	IOfficeOutletDao repo;

	@Override
	public CourierOfficeOutletDTO addNewOffice(CourierOfficeOutlet officeOutlet) {
	
		CourierOfficeOutlet officeoutletEntity;
		if (officeOutlet == null) {
			officeoutletEntity = null;
		} else {
			
//			CourierOfficeOutlet obj = new CourierOfficeOutlet(officeOutlet.getOfficeId(), officeOutlet.getAddress(), officeOutlet.getOpeningTime(), officeOutlet.getClosingTime(), officeOutlet.getStaffmembers());
			officeoutletEntity = repo.save(officeOutlet);
		}
		return CourierOfficeOutletUtils.converttoCourierOfficeOutletDTO(officeoutletEntity);
	}

	@Override
	public CourierOfficeOutletDTO removeNewOffice(CourierOfficeOutlet officeoutlet) {
		CourierOfficeOutlet existOffice = repo.findById(officeoutlet.getOfficeId()).orElse(null);
		if (existOffice == null)
			System.out.println("Office not Found");

		else
			repo.delete(existOffice);
		return CourierOfficeOutletUtils.converttoCourierOfficeOutletDTO(officeoutlet);

	}

	@Override
	public CourierOfficeOutlet getOfficeInfo(int officeid) throws OutletNotFoundException {
		if (repo.existsById(officeid) == false) {
			throw new OutletNotFoundException("Office doesn't exist");
		} else {
			return repo.findById(officeid).orElse(null);
		}

	}

	@Override
	public List<CourierOfficeOutletDTO> getAllOfficesData() throws OutletNotFoundException {
		if (repo.count() == 0) {
			throw new OutletNotFoundException("No Offices Exist");
		}
		List<CourierOfficeOutlet> list = repo.findAll();
		return CourierOfficeOutletUtils.converttoCourierOfficeOutletDtoList(list);

	}

	@Override
	public boolean isOfficeOpen(int officeId)  {
		
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
		            System.out.println(flag);
		            return flag;
		}
		
	
}
