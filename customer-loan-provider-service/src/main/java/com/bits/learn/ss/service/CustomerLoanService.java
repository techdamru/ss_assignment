package com.bits.learn.ss.service;

import com.bits.learn.ss.model.CustomerLoan;

public interface CustomerLoanService {

	public CustomerLoan create(CustomerLoan customerLoan);
	public CustomerLoan getCustomerLoanDetails(long id);
}
