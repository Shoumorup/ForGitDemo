package com.visa.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.training.ui.ProductConsoleUI;

public class ProductApp {
	
	public static void main(String[] args) {
		//Bringing up the Spring Container
		Class[] configs = {ProductAppConfiguration.class,PersistenceJPAConfiguration.class};
        ApplicationContext springContainer 
        = new AnnotationConfigApplicationContext(configs);
		//ApplicationContext springContainer = new AnnotationConfigApplicationContext(ProductAppConfiguration.class);
		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
		ui.createProductWithUI();
	}

}
