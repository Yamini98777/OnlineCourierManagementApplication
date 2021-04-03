package com.capg.ocma.service;

import com.capg.ocma.entities.Courier;

public interface IShipmentService {

	public void initiateShipmentTransaction(Courier courier);
	public void checkShipmentStatus(Courier courier);
	public void closeShipmentTransaction(Courier courier);
	public void rejectShipmentTransaction(Courier courier);
	
}
