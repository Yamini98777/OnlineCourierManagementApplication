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
		 
          if(courierDao.existsById(courier.getCourierId()) == false) {
			
			throw new CourierNotFoundException("Courier with id " + courier.getCourierId() + " does not exist");
			
		} else{

			(courierDao.findById(courier.getCourierId()).orElse(null)).setStatus(CourierStatus.INTRANSIT);
			
		}
		
	}

	@Override
	public void checkShipmentStatus(Courier courier) throws CourierNotFoundException
	{
		
		 if(courierDao.existsById(courier.getCourierId()) == false) {
				
				throw new CourierNotFoundException("Courier with id " + courier.getCourierId() + " does not exist");
				
			} else{
				 (courierDao.findById(courier.getCourierId()).orElse(null)).getStatus().toString();
				}
	
	}

	@Override
	public void closeShipmentTransaction(Courier courier)throws CourierNotFoundException 
	{
		 if(courierDao.existsById(courier.getCourierId()) == false) {
				
				throw new CourierNotFoundException("Courier with id " + courier.getCourierId() + " does not exist");
				
			} else{
				(courierDao.findById(courier.getCourierId()).orElse(null)).setStatus(CourierStatus.DELIVERED);
				
			}
	}

	@Override
	public void rejectShipmentTransaction(Courier courier)throws CourierNotFoundException  {
		 
		if(courierDao.existsById(courier.getCourierId()) == false) {
				
				throw new CourierNotFoundException("Courier with id " + courier.getCourierId() + " does not exist");
	
		else{

				(courierDao.findById(courier.getCourierId()).orElse(null)).setStatus(CourierStatus.DELIVERED);
				
	}

}
}
