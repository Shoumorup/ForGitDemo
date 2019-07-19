package com.visa.training;

import org.springframework.context.annotation.*;

import com.visa.training.dal.ProductDAO;
import com.visa.training.dal.ProductDAOInMemoryImpl;
import com.visa.training.service.ProductService;
import com.visa.training.service.ProductServiceImpl;
import com.visa.training.ui.ProductConsoleUI;

@Configuration
@ComponentScan(basePackages = "com.visa.training")
public class ProductAppConfiguration {
//Should tell Spring which are the Beans and wiring the Beans together(How to do injection)
	
	/*
	 * @Bean public ProductDAO dao() { return new ProductDAOInMemoryImpl(); }
	 * 
	 * @Bean public ProductService service() { ProductServiceImpl service = new
	 * ProductServiceImpl(); service.setDao(dao()); //DI as service layer in turn
	 * has dependency on DAL return service; }
	 * 
	 * @Bean public ProductConsoleUI ui() { ProductConsoleUI ui = new
	 * ProductConsoleUI(); ui.setService(service()); return ui; }
	 */
	
	
	
}
