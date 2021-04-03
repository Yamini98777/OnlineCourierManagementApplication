package com.capg.ocma.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.model.OfficeStaffMemberDTO;


public class OfficeStaffMemberUtil {

public static List<OfficeStaffMemberDTO> convertToOfficeStaffMemberDtoList(List<OfficeStaffMember> list) {
		
		List<OfficeStaffMemberDTO> dtolist = new ArrayList<OfficeStaffMemberDTO>();
		
		for (OfficeStaffMember officeStaffMember : list)
			dtolist.add(convertToOfficeStaffMemberDTO(officeStaffMember));
		
		return dtolist;
	}

	public static OfficeStaffMemberDTO convertToOfficeStaffMemberDTO(OfficeStaffMember officeStaffMember) {
		
		OfficeStaffMemberDTO dto = new OfficeStaffMemberDTO();
				
		dto.setEmpid(officeStaffMember.getEmpid());
		dto.setName(officeStaffMember.getName());
		dto.setRole(officeStaffMember.getRole());
		dto.setAddress(dto.getAddress());
		dto.setOffice(dto.getOffice());

		return dto;
		
	}
	
	/*
	 * public static OfficeStaffMember
	 * converttoOfficeStaffMember(OfficeStaffMemberDTO dto) {
	 * 
	 * OfficeStaffMember staff = new OfficeStaffMember();
	 * 
	 * staff.setEmpid(dto.getEmpid()); staff.setName(dto.getName());
	 * staff.setRole(dto.getRole()); staff.setOffice(staff.getOffice());
	 * staff.setAddress(staff.getAddress());
	 * 
	 * return staff; }
	 */

}
