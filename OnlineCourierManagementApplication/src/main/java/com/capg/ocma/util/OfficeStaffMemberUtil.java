package com.capg.ocma.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.ocma.entities.OfficeStaffMember;
import com.capg.ocma.model.OfficeStaffMemberDTO;


public class OfficeStaffMemberUtil {

	
	private OfficeStaffMemberUtil() {
		super();
	}

	public static List<OfficeStaffMemberDTO> convertToOfficeStaffMemberDtoList(List<OfficeStaffMember> list) {
		
		List<OfficeStaffMemberDTO> dtolist = new ArrayList<>();
		
		for (OfficeStaffMember officeStaffMember : list)
			dtolist.add(convertToOfficeStaffMemberDTO(officeStaffMember));
		
		return dtolist;
	}

	public static OfficeStaffMemberDTO convertToOfficeStaffMemberDTO(OfficeStaffMember officeStaffMember) {
		
		OfficeStaffMemberDTO dto = new OfficeStaffMemberDTO();
				
		dto.setEmpid(officeStaffMember.getEmpid());
		dto.setName(officeStaffMember.getName());
		dto.setRole(officeStaffMember.getRole());
		dto.setAddress(officeStaffMember.getAddress());
		dto.setOffice(officeStaffMember.getOfficeOutlet());
		dto.setManagerId(officeStaffMember.getManagerId());

		return dto;
		
	}

}