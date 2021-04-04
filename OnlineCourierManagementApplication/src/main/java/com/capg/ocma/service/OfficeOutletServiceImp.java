package com.capg.ocma.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.exception.OutletClosedException;
import com.capg.ocma.exception.OutletNotFoundException;
import com.capg.ocma.model.CourierOfficeOutletDTO;
import com.capg.ocma.repository.IOfficeOutletDao;
import com.capg.ocma.util.CourierOfficeOutletUtils;

@Service
public class OfficeOutletServiceImp implements IOfficeOutletService {
	@Autowired
	IOfficeOutletDao repo;
	
	

	@Override
	public CourierOfficeOutletDTO addNewOffice(CourierOfficeOutlet officeoutlet) {
		CourierOfficeOutlet officeoutletEntity;
		if(officeoutlet == null) {
			officeoutletEntity = null;
		}
		else {
			officeoutletEntity = repo.save(officeoutlet);
		}
		return CourierOfficeOutletUtils.converttoCourierOfficeOutletDTO(officeoutletEntity);
	}

	@Override
	public CourierOfficeOutletDTO removeNewOffice(CourierOfficeOutlet officeoutlet)  {
		CourierOfficeOutlet existOffice = repo.findById(officeoutlet.getOfficeid()).orElse(null);
		if(existOffice == null) 
               System.out.println("Office not Found");
		
               else 
            	   repo.delete(existOffice);
            	   return CourierOfficeOutletUtils.converttoCourierOfficeOutletDTO(officeoutlet);
		
	
	}

	@Override
	public CourierOfficeOutlet getOfficeInfo(int officeid) throws OutletNotFoundException {
		if(repo.existsById(officeid) == false) {
			throw new OutletNotFoundException("Office doesn't exist");
		}
			else {
				return repo.findById(officeid).orElse(null);
			}
		
	}

	@Override
	public List<CourierOfficeOutletDTO> getAllOfficesData() throws OutletNotFoundException {
		if(repo.count()==0) {
			throw new OutletNotFoundException("No Offices Exist");
		}
		List<CourierOfficeOutlet> list = repo.findAll();
		return CourierOfficeOutletUtils.converttoCourierOfficeOutletDtoList(list);

	}

	@Override
	public boolean isOfficeOpen(CourierOfficeOutlet officeoutlet) throws OutletClosedException {
		if (repo.existsById(officeoutlet.getOfficeid()) == false) {
			throw new OutletClosedException("The Office is closed");
}
		else {
			CourierOfficeOutlet officedto = repo.findById(officeoutlet.getOfficeid()).orElse(null);
			LocalTime open = LocalTime.from(officedto.getOpeningTime());
			LocalTime close = LocalTime.from(officedto.getClosingTime());
			if((open.equals(LocalTime.now()) || open.isBefore(LocalTime.now())) && close.isAfter(LocalTime.now())){
				
				return true;
			}
			else {
				return false;
			}
		}
	}

	@Override
	public boolean isOfficeClosed(CourierOfficeOutlet officeoutlet) throws OutletClosedException {
		if(repo.findById(officeoutlet.getOfficeid())==null) {
			throw new OutletClosedException("The Office is unavailable");
		}
		else {
			CourierOfficeOutlet officedto = repo.findById(officeoutlet.getOfficeid()).orElse(officeoutlet);
			LocalTime open = LocalTime.from(officedto.getOpeningTime());
			LocalTime close = LocalTime.from(officedto.getClosingTime());
		
			if((close.equals(LocalTime.now()) || close.isBefore(LocalTime.now())) && open.isAfter(LocalTime.now())) {
				
				return true;
			}
			else {
				
				return false;
				
			}
		}
	}
}
