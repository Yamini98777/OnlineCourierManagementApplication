package com.capg.ocma.service;

import java.util.List;

import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.exception.OutletClosedException;
import com.capg.ocma.exception.OutletNotFoundException;
import com.capg.ocma.model.CourierOfficeOutletDTO;

public interface IOfficeOutletService {
	
	public CourierOfficeOutletDTO addNewOffice(CourierOfficeOutlet officeoutlet);
	public CourierOfficeOutletDTO removeNewOffice(CourierOfficeOutlet officeoutlet) throws OutletNotFoundException;
	public CourierOfficeOutlet getOfficeInfo(int officeid) throws OutletNotFoundException;
	public List<CourierOfficeOutletDTO> getAllOfficesData() throws OutletNotFoundException;
	
	public boolean isOfficeOpen(CourierOfficeOutlet officeoutlet) throws OutletClosedException;
	public boolean isOfficeClosed(CourierOfficeOutlet officeoutlet)throws OutletClosedException;
	
}
