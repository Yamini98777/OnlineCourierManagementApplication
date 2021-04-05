package com.capg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.Courier;
import com.capg.ocma.entities.CourierStatus;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.repository.ICourierDao;

@Service
public class ShipmentServiceImp implements IShipmentService{
	
	@Autowired
	ICourierDao courierDao;

	@Override
	public void initiateShipmentTransaction(Courier courier) throws CourierNotFoundException{
		 
          if(courierDao.existsById(courier.getCourierid()) == false) {
			
			throw new CourierNotFoundException("Courier with id " + courier.getCourierid() + " does not exist");
			
		} else{

			(courierDao.findById(courier.getCourierid()).orElse(null)).setStatus(CourierStatus.intransit);
			
		}
		
	}

	@Override
	public void checkShipmentStatus(Courier courier) throws CourierNotFoundException
	{
		
		 if(courierDao.existsById(courier.getCourierid()) == false) {
				
				throw new CourierNotFoundException("Courier with id " + courier.getCourierid() + " does not exist");
				
			} else{
				 (courierDao.findById(courier.getCourierid()).orElse(null)).getStatus().toString();
				}
	
	}

	@Override
	public void closeShipmentTransaction(Courier courier)throws CourierNotFoundException 
	{
		 if(courierDao.existsById(courier.getCourierid()) == false) {
				
				throw new CourierNotFoundException("Courier with id " + courier.getCourierid() + " does not exist");
				
			} else{
				(courierDao.findById(courier.getCourierid()).orElse(null)).setStatus(CourierStatus.delivered);
				
			}
	}

	@Override
	public void rejectShipmentTransaction(Courier courier)throws CourierNotFoundException  {
		 
		if(courierDao.existsById(courier.getCourierid()) == false) {
				
				throw new CourierNotFoundException("Courier with id " + courier.getCourierid() + " does not exist");
				
			} else{
				(courierDao.findById(courier.getCourierid()).orElse(null)).setStatus(CourierStatus.delivered);
				
	}

	

}
}
