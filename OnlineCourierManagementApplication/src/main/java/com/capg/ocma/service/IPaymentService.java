package com.capg.ocma.service;

import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;

public interface IPaymentService {

	public boolean processPaymentByCard(long accountNo) throws AccountNotFoundException;
	
	public boolean processPaymentByCash(int courierId) throws CourierNotFoundException;
}
