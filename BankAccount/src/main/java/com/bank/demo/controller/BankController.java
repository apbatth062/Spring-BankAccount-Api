package com.bank.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.entity.Customer;
import com.bank.demo.entity.Transection;
import com.bank.demo.exception.ResourceNotFoundException;
import com.bank.demo.service.BankService;

@RestController
public class BankController {
	
	@Autowired
	private BankService bankservice;
	
	
	
	//for Testing purpose
	@GetMapping("/hello")
	public String Hello()
	{
		return "Welcome to TestController";
	}
	
	@PostMapping("/hello")
	public String postHello()
	{
		return "Updating in database";
	}
	
	 
	@GetMapping("/customer")
	public ResponseEntity< List<Customer>> getdetails() throws ResourceNotFoundException
	{
		List<Customer> list =bankservice.getdetails();
		   if(list.size()==0)
		   {
			   throw new ResourceNotFoundException("There is no record in Bank");
		   }
		   else
		   {
			   return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
		   }
		
		
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		
		Customer cm=bankservice.addCustomer(customer);
		return new ResponseEntity<Customer>(cm,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		
		Customer cm=bankservice.updateCustomer(customer);
		return new ResponseEntity<Customer>(cm,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String id)  throws ResourceNotFoundException{
		
		
		int cust_id=Integer.parseInt(id);
		
		//List<Customer> list =bankservice.getdetails();
	//	int c=0;
//		  if(list.size()==0)
//		   {
//			   throw new ResourceNotFoundException("There is no record in Bank");
//		   }
//		  else  {
//			  for(int i=0;i<list.size();i++)
//			  {
//				 Customer cust= list.get(i);
//				 if(cust.getId()==cust_id)
//				 {
//					 c=1;
//					 break;
//				 }
//			  }
//			  if(c==1)
//			  {
//				   Customer cm=bankservice.getCustomer(cust_id);
//					return new ResponseEntity<Customer>(cm,HttpStatus.FOUND);
//			  }
//			  else
//			  {
//				  throw new ResourceNotFoundException("The id don't exist in the  bank records");
//			  }
			  
	//	  }
		  Customer cm=bankservice.getCustomer(cust_id);
		  
		  if(cm==null)
		  {
			  throw new ResourceNotFoundException("The id don't exist in the  bank records");
		  }
		  else
		  {
			  return new ResponseEntity<Customer>(cm,HttpStatus.FOUND);
		  }
		
		
	}
	
	@DeleteMapping("/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) throws ResourceNotFoundException{
		 
		List<Customer> list =bankservice.getdetails();
	int cust_id=Integer.parseInt(id); 
		int c=0;
		  if(list.size()==0)
		   {
			   throw new ResourceNotFoundException("There is no record in Bank");
		   }
		  
		  else {
			  bankservice.deleteCustomer(cust_id);
				return new ResponseEntity<Void>(HttpStatus.OK);
		  
	}
//		  else  {
//			  for(int i=0;i<list.size();i++)
//			  {
//				 Customer cust= list.get(i);
//				 if(cust.getId()==cust_id)
//				 {
//					 c=1;
//					 break;
//				 }
//			  }
//			  if(c==1)
//			  {
//					bankservice.deleteCustomer(cust_id);
//					return new ResponseEntity<Void>(HttpStatus.OK);
//			  }
//			  else
//			  {
//				  throw new ResourceNotFoundException("The id don't exist in the  bank records");
//			  }
//			  
	//	  }
		  	
	}
	
	 @PutMapping("/transection") 
	  public ResponseEntity<Void> transfer(@RequestBody Transection trans) throws ResourceNotFoundException
	  {
		 int c_id= (int)trans.getSender_id();
		 int ac_number= (int)trans.getSender_accNumber();
		 int c_id2= trans.getReciever_id();
		 int ac_number2=trans.getReciever_accNumber();
		 int balance=trans.getBalance();
		 
		
		 Customer c1=bankservice.getCustomer(c_id);
		 Customer c2=bankservice.getCustomer(c_id2);
		 boolean b=   bankservice.Transfer(c_id,ac_number,c_id2,ac_number2,balance);
			if(b==true)
			{
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			else
			{
				throw new ResourceNotFoundException("Balance in Account is Less or AccountNumber does not exist");
			}
		 
		 
		 
		 
//		 List<Customer> list =bankservice.getdetails();
//			int c=0;
//			  if(list.size()==0)
//			   {
//				   throw new ResourceNotFoundException("There is no record in Bank");
//			   }
//			  else  {
//				  for(int i=0;i<list.size();i++)
//				  {
//					 Customer cust= list.get(i);
//					 if(cust.getId()==c_id ||cust.getId()==c_id2 )
//					 {
//						 c=c+1;
//						 if(c_id==c_id2 ||c==2)
//						 { 
//							 c=2;
//						 break;
//						 }
//					 }
//				  }
//				  if(c==2)
//				  {
//					
//					boolean b=   bankservice.Transfer(c_id,ac_number,c_id2,ac_number2,balance);
//					if(b==true)
//					{
//						return new ResponseEntity<Void>(HttpStatus.OK);
//					}
//					else
//					{
//						throw new ResourceNotFoundException("Balance in Account is Less or AccountNumber does not exist");
//					}
//				  }
//				  else
//				  {
//					  throw new ResourceNotFoundException("The id don't exist in the  bank records");
//				  }
//				  
//			  }
//			
//
//		 
		  }
	 
	 
	 @GetMapping("/customer/{id}/{name}")
	 public ResponseEntity<List<Customer>> getCustomerByIdandName(@PathVariable String id,@PathVariable String name) throws ResourceNotFoundException{
		 
		 int ID=Integer.parseInt(id);
		List<Customer> list=  bankservice.findbyIdandName(ID,name);
		if(list.size()==0)
		{
			throw new ResourceNotFoundException("There is no data matching with id and name");
		}
		
		return  new ResponseEntity<List<Customer>>(list,HttpStatus.FOUND);
	 }
	 
	 

	 @GetMapping("/customer/name/{name}")
	 public ResponseEntity<List<Customer>> getCustomerName(@PathVariable String name) throws ResourceNotFoundException{
		
		List<Customer> list=  bankservice.findbyName(name);
		if(list.size()==0)
		{
			throw new ResourceNotFoundException("There is no data matching  name");
		}
		
		return  new ResponseEntity<List<Customer>>(list,HttpStatus.FOUND);
	 }
	 
	
	
	

}
