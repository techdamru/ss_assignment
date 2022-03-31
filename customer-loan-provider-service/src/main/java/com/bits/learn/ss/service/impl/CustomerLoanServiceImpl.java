package com.bits.learn.ss.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bits.learn.ss.exception.CustomerLoanNotFoundException;
import com.bits.learn.ss.model.CustomerLoan;
import com.bits.learn.ss.repository.CustomerLoanRepository;
import com.bits.learn.ss.service.CustomerLoanService;

@Service
public class CustomerLoanServiceImpl implements CustomerLoanService {

	private CustomerLoanRepository customerLoanRepository;

	public CustomerLoanServiceImpl(CustomerLoanRepository customerLoanRepository) {
		super();
		this.customerLoanRepository = customerLoanRepository;
	}

	@Override
	public CustomerLoan create(CustomerLoan customerLoan) {
		return 	customerLoanRepository.save(customerLoan);
	}

	@Override
	public CustomerLoan getCustomerLoanDetails(long id) {
		Optional<CustomerLoan> customerLoan = customerLoanRepository.findById(id);
		if(customerLoan.isPresent()) {
			return customerLoan.get();
		}else {
			throw new CustomerLoanNotFoundException("CustomerLoan","Id",id);
		}
	}

}
