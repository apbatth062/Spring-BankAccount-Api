package com.bank.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
@ExceptionHandler(ResourceNotFoundException.class)
@ResponseStatus(value=HttpStatus.NOT_FOUND)
@ResponseBody ExceptionResponse handelResourceNotFoundException(ResourceNotFoundException exception,HttpServletRequest req)
{
	ExceptionResponse response=new ExceptionResponse();
	response.setMessage(exception.getMessage());
	response.setPath(req.getRequestURI());
	
	return response;
}

@ExceptionHandler(Exception.class)
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
@ResponseBody ExceptionResponse handleException(Exception exception,HttpServletRequest req)
{
	ExceptionResponse response=new ExceptionResponse();
	response.setMessage(exception.getMessage());
	response.setPath(req.getRequestURI());

	
	return response;
}
}
