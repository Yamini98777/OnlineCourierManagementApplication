package com.capg.ocma.service;

import com.capg.ocma.exception.CustomerNotFoundException;

public interface IPaymentService {

	public boolean processPaymentByCash();
	public boolean processPaymentByCard(int customerId) throws CustomerNotFoundException;
}
