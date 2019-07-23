package com.visa.training.bootproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visa.training.bootproject.domain.Product;
import com.visa.training.bootproject.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping(value="/api/products",method=RequestMethod.GET)
	public List<Product> getAll(){
		return service.findAll();
	}
	
	@RequestMapping(value="/api/products/{id}",method=RequestMethod.GET)
	public ResponseEntity<Product> getById(@PathVariable("id")int id)
	{
		Product p = service.findById(id);
		
		if(p != null)
		{
			return new ResponseEntity<Product>(p, HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
