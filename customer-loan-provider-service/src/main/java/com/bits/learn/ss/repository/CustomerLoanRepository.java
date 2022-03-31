package com.bits.learn.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bits.learn.ss.model.CustomerLoan;

public interface CustomerLoanRepository extends JpaRepository<CustomerLoan, Long>{

}
