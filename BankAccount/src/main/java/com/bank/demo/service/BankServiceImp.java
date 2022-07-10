package com.bank.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.demo.entity.Account;
import com.bank.demo.entity.Customer;
import com.bank.demo.repository.AccountRepository;
import com.bank.demo.repository.CustomerRepository;

@Service
public class BankServiceImp implements BankService {
	
	@Autowired
  private CustomerRepository crep;
	@Autowired
	private AccountRepository arep;
  
	public List<Customer> getdetails() {
		
		return crep.findAll();
	}


	public Customer addCustomer(Customer customer) {
		crep.save(customer);
		return customer;
	}

	public Customer updateCustomer(Customer customer) {
		
		crep.save(customer);
		return customer;
	}

	public Customer getCustomer(int cust_id) {
		
		
		Customer cust= crep.getById(cust_id);
	
		
		
		return cust;
	}


	
	public void deleteCustomer(int cust_id) {
		
		crep.deleteById(cust_id);
	}




	public boolean Transfer(int c_id, int ac_number, int c_id2, int ac_number2,int balance) {
		// TODO Auto-generated method stub
		Customer c_one=crep.getById(c_id);
		Customer c_two=crep.getById(c_id2);
		
		
		List<Account>li=c_one.getAccount();
		List<Account>li2=c_two.getAccount();
		int temp=0;
		
		for(int i=0;i<li.size();i++)
		{
			Account a=li.get(i);
			if(a.getAccount_number()==ac_number)
			{
				temp=temp+1;
			}
		}
		for(int i=0;i<li2.size();i++)
		{
			Account a2=li2.get(i);
			if(a2.getAccount_number()==ac_number2)
			{
				temp=temp+1;
			}
		}
		
		if(temp<2)
		{
			return false;
		}
		
		
		
		int count=0;
	
		List<Account> list=c_one.getAccount();
		for(int i=0;i<list.size();i++)
		{
			
			Account ac= list.get(i);
			if(ac.getAccount_number()==ac_number && ac.getBalance()>=balance)
			{
				count=1;
				
				ac.setBalance(ac.getBalance()-balance);
				list.remove(i);
				list.add(ac);
				
				Customer c=new Customer(c_one.getId(),c_one.getName(),c_one.getAddress(),list);
				crep.save(c);
				
			
				
				break;
				
			}
			else if(ac.getAccount_number()==ac_number && ac.getBalance()<=balance)
			{
				return false;
			}
			
		}
		if(count==0 )
		{
			return false;
		}
		
		
		List<Account> list2=c_two.getAccount();
		
		for(int i=0;i<list2.size();i++)
		{
			
			Account ac2= list2.get(i);
			if(ac2.getAccount_number()==ac_number2 )
			{
				
				ac2.setBalance(balance+ac2.getBalance());
				list2.remove(i);
				list2.add(ac2);
				
				Customer c2=new Customer(c_two.getId(),c_two.getName(),c_two.getAddress(),list2);
				crep.save(c2);
				break;
			}
		
			
		}
		
		
		
		return true;
		
		
	}


	public List<Customer> findbyIdandName(int id, String name) {
		
		return crep.findByIdAndName(id, name);
		
		
	}


	
	public List<Customer> findbyName(String name) {
	   
		return crep.findByName(name);
	}


	
	

	

}
