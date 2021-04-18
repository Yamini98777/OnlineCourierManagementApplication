package com.capg.ocma.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.ocma.entities.Address;
import com.capg.ocma.model.AddressDTO;


public class AddressUtil {
	
	private AddressUtil() {
		super();
	}

	public static List<AddressDTO> convertToAddressDtoList(List<Address> list) 
	{
		List<AddressDTO> dtolist = new ArrayList<>();
		
		for (Address address : list)
			dtolist.add(convertToAddressDTO(address));
		
		return dtolist;
	}

	
	public static AddressDTO convertToAddressDTO(Address address){
		
		AddressDTO addressDto = new AddressDTO();
		
		addressDto.setCity(address.getCity());
		addressDto.setCountry(address.getCountry());
		addressDto.setState(address.getStreet());
		addressDto.setStreet(address.getStreet());
		addressDto.setZip(address.getZip());
		
		return addressDto;
		
	}
	
	
}