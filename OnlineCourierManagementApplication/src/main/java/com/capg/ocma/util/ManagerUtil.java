package com.capg.ocma.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.ocma.entities.Manager;
import com.capg.ocma.model.ManagerDTO;


public class ManagerUtil {
	
public static List<ManagerDTO> convertToManagerDtoList(List<Manager> list) {
		
		List<ManagerDTO> dtolist = new ArrayList<ManagerDTO>();
		
		for (Manager manager : list)
			dtolist.add(convertToManagerDTO(manager));
		
		return dtolist;
	}


	public static ManagerDTO convertToManagerDTO(Manager manager) {
		ManagerDTO dto = new ManagerDTO();
		
		dto.setManagerId(manager.getManagerId());
		dto.setReportingstaffmembers(manager.getReportingStaffMembers());
		
		return dto;
	}
		
	
}
