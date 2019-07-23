package com.visa.training.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {

	@RequestMapping("/addbooks")
	public ModelAndView addBooks(HttpSession session,@RequestParam("Book")String[] selectedBooks)
	{
		session.setAttribute("selectedBooks", selectedBooks);
		
		String viewName = "cars";//Logical View name - DO NOT hardcode.
		Map<String,Object> attributes = new HashMap<String,Object>();
		attributes.put("selectedBooks",selectedBooks);
		return new ModelAndView(viewName,attributes);
	}
	
	@RequestMapping("/addcars")
	public ModelAndView addCars(HttpSession session,@RequestParam("Car")String[] selectedCars)
	{
		session.setAttribute("selectedCars", selectedCars);
		
		String viewName = "bikes";//Logical View name - DO NOT hardcode.
		Map<String,Object> attributes = new HashMap<String,Object>();
		attributes.put("selectedCars",selectedCars);
		return new ModelAndView(viewName,attributes);
	}
	
	@RequestMapping("/addbikes")
	public ModelAndView addBikes(HttpSession session,@RequestParam("Bike")String[] selectedBikes)
	{
		session.setAttribute("selectedBikes", selectedBikes);
		
		String viewName = "cart";//Logical View name - DO NOT hardcode.
		Map<String,Object> attributes = new HashMap<String,Object>();
		attributes.put("selectBikes",selectedBikes);
		return new ModelAndView(viewName,attributes);
	}
	
	
	
}
