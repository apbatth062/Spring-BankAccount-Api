package com.bank.demo.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleTestBusinessLogicTest {

	@Test
	void test()
	{
		SimpleTestBusinessLogic test=new SimpleTestBusinessLogic();
		int result= test.add(200, 100);
		int expect=300;
		assertEquals(expect,result);
	}
}
