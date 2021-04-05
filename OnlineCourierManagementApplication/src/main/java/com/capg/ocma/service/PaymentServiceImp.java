package com.capg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ocma.repository.ICustomerDao;


@Service
public class PaymentServiceImp implements IPaymentService{

	@Autowired
	ICustomerDao customerDao;
	
	public PaymentServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentServiceImp(ICustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}
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
				
			}else {
				flag = false;
				
				
			}
			
		}
		return flag;
		
	}
	
}
	
