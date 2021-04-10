package com.capg.ocma.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.repository.IBankAccountDao;
import com.capg.ocma.repository.ICustomerDao;



@Service
public class PaymentServiceImp implements IPaymentService{
	final static Logger logger = LoggerFactory.getLogger(CustomerServiceImp.class);

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
		
		Customer customer = customerDao.findById(customerId).orElse(null);
	
		boolean flag = false;
		if(customer==null) 
			throw new CustomerNotFoundException("Customer Not found");
		else
			flag = true;
		return flag;
	}
	
	
	public static boolean validateAccountNo(long accountNo) throws AccountNotFoundException
	{
		boolean flag = false;
		if(accountNo <=0) {
			
			throw new AccountNotFoundException("Ivalild account No");
			
		}else {
				flag = true;
		}
		
		return flag;
	}
	public static boolean validateAccountHolderName(String accountHolderName) throws AccountNotFoundException{
		boolean flag = false;
		
		if(accountHolderName == null)
			throw new AccountNotFoundException("Account Holder Name cannot be empty ");
		else if (!accountHolderName.matches("^[a-zA-Z]+$"))
			throw new AccountNotFoundException("Account Holder Name cannot contain Numbers or Special Characters");
		else 
			flag = true;
		
		return flag;
		
	}
	
	public static boolean validateAccountType(String accountType) throws AccountNotFoundException{
		boolean flag = false;
		
		if(accountType == null)
			throw new AccountNotFoundException("Account Type cannot be empty");
		else if(!accountType.matches("^[a-zA-Z]+$")) 
			throw new AccountNotFoundException("Account Type cannot contain Numbers or Special Characters");
		else if(accountType.equals("Current") || accountType.equals("Savings") || accountType.equals("Salary"))
			flag = true;
			
		return flag;
		
	}
}
	
