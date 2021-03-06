package com.capg.ocma.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.ocma.entities.Address;
import com.capg.ocma.model.AddressDTO;

public class AddressUtil {
	
	public static List<AddressDTO> convertToAddressDtoList(List<Address> list) 
	{
		List<AddressDTO> dtolist = new ArrayList<AddressDTO>();
		
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
	
	/*
	 * public static Address convertToAddress(AddressDTO addressDto){
	 * 
	 * Address address = new Address();
	 * 
	 * address.setCity(addressDto.getCity());
	 * address.setCountry(addressDto.getCountry());
	 * address.setState(addressDto.getStreet());
	 * address.setStreet(addressDto.getStreet());
	 * address.setZip(addressDto.getZip());
	 * 
	 * return address;
	 * 
	 * }
	 */
}