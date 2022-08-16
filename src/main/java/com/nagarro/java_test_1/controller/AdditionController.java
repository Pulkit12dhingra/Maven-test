package com.nagarro.java_test_1.controller;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.java_test_1.service.AdditionService;

@Controller
public class AdditionController {
	
	@Autowired
	AdditionService service;
	
	@RequestMapping(value = "/add")
	public ModelAndView addition(HttpServletRequest request,HttpServletResponse response) {
		int a=Integer.parseInt(request.getParameter("num1"));
		int b=Integer.parseInt(request.getParameter("num2"));
		String s=request.getParameter("operation");
		s.toLowerCase();
		//System.out.println(s.getClass().getSimpleName());
		int c;
		if(s.equals("add")) {
			c=service.getAdditionResult(a,b);
		}
		else if(s.equals("subtract")) {
			c=service.getSubstractionResult(a,b);
		}
		else if(s.equals("divide")) {
			c=service.getDivisionResult(a,b);
		}
		else if(s.equals("multiply")) {
			c=service.getMultiplicationResult(a,b);
		}
		else {
			ModelAndView mv= new ModelAndView();
			mv.addObject("result","Wrong operator");
			mv.setViewName("resultPage");
			return mv;
		}
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("result",c);
		mv.setViewName("resultPage");
		return mv;
    }
}