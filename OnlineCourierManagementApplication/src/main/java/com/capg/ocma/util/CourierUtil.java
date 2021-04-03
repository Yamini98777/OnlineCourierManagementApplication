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
	
	
	public static Courier convertToCourier(CourierDTO cordto) {
		Courier cor = new Courier();
	
			cor.setCourierid(cordto.getCourierid());
			cor.setStatus(cor.getStatus());
			cor.setSender(cor.getSender());
			cor.setReceiver(cor.getReceiver());
			cor.setConsignmentno(cordto.getConsignmentno());
			cor.setInitiatedDate(cordto.getInitiatedDate());
			cor.setDeliveredDate(cordto.getDeliveredDate());
			
			return cor;
		
	}
	
	public static CourierDTO convertToCourierDto(Courier cor) {
		CourierDTO cordto = new CourierDTO();
		
				cordto.setCourierid(cor.getCourierid());
				cordto.setStatus(cordto.getStatus());
				cordto.setSender(cordto.getSender());
				cordto.setReceiver(cordto.getReceiver());
				cordto.setConsignmentno(cor.getConsignmentno());
				cordto.setInitiatedDate(cor.getInitiatedDate());
				cordto.setDeliveredDate(cor.getDeliveredDate());
				
		return cordto;
	}
	
}
	