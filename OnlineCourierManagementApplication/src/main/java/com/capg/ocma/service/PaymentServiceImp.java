package com.capg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
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
	public boolean processPaymentByCard(int customerId) throws CustomerNotFoundException{
		
		boolean flag = false;
		if(customerDao.existsById(customerId)) {
			
			if(customerDao.findById(customerId).orElse(null).getAcct() != null) {
				
				flag = true;
				
			}else {
				throw new CustomerNotFoundException("Customer Not found");
				
			}
		}
		return flag;

	}
	
	
	public static boolean validateAccountNo(int accountNo) throws AccountNotFoundException
	{
		boolean flag = false;
		if(accountNo <=0) {
			
			throw new AccountNotFoundException("Ivalild account No");
			
		}else {
				flag = true;
		}
		
		return flag;
	}
}
	
	
	
	



















	
	
	// TODO Auto-generated method stub
	
	/* public BankAccountDTO processPaymentByCard(int customerId) throws AccountNotFoundException{
		
		BankAccount BankAccount = bankAccountDao.findById(customerId).orElse(null);
		
		if(BankAccount == null) {
			
			throw new AccountNotFoundException("Account Number not found");
			
			}
		else {
			
			return BankAccountUtil.convertToBankAccountDto(BankAccount);
		}
	
}
	
	//Validations
	
	public static boolean validateAccNo(int accountNo) throws AccountNotFoundException{
		boolean flag = false;
		
		if(accountNo == 0)
			throw new AccountNotFoundException("Account Number Cannot be empty");
		
		else if(Integer.toString(BankAccount.getAccountNo()).matches("[0-9]"))
		throw new AccountNotFoundException("Account Number should contain only numbers");
		
		else
			flag = true; 
		
		return flag;
		
	} */
