package com.visa.training.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visa.training.domain.Product;
import com.visa.training.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping("/listProducts")
	public String listProducts()
	{
			return "products";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(@RequestParam("name")String name,@RequestParam("price")float price,@RequestParam("qoh")int qoh)
	{
		Product p = new Product(name,price,qoh);
		service.addNewProduct(p);
		
		return "products";		
	}
	
	@RequestMapping("/removeProduct")
	public String removeProduct(@RequestParam("id")int id)
	{
		try
		{
			service.deleteProduct(id);
		}
		catch(IllegalArgumentException e)
		{
			return "removeFailed";
		}
		
		
		return "products";
	}
	
	@ModelAttribute("productList")
	public List<Product> getProductList()
	{
		return service.findAll();
	}
}
