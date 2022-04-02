package com.bits.learn.ss.model;

public class CustomerLoanDetails {

	public Customer customer;
	public CustomerLoan customerLoan;
	public Loan loan;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerLoan getCustomerLoan() {
		return customerLoan;
	}
	public void setCustomerLoan(CustomerLoan customerLoan) {
		this.customerLoan = customerLoan;
	}
	public Loan getLoan() {
		return loan;
	}
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
	
}
