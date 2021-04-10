package com.capg.ocma.util;

import java.util.ArrayList;
import java.util.List;

import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.model.BankAccountDTO;

public class BankAccountUtil {
	public static List<BankAccountDTO> convertToBankAccountDtoList(List<BankAccount> list){
		List<BankAccountDTO> dtolist = new ArrayList<BankAccountDTO>();
		for(BankAccount BankAccount : list) 
			dtolist.add(convertToBankAccountDto(BankAccount));
		return dtolist;
	}
	
	
	    public static BankAccountDTO convertToBankAccountDto(BankAccount bank) {
		BankAccountDTO dto = new BankAccountDTO();
		
		dto.setAccountno(bank.getAccountNo());
		dto.setAccountHolderName(bank.getAccountHolderName());
		dto.setAccountType(bank.getAccountType());
		
		return dto;
	}
	
	
}