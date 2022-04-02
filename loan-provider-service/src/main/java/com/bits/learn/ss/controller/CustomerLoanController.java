package com.bits.learn.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bits.learn.ss.model.CustomerLoanDetails;
import com.bits.learn.ss.service.CustomerLoanService;

@RestController
@RequestMapping("/customer/loan")
public class CustomerLoanController {

	@Autowired
	private CustomerLoanService customerLoanService;
	
	@GetMapping("{id}")
	public ResponseEntity<CustomerLoanDetails> get(@PathVariable("id") long id){
		return new ResponseEntity<CustomerLoanDetails>(customerLoanService.getCustomerLoanDetails(id), HttpStatus.OK);
	}
}
