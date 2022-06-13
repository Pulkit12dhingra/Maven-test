package com.nagarro.assignment1.service;

import org.springframework.stereotype.Service;

@Service
public class AdditionService {
	
	public int getAdditionResult(int a,int b) {
		return a+b;
	}
}
