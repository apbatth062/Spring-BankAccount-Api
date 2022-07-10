package com.bank.demo.Controller;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.bank.demo.controller.BankController;

import com.bank.demo.service.BankService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(BankController.class)
class BankControllerTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private BankService bservice;
	
	
	 protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	
	
	@Test
	public void Helloworld()  throws Exception
	{
		RequestBuilder request=MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcresult=mockmvc.perform(request).andReturn(); 
		assertEquals("Welcome to TestController",mvcresult.getResponse().getContentAsString());
	}
	
	@Test
	public void addCustomer() throws Exception
	{

        
		RequestBuilder request=MockMvcRequestBuilders.post("/hello").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcresult=mockmvc.perform(request).andReturn(); 
		assertEquals("Updating in database",mvcresult.getResponse().getContentAsString());
        
	}

}
