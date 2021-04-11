package com.capg.ocma.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.controller.ManagerController;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.exception.ComplaintNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.DateNotFoundException;
import com.capg.ocma.model.CourierDTO;
import com.capg.ocma.repository.ICourierDao;
import com.capg.ocma.util.CourierUtil;

/*
 * Author : SRINIVAS MADIVAL
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Shipment Service Layer
*/
@Service
public class ShipmentServiceImp implements IShipmentService {
	
	static final Logger Logger = LoggerFactory.getLogger(ManagerController.class);
	
	static String courierNotFound = "Courier with given ID not found";
	
	@Autowired
	ICourierDao courierDao;

	@Override
	public CourierDTO addCourier(Courier courier) throws CourierNotFoundException, DateNotFoundException, ComplaintNotFoundException {
		Logger.info("addCourier() service is initiated");
		Courier courierEntity = null;

		if (!validateDate(courier.getInitiatedDate(),courier.getDeliveredDate())) 
			throw new DateNotFoundException("Date should not contain empty fields");
		
		else if (!validateCourierStatus(courier.getStatus()))
			throw new CourierNotFoundException("Invalid Courier Status");
		
		else if (!validateConsignmentNo(courier.getConsignmentNo())) 
			throw new CourierNotFoundException("please enter a valid consignment number");
		
		else
			Logger.info("addCourier() service has executed");
		
		courierEntity = courierDao.save(courier);
		
		return CourierUtil.convertToCourierDto(courierEntity);
	}

	@Override
	public boolean initiateShipmentTransaction(int courierId) throws CourierNotFoundException {

		if (!courierDao.existsById(courierId)) 
			throw new CourierNotFoundException(courierNotFound);

		else   
		{ 
			Courier courier = courierDao.findById(courierId).orElse(null);
			courier.setStatus("INITIATED");
			courierDao.save(courier);
		}
		return true;

	}

	@Override
	public String checkShipmentStatus(int courierId) throws CourierNotFoundException {

		if (!courierDao.existsById(courierId)) {

			throw new CourierNotFoundException(courierNotFound);

		} else {
			return courierDao.findById(courierId).orElse(null).getStatus();
		}
	}

	@Override
	public boolean closeShipmentTransaction(int courierId) throws CourierNotFoundException {
		if (!courierDao.existsById(courierId)) 
			throw new CourierNotFoundException(courierNotFound);

		else   
		{ 
			Courier courier = courierDao.findById(courierId).orElse(null);
			courier.setStatus("DELIVERED");
			courierDao.save(courier);
		}
		return true;

	}

	@Override
	public boolean rejectShipmentTransaction(int courierId) throws CourierNotFoundException {

		if (!courierDao.existsById(courierId)) 
			throw new CourierNotFoundException(courierNotFound);

		else   
		{ 
			Courier courier = courierDao.findById(courierId).orElse(null);
			courier.setStatus("REJECTED");
			courierDao.save(courier);
		}
		return true;


	}

	// Validation

public static boolean validateConsignmentNo(int consignmentNo) throws ComplaintNotFoundException {
		
		Logger.info("validateConsignmentNo() is initiated");
		
		boolean flag = false;
		String str = Integer.toString(consignmentNo);
		int size = str.length();
		if (size == 0)
			throw new ComplaintNotFoundException("Consignment no cant be empty");
		else if (!str.matches("^[0-9]+$"))
			throw new ComplaintNotFoundException("Consignment no invalid");
		else
			flag = true;
		Logger.info("validateConsignmentNo() has executed");
		
		return flag;
		
	}

	

	public static boolean validateCourierStatus(String status) throws CourierNotFoundException {
		boolean flag = false;
		if (status == null)
			throw new CourierNotFoundException("Courier status cannot be empty");

		else if (!status.matches("^[a-zA-Z ]+$"))
			throw new CourierNotFoundException("Courier status cannot contain Numbers or Special Characters");

		else if (status.equals("INITIATED") || status.equals("INTRANSIT") || status.equals("DELIVERED")
				|| status.equals("REJECTED"))
			flag = true;

		return flag;
	}

	public static boolean validateDate(LocalDate initiatedDate, LocalDate deliveredDate) throws DateNotFoundException {
		if (initiatedDate == null || deliveredDate == null) {
			throw new DateNotFoundException("Date should not be empty");
		} else
			return true;

	}
}