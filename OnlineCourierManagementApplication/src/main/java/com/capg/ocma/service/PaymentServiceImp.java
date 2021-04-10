package com.capg.ocma.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.entities.BankAccount;
import com.capg.ocma.entities.Courier;
import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.model.CourierDTO;
import com.capg.ocma.repository.IBankAccountDao;
import com.capg.ocma.repository.ICourierDao;
import com.capg.ocma.util.CourierUtil;

/*
 * Author      : PRADHIEEP K
 * Version     : 1.0
 * Date        : 04-04-2021
 * Description : This is Payment Service Layer that provides services to pay either by cash or card.
*/ 


@Service
public class PaymentServiceImp implements IPaymentService{

	final static Logger logger = LoggerFactory.getLogger(PaymentServiceImp.class);
	
	@Autowired
	private IBankAccountDao bankAccountRepo;

	@Autowired
	private ICourierDao courierRepo;
	
	
	/*
	 * Description  : This method uses payment by cash 
	 * Return Value : True
	 */
	@Override
	public CourierDTO processPaymentByCash(int courierId) throws CourierNotFoundException {
		
		logger.info(" process Payment by Cash is initialized");
		
		Courier courier = courierRepo.findById(courierId).orElse(null);
		
		if(courier == null)
			
			throw new CourierNotFoundException("No courier found with given courier ID");
		
		return CourierUtil.convertToCourierDto(courier);		
	}
	
	/*
	 * Description  : This method uses payment by cash
	 * Input Param  : Customer Object
	 * Return Value : true
	 * Exception    : CustomerNotFoundException
	 */
	@Override
	public boolean processPaymentByCard(long accountNo) throws AccountNotFoundException{
		
		logger.info(" Process Payment by card is initiated");
		
		BankAccount bankAccount = bankAccountRepo.findById(accountNo).orElse(null);
		
		boolean flag = false;
		
		if(bankAccount == null)
			
			throw new AccountNotFoundException("No Account found with given account number");
		
		else
			flag = true;
		
		logger.info(" Process Payment by card has been executed");
		
		return flag;
	}
	
/*	public static boolean validateBankAccount(BankAccount bankAccount) throws AccountNotFoundException
	{
		boolean flag = false;
		if(bankAccount == null)
			throw new AccountNotFoundException("Bank account details cannot be blank");
		
		else if(!(validateAccountNo(bankAccount.getAccountNo()) && validateAccountHolderName(bankAccount.getAccountHolderName())
				&& validateAccountType(bankAccount.getAccountType())))
			throw new AccountNotFoundException("Invalid Data");
		
		else
			flag = true;
		
		return flag; 
	} */
	
	public static boolean validateAccountNo(long accountNo) throws AccountNotFoundException
	{
		boolean flag = false;
		if(accountNo <= 0) 
			throw new AccountNotFoundException("Invalild account No");
		
		else 
				flag = true;
		
		return flag;
	}
	
	public static boolean validateAccountHolderName(String accountHolderName) throws AccountNotFoundException{
		boolean flag = false;
		
		if(accountHolderName == null)
			throw new AccountNotFoundException("Account Holder Name cannot be empty ");
		else if (!accountHolderName.matches("^[a-zA-Z ]+$"))
			throw new AccountNotFoundException("Account Holder Name cannot contain Numbers or Special Characters");
		else 
			flag = true;
		
		return flag;
		
	}
	
	public static boolean validateAccountType(String accountType) throws AccountNotFoundException{
		boolean flag = false;
		
		if(accountType == null)
			throw new AccountNotFoundException("Account Type cannot be empty");
		else if(!accountType.matches("^[a-zA-Z ]+$")) 
			throw new AccountNotFoundException("Account Type cannot contain Numbers or Special Characters");
		else if(accountType.equals("Current") || accountType.equals("Savings") || accountType.equals("Salary"))
			flag = true;
			
		return flag;
		
	}
}