package com.bank.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.demo.entity.Account;
import com.bank.demo.entity.Customer;
import com.bank.demo.repository.CustomerRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class BankServiceTest {
	
	@Autowired
	private BankService bservice;
	
	@MockBean
	 private CustomerRepository repo;
	

	@Test
	public void getAllCustomertest() {
		
		List<Customer> list=new ArrayList<Customer>();
		
		List<Account> Acclist=new ArrayList<Account>();
		Account one=new Account(12,"saving",12345);
		Account two=new Account(13,"current",3425234);
		Acclist.add(one);
		Acclist.add(two);
		
		Customer cust=new Customer(1,"amrit","punjab",Acclist);
		
		list.add(cust);
		 
		when(repo.findAll()).thenReturn(list);
		
		
		List<Customer> custlist=bservice.getdetails();
		
		assertEquals(1,custlist.size());
		
		
	
	}
	
	@Test
	public void createCustomerTest()
	{
		List<Account> Acclist=new ArrayList<Account>();
		Account one=new Account(12,"saving",12345);
		Account two=new Account(13,"current",3425234);
		Acclist.add(one);
		Acclist.add(two);
		
		Customer cust=new Customer(1,"amrit","punjab",Acclist);
		
		bservice.addCustomer(cust);
		
		verify(repo,times(1)).save(cust);
	
		
		
	}
	
	@Test
	public void updateCustomerTest()
	{
		List<Account> Acclist=new ArrayList<Account>();
		Account one=new Account(12,"saving",12345);
		Account two=new Account(13,"current",3425234);
		Acclist.add(one);
		Acclist.add(two);
		
		Customer cust=new Customer(1,"aman","punjab",Acclist);
		
		bservice.updateCustomer(cust);
		
		verify(repo,times(1)).save(cust);
		
		
	}
	
	@Test
	public void getCustomerByIdTest()
	{
		List<Account> Acclist=new ArrayList<Account>();
		Account one=new Account(12,"saving",12345);
		Account two=new Account(13,"current",3425234);
		Acclist.add(one);
		Acclist.add(two);
		
		Customer cu=new Customer(1,"amrit","punjab",Acclist);
		bservice.addCustomer(cu);
		
     	when(repo.getById(1)).thenReturn(cu);
		
		
		
		Customer cust=bservice.getCustomer(1);
		assertEquals(1,cust.getId());
		assertEquals("amrit",cust.getName());
		assertEquals("punjab",cust.getAddress());
		assertEquals(Acclist,cust.getAccount());
		
	}
	
	@Test
	public void deleteCustomertest()
	{
		
		
		bservice.deleteCustomer(1);
		
		verify(repo,times(1)).deleteById(1);
		
	}
	
	@Test
	public void findbyIDandName() {
	List<Account> Acclist=new ArrayList<Account>();
	Account one=new Account(12,"saving",12345);
	Account two=new Account(13,"current",3425234);
	Acclist.add(one);
	Acclist.add(two);
	
	Customer cu=new Customer(2,"amrit","punjab",Acclist);
		List<Customer> list=new ArrayList<Customer>();
		list.add(cu);
	when(repo.findByIdAndName(2, "amrit")).thenReturn(list);
	
		List<Customer> ls=bservice.findbyIdandName(2,"amrit");
		assertEquals(1,ls.size());
		verify(repo,times(1)).findByIdAndName(2, "amrit");
	}
	
	@Test
	public void findbyName() {
	List<Account> Acclist=new ArrayList<Account>();
	Account one=new Account(12,"saving",12345);
	Account two=new Account(13,"current",3425234);
	Acclist.add(one);
	Acclist.add(two);
	
	Customer cu=new Customer(2,"amrit","punjab",Acclist);
		List<Customer> list=new ArrayList<Customer>();
		list.add(cu);
	when(repo.findByName( "amrit")).thenReturn(list);
	
		List<Customer> ls=bservice.findbyName("amrit");
		assertEquals(1,ls.size());
		verify(repo,times(1)).findByName("amrit");
	}


}
