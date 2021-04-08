package com.capg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.repository.IBankAccountDao;
import com.capg.ocma.repository.ICustomerDao;

/*
 * Author : PRADHIEEP K
 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Payment Service Layer that provides services to pay either by cash or card 
*/ 



@Service
public class PaymentServiceImp implements IPaymentService{

	@Autowired
	private ICustomerDao customerDao;
	
	@Autowired
	private IBankAccountDao bankAccountDao;
	
	/*
	 * Description : This method uses payment by cash 
	 * Return Value : True
	 */
	@Override
	public boolean processPaymentByCash() {
		
		return true;		
	}
	
	/*
	 * Description : This method uses payment by cash
	 * Input Param : Customer Object
	 * Return Value : true
	 * Exception : CustomerNotFoundException
	 */
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
	
