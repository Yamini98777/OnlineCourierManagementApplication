package com.capg.ocma.service;

import com.capg.ocma.entities.Courier;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.model.CourierDTO;

public interface IShipmentService {

	public boolean initiateShipmentTransaction(Courier courier) throws CourierNotFoundException;
	public String checkShipmentStatus(Courier courier) throws CourierNotFoundException;
	public boolean closeShipmentTransaction(Courier courier) throws CourierNotFoundException;
	public boolean rejectShipmentTransaction(Courier courier) throws CourierNotFoundException;
	
}
