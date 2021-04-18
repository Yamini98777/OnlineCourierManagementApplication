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
	 * Description  : This method uses payment by Cash
	 * Input Param  : int courierId
	 * Return Value : CourierDTO Object
	 * Exception    : CourierNotFoundException
	 */
	
	@Override
	public CourierDTO processPaymentByCash(int courierId) throws CourierNotFoundException {
		
		logger.info(" process Payment by Cash is initialized");
		
		Courier courier = courierRepo.findById(courierId).orElse(null);
		
		if(courierId <= 0)
			
			throw new CourierNotFoundException("No courier found with given courier ID");
		
		logger.info(" Process Payment by cash has been executed");
		
		return CourierUtil.convertToCourierDto(courier);		
	}
	
	/*
	 * Description  : This method uses payment by Card
	 * Input Param  : long accountNo
	 * Return Value : Boolean
	 * Exception    : AccountNotFoundException
	 */
	@Override
	public boolean processPaymentByCard(long accountNo) throws AccountNotFoundException{
		
		logger.info(" Process Payment by card is initiated");
		
		BankAccount bankAccount = bankAccountRepo.findById(accountNo).orElse(null);
		
		boolean flag = false;
		
		String str = Long.toString(accountNo);
		long size = str.length();
		if(accountNo <= 0 )  
			throw new AccountNotFoundException("Account Number cannot be 0 or Negative");
		
		else if(size < 2 || size > 9 )
			throw new AccountNotFoundException("Account Number size cannot be below 2 or above 9");
		
		else
			flag = true;
		
		logger.info(" Process Payment by card has been executed");
		
		return flag;
	}

}