package com.bank.demo.service;

import java.util.List;

import com.bank.demo.entity.Customer;

public interface BankService {

	public List<Customer> getdetails();

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer getCustomer(int cust_id);

	public void deleteCustomer(int cust_id);

	public boolean Transfer(int c_id, int ac_number, int c_id2, int ac_number2,int balance);

	public List<Customer> findbyIdandName(int id, String name);

	public List<Customer> findbyName(String name);

	

}
