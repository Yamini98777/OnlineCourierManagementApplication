package com.capg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.Customer;
import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.exception.CustomerNotFoundException;
import com.capg.ocma.repository.IBankAccountDao;
import com.capg.ocma.repository.ICustomerDao;



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
}
	
