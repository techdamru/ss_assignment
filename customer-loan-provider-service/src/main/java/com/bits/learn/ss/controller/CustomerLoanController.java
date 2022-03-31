package com.bits.learn.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bits.learn.ss.model.Customer;
import com.bits.learn.ss.model.CustomerLoan;
import com.bits.learn.ss.model.CustomerLoanDetails;
import com.bits.learn.ss.model.Loan;
import com.bits.learn.ss.service.CustomerLoanService;

@RestController
@RequestMapping("/customer/loan")
public class CustomerLoanController {

	@Autowired
	private CustomerLoanService customerLoanService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("{id}")
	public ResponseEntity<CustomerLoanDetails> get(@PathVariable("id") long id){
		
		CustomerLoanDetails customerLoanDetails = new CustomerLoanDetails();
		customerLoanDetails.setCustomerLoan(customerLoanService.getCustomerLoanDetails(id));
		customerLoanDetails.setCustomer(getCustomer(customerLoanDetails.getCustomerLoan().getCustomerId()));
		customerLoanDetails.setLoan(getLoan(customerLoanDetails.getCustomerLoan().getLoanId()));  
		
		return new ResponseEntity<CustomerLoanDetails>(customerLoanDetails, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<CustomerLoan> create(@RequestBody CustomerLoan customerLoan){
		return new ResponseEntity<CustomerLoan>(customerLoanService.create(customerLoan), HttpStatus.CREATED);
	}
	
	private Customer getCustomer(long customerId) {
		Customer[] customers=restTemplate.getForObject("http://customer-service-v1/customer", Customer[].class); 
		for(Customer customer:customers) {
			if(customer.getId()==customerId) {
				return customer;
			}
		}
		throw new RuntimeException("Customer Details Not Found !!!");
	}
	
	private Loan getLoan(long loanId) {
		Loan[] loans=restTemplate.getForObject("http://loan-service-v1/loan", Loan[].class); 
		for(Loan loan:loans) {
			if(loan.getId()==loanId) {
				return loan;
			}
		}
		throw new RuntimeException("Loan Details Not Found !!!");
	}
}
