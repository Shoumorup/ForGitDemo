package com.visa.training.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visa.training.domain.Product;
import com.visa.training.service.ProductService;

@Controller
public class ProdController {
    
    @Autowired
    ProductService service;
    
    @Autowired
    ProductValidator validator;
    
    @RequestMapping(value="/products",method=RequestMethod.GET)
    public ModelAndView listProducts() {
        Product product = new Product();
        return new ModelAndView("productslist", "product", product);
    }
    
    @RequestMapping(value="/products",method=RequestMethod.POST)
    public String addProduct(@ModelAttribute("product")Product p,Errors validationErrors) {
       
        validator.validate(p, validationErrors);
        if(!validationErrors.hasErrors()) {
            service.addNewProduct(p);
        }
        
        return "productslist";
    }
    
	/*
	 * @RequestMapping("/removeProduct") public String
	 * removeProduct(@RequestParam("id")int id) { try { service.deleteProduct(id);
	 * }catch (IllegalArgumentException e) { return "removeFailed"; } return
	 * "productslist"; }
	 */
    
    @ModelAttribute("productList")
    public List<Product> getProductList(){
        return service.findAll();
    }

}
