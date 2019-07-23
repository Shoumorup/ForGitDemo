package com.visa.training.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

	@RequestMapping("/calculator")
	public ModelAndView calculate(@RequestParam("n1")String number1, @RequestParam("n2")String number2, @RequestParam("op")String op)
	{
		double n1=Double.parseDouble(number1);
		double n2=Double.parseDouble(number2);
		
		double result=0;
		switch(op)
		{
			case "+": result=n1+n2; break;
			case "-": result=n1-n2; break;
			case "*": result=n1*n2; break;
			case "/": result=n1/n2; break;
		}
		
		String viewName = "calculatorview";//Logical View name - DO NOT hardcode.
		Map<String,Object> attributes = new HashMap<String,Object>();
		//attributes.put("n1",n1);
		attributes.put("result",result);
		return new ModelAndView(viewName,attributes);
	}
}
