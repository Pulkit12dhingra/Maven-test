package com.nagarro.java_test_1.service;

import org.springframework.stereotype.Service;

@Service
public class AdditionService {
	
	public int getAdditionResult(int a,int b) {
		return a+b;
	}
	
	public int getSubstractionResult(int a,int b) {
		return a-b;
	}
	
	public int getMultiplicationResult(int a,int b) {
		return a*b;
	}
	
	public int getDivisionResult(int a,int b) {
		return a/b;
	}
}

