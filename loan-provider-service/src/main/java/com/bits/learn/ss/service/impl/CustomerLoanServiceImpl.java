package com.bits.learn.ss.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.bits.learn.ss.model.Customer;
import com.bits.learn.ss.model.CustomerLoan;
import com.bits.learn.ss.model.CustomerLoanDetails;
import com.bits.learn.ss.model.Loan;
import com.bits.learn.ss.service.CustomerLoanService;

@Service
public class CustomerLoanServiceImpl implements CustomerLoanService{

	@Override
	public CustomerLoanDetails getCustomerLoanDetails(long id) {
		Customer customer = new Customer();
		customer.setId(3);
		customer.setFirstName("Alex");
		customer.setLastName("Silverton");
		customer.setEmail("alex_silverton@gmail.com");
		
		Loan loan = new Loan();
		loan.setId(5);
		loan.setInterest(new BigDecimal(10.5));
		loan.setMaxDuration(24);
		loan.setMaxValue(10000);
		loan.setMinValue(500);
		loan.setType("Personal");
		
		CustomerLoan customerLoan = new CustomerLoan();
		customerLoan.setId(2);
		customerLoan.setCustomerId(3);
		customerLoan.setLoanId(5);
		customerLoan.setBalanceAmount(new BigDecimal(9500));
		customerLoan.setEndDate("22-04-25");
		customerLoan.setInterest(new BigDecimal(10.5));
		customerLoan.setLoanAmount(new BigDecimal(10000));
		customerLoan.setLoanDuration(22);
		customerLoan.setStartDate("22-04-22");
		
		CustomerLoanDetails customerLoanDtls = new CustomerLoanDetails();
		customerLoanDtls.setCustomer(customer);
		customerLoanDtls.setLoan(loan);
		customerLoanDtls.setCustomerLoan(customerLoan);
		
		return customerLoanDtls;
	}

	
}
