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
	
	    private static BankAccountDTO convertToBankAccountDto(BankAccount bank) {
		BankAccountDTO dto = new BankAccountDTO();
		
		dto.setAccountno(bank.getAccountno());
		dto.setAccountHolderName(bank.getAccountHolderName());
		dto.setAccountType(bank.getAccountType());
		
		return dto;
	}
	
	/*
	 * public static BankAccount convertToBankAccount(BankAccountDTO dto) {
	 * BankAccount bank =new BankAccount();
	 * 
	 * bank.setAccountno(dto.getAccountno());
	 * bank.setAccountHolderName(dto.getAccountHolderName());
	 * bank.setAccountType(dto.getAccountType()); return bank;
	 * 
	 * }
	 */
}