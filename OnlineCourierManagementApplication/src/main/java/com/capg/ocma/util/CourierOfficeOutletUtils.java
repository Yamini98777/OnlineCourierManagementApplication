package com.capg.ocma.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.ocma.entities.CourierOfficeOutlet;
import com.capg.ocma.model.CourierOfficeOutletDTO;

public class CourierOfficeOutletUtils {
	public static List<CourierOfficeOutletDTO> converttoCourierOfficeOutletDtoList(List<CourierOfficeOutlet> list) {
		List<CourierOfficeOutletDTO> dtolist = new ArrayList<CourierOfficeOutletDTO>();
		for (CourierOfficeOutlet CourierOfficeOutlet : list)
			dtolist.add((CourierOfficeOutletDTO) converttoCourierOfficeOutletDTO(CourierOfficeOutlet));
		return dtolist;

	}

	public static CourierOfficeOutletDTO converttoCourierOfficeOutletDTO(CourierOfficeOutlet office) {
		CourierOfficeOutletDTO officedto = new CourierOfficeOutletDTO();
		officedto.setOfficeid(office.getOfficeId());
		officedto.setAddress(officedto.getAddress());
		officedto.setOpeningTime(office.getOpeningTime());
		officedto.setClosingTime(office.getClosingTime());
		officedto.setStaffmembers(officedto.getStaffmembers());
		return officedto;
	}
	
	/*
	 * public static CourierOfficeOutlet
	 * converttoCourierOfficeOutlet(CourierOfficeOutletDTO officedto) {
	 * CourierOfficeOutlet office = new CourierOfficeOutlet();
	 * office.setOfficeid(office.getOfficeid());
	 * office.setAddress(office.getAddress());
	 * office.setOpeningTime(office.getOpeningTime());
	 * office.setClosingTime(office.getClosingTime());
	 * office.setStaffmembers(office.getStaffmembers()); return office;
	 * 
	 * }
	 */

}
