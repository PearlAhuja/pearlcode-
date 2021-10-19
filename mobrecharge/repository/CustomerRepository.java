package com.dumbledore.mobrecharge.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dumbledore.mobrecharge.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {

	
	public Customer findByMobileNumber(Long mobileNumber);
	public Customer deleteByMobileNumber(Long mobileNumber);
	
}
