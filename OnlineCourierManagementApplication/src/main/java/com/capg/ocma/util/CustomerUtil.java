package com.capg.ocma.util;


import java.util.ArrayList;
import java.util.List;

import com.capg.ocma.entities.Customer;
import com.capg.ocma.model.CustomerDTO;


public class CustomerUtil {
	public static List<CustomerDTO> convertToCustomerDtoList(List<Customer> list){
		List<CustomerDTO> dtolist = new ArrayList<CustomerDTO>();
		for(Customer customer : list) 
			dtolist.add( convertToCustomerDTO(customer));
		return dtolist;
	
}
	

	public static CustomerDTO convertToCustomerDTO(Customer customer) {
		CustomerDTO dto =new CustomerDTO();
		
		dto.setCustomerid(customer.getCustomerId());
		dto.setAadharno(customer.getAadharNo());
		dto.setFirstname(customer.getFirstName());
		dto.setLastname(customer.getLastName());
		dto.setMobileno(customer.getMobileNo());
		
		return dto;
	}
}


