package com.capg.ocma.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.Courier;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
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
public class ShipmentServiceImp implements IShipmentService{
	
	@Autowired
	ICourierDao courierDao;
	
	final static Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImp.class);

	
	@Override
	public CourierDTO addCourier(Courier courier) throws CourierNotFoundException
	{
		LOGGER.info("addCourier() service is initiated");
		Courier courierEntity;

		if (courier == null)
			courierEntity = null;
		else
		{
			courierEntity = courierDao.save(courier);

			LOGGER.info("addCourier() service has executed");
		}

		return CourierUtil.convertToCourierDto(courierEntity);
	}
	
	
	@Override
	public boolean initiateShipmentTransaction(Courier courier) throws CourierNotFoundException
	{
		
          if(courierDao.existsById(courier.getCourierId()) == false) {
			
			throw new CourierNotFoundException("Courier with id " + courier.getCourierId() + " does not exist");
			
		} else
         
			(courierDao.findById(courier.getCourierId()).orElse(null)).setStatus("INTRANSIT");
			
		return true;
		
	}

	@Override
	public String checkShipmentStatus(Courier courier) throws CourierNotFoundException
	{
		
		 if(courierDao.existsById(courier.getCourierId()) == false) {
				
				throw new CourierNotFoundException("Courier with id " + courier.getCourierId() + " does not exist");
				
			} else {
				return (courierDao.findById(courier.getCourierId()).orElse(null)).getStatus().toString();
				
			}
	}

	@Override
	public boolean closeShipmentTransaction(Courier courier)throws CourierNotFoundException 
	{
		 if(courierDao.existsById(courier.getCourierId()) == false) {
				
				throw new CourierNotFoundException("Courier with id " + courier.getCourierId() + " does not exist");
				
			} else{
				(courierDao.findById(courier.getCourierId()).orElse(null)).setStatus("DELIVERED");
				
			}
		 return true;
	}

	@Override
	public boolean rejectShipmentTransaction(Courier courier)throws CourierNotFoundException  {
		 
		if(courierDao.existsById(courier.getCourierId()) == false) 
				
				throw new CourierNotFoundException("Courier with id " + courier.getCourierId() + " does not exist");
	
		else{

				(courierDao.findById(courier.getCourierId()).orElse(null)).setStatus("DELIVERED");
				
			}
		return true;
		}
	
//	VALIDATE courierId
	
	public boolean validateCourierId(int courierId) throws CourierNotFoundException
	{
		boolean flag=false;
		
		if(courierId<=0)
			throw new CourierNotFoundException("Invalid Courier ID");
		else 
			flag = true;
		return flag;
	}

         
	

}


