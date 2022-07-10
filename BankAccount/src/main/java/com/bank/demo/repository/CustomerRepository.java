package com.bank.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.demo.entity.Customer;
import java.util.List;



public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	List<Customer> findByIdAndName(int id,String name);
	List<Customer> findByName(String name); 
	

}
