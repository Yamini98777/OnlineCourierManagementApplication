package com.capg.ocma.util;



import java.util.ArrayList;
import java.util.List;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.model.ComplaintDTO;


public class ComplaintUtil {
	
	private ComplaintUtil() {
		super();
	}

	public static List<ComplaintDTO> convertToComplaintDtoList(List<Complaint> list){
		List<ComplaintDTO> dtolist = new ArrayList<>();
		for(Complaint complaint : list) 
			dtolist.add(convertToComplaintDTO(complaint));
		return dtolist;
			
		}
			
		public static ComplaintDTO convertToComplaintDTO(Complaint complaint) {
			ComplaintDTO complaintdto =new ComplaintDTO();
				
			complaintdto.setComplaintid(complaint.getComplaintId());
			complaintdto.setConsignmentno(complaint.getConsignmentNo());
			complaintdto.setShortdescription(complaint.getDetailDescription());
			complaintdto.setDetaildescription(complaint.getDetailDescription());
			
			return complaintdto;
			}
			

}