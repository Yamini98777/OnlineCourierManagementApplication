package com.capg.ocma.service;

import com.capg.ocma.entities.Courier;
import com.capg.ocma.exception.CourierNotFoundException;

public interface IShipmentService {

	public void initiateShipmentTransaction(Courier courier) throws CourierNotFoundException;
	public void checkShipmentStatus(Courier courier) throws CourierNotFoundException;
	public void closeShipmentTransaction(Courier courier) throws CourierNotFoundException;
	public void rejectShipmentTransaction(Courier courier) throws CourierNotFoundException;
	
}
