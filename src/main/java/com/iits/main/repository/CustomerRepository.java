package com.iits.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iits.main.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	
}
