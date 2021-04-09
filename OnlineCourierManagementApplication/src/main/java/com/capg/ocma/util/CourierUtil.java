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
		
		courierDto.setCourierid(courier.getCourierId());
		courierDto.setStatus(courierDto.getStatus());
		courierDto.setSender(courierDto.getSender());
		courierDto.setReceiver(courierDto.getReceiver());
		courierDto.setConsignmentno(courier.getConsignmentNo());
		courierDto.setInitiatedDate(courier.getInitiatedDate());
		courierDto.setDeliveredDate(courier.getDeliveredDate());
				
		return courierDto;
	}
	
	
}
	
