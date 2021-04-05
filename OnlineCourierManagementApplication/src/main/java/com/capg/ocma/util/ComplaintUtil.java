package com.capg.ocma.util;



import java.util.ArrayList;
import java.util.List;

import com.capg.ocma.entities.Complaint;
import com.capg.ocma.model.ComplaintDTO;



public class ComplaintUtil {
	
			public static List<ComplaintDTO> convertToComplaintDtoList(List<Complaint> list){
				List<ComplaintDTO> dtolist = new ArrayList<ComplaintDTO>();
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
			/*public static Complaint convertToComplaint(ComplaintDTO dto) {
				Complaint complaint =new Complaint();
				
				complaint.setComplaintid(dto.getComplaintid());
				complaint.setConsignmentno(dto.getConsignmentno());
				complaint.setShortdescription(dto.getShortdescription());
				complaint.setDetaildescription(dto.getDetaildescription());
				

				return complaint;
				
			}*/

}


