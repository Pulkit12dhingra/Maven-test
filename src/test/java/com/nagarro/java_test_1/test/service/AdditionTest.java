package com.nagarro.java_test_1.test.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.nagarro.java_test_1.service.AdditionService;

public class AdditionTest {
	
	@Test
	public void testAdditionOfNumbers() {
		AdditionService service=new AdditionService();
		int a=10;
		int b=20;
		String s="add";
		int c=service.getAdditionResult(a, b);
		assertEquals(30,c);
	}
	
	@Test
	public void testsubstractionOfNumbers() {
		AdditionService service=new AdditionService();
		int a=40;
		int b=20;
		String s="substract";
		int c=service.getSubstractionResult(a, b);
		assertEquals(20,c);
	}
	
	@Test
	public void testmultiplicationOfNumbers() {
		AdditionService service=new AdditionService();
		int a=40;
		int b=20;
		String s="multiply";
		int c=service.getMultiplicationResult(a, b);
		assertEquals(800,c);
	}
	
}
