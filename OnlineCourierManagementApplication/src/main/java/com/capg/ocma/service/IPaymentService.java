package com.capg.ocma.service;

import com.capg.ocma.exception.AccountNotFoundException;
import com.capg.ocma.exception.CourierNotFoundException;
import com.capg.ocma.model.CourierDTO;

public interface IPaymentService {

	public boolean processPaymentByCard(long accountNo) throws AccountNotFoundException;
	public CourierDTO processPaymentByCash(int courierId) throws CourierNotFoundException;
}