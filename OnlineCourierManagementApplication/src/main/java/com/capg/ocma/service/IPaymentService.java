package com.capg.ocma.service;

import com.capg.ocma.exception.AccountNotFoundException;

public interface IPaymentService {

	public boolean processPaymentByCard(long accountNo) throws AccountNotFoundException;
	
	public boolean processPaymentByCash();
}
