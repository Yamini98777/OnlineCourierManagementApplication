package com.capg.ocma.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.ocma.entities.Courier;
import com.capg.ocma.model.CourierDTO;


public class CourierUtil {
	public static List<CourierDTO> convertToCourierDtoList(List<Courier> list){
		
		List<CourierDTO> dtolist = new ArrayList<CourierDTO>();
		
		for(Courier courier : list) 
			dtolist.add(convertToCourierDto(courier));
		
		return dtolist;
   }
	
	public static CourierDTO convertToCourierDto(Courier courier) {
		
		CourierDTO courierDto = new CourierDTO();
		
		courierDto.setCourierid(courier.getCourierid());
		courierDto.setStatus(courierDto.getStatus());
		courierDto.setSender(courierDto.getSender());
		courierDto.setReceiver(courierDto.getReceiver());
		courierDto.setConsignmentno(courier.getConsignmentno());
		courierDto.setInitiatedDate(courier.getInitiatedDate());
		courierDto.setDeliveredDate(courier.getDeliveredDate());
				
		return courierDto;
	}
	
	/*
	 * public static Courier convertToCourier(CourierDTO courierDto) { 
	 * Courier courier = new Courier();
	 * 
	 * courier.setCourierid(courierDto.getCourierid()); 
	 * courier.setStatus(courier.getStatus());
	 * courier.setSender(courier.getSender()); 
	 * courier.setReceiver(courier.getReceiver());
	 * courier.setConsignmentno(courierDto.getConsignmentno());
	 * courier.setInitiatedDate(courierDto.getInitiatedDate());
	 * courier.setDeliveredDate(courierDto.getDeliveredDate());
	 * 
	 * return courier;
	 * 
	 * }
	 */
}
	
