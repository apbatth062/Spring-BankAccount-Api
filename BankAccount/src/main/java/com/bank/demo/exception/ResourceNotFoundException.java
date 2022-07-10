package com.bank.demo.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends Exception {
	
	public ResourceNotFoundException()
	{
		
	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}

}
