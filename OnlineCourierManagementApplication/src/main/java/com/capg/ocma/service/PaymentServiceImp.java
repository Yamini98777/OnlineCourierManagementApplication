package com.capg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.model.BankAccountDTO;
import com.capg.ocma.repository.IBankAccountDao;
import com.capg.ocma.repository.ICustomerDao;
import com.capg.ocma.util.BankAccountUtil;


@Service
public class PaymentServiceImp implements IPaymentService{

	@Autowired
	ICustomerDao customerDao;
	
	@Autowired
	IBankAccountDao bankAccountDao;
	
	@Override
	public boolean processPaymentByCash() {
		return true;	
	}
	
	
	@Override
	public boolean processPaymentByCard(int customerid) {
		boolean flag = false;
		
		if(customerDao.existsById(customerid)) {
			
			if(customerDao.findById(customerid).orElse(null).getAcct() != null) {
				flag = true;
				
			}
			else {
				flag = false;
			}
			
		}
		return flag;
		
	}
	public BankAccountDTO getAccount(int accountno) throws AccountNotFoundException{
		BankAccount BankAccount = bankAccountDao.findById(accountno).orElse(null);
		if(Integer.toString(BankAccount.getAccountNo()).matches("[0-9]")) {
			return BankAccountUtil.convertToBankAccountDto(BankAccount);
			
		}
		else {
			throw new AccountNotFoundException("Accont Number not found");
		}
	
}
	
}