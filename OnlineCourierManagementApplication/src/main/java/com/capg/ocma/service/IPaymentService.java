package com.capg.ocma.service;



public interface IPaymentService {

	public boolean processPaymentByCash();
	public boolean processPaymentByCard(int customerid);
}
