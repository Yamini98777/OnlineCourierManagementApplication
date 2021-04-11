package com.capg.ocma.service;

import java.util.List;

import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.exception.InvalidAddressException;
import com.capg.ocma.exception.OfficeDetailsNullException;
import com.capg.ocma.exception.OutletClosedException;
import com.capg.ocma.exception.OutletNotFoundException;
import com.capg.ocma.model.CourierOfficeOutletDTO;

public interface IOfficeOutletService {
	
	public CourierOfficeOutletDTO addNewOffice(CourierOfficeOutlet officeoutlet) throws OfficeDetailsNullException, InvalidAddressException;
	public CourierOfficeOutletDTO removeNewOffice(int officeId) throws OutletNotFoundException;
	public CourierOfficeOutletDTO getOfficeInfo(int officeId) throws OutletNotFoundException;
	public List<CourierOfficeOutletDTO> getAllOfficesData() throws OutletNotFoundException;
	
	
	public boolean isOfficeOpenorClosed(int officeid)throws OutletClosedException;
	
}