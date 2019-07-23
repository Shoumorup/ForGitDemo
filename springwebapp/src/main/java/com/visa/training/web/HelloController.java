package com.visa.training.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//DispatcherServlet
@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView helloWorld(@RequestParam("name")String name)
	{
		String result = "Hello "+name;
		String viewName = "helloview";//Logical View name - DO NOT hardcode.
		Map<String,Object> attributes = new HashMap<String,Object>();
		attributes.put("result",result);
		return new ModelAndView(viewName,attributes);
		
	}

}
