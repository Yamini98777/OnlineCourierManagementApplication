package com.capg.ocma.service;


import com.capg.ocma.entities.Courier;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.DateNotFoundException;
import com.capg.ocma.model.CourierDTO;

public interface IShipmentService {

	public boolean initiateShipmentTransaction(int courierId) throws CourierNotFoundException;
	public String checkShipmentStatus(int courierId) throws CourierNotFoundException;
	
	public boolean closeShipmentTransaction(int courierId) throws CourierNotFoundException;
	public boolean rejectShipmentTransaction(int courierId) throws CourierNotFoundException;
	public CourierDTO addCourier(Courier courier) throws CourierNotFoundException,DateNotFoundException, ComplaintNotFoundException;
	
}