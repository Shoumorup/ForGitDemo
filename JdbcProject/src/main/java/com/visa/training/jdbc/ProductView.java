package com.visa.training.jdbc;

import java.util.List;

public class ProductView {

	public static void main(String[] args)throws Exception {
		ProductDAO pdao = new ProductDAO();
		List<Product> all=pdao.findAll();
		all.forEach(System.out::println);
		System.out.println(pdao.findById(2));
		
		pdao.removeByID(3);
		System.out.println("Removed element with ID 3:");
	}
}
