package com.visa.training.jdbc;

public class ProductCreate {
	
	public static void main(String[] args)throws Exception {
		ProductDAO pdao = new ProductDAO();
		Product p = new Product("AAA",12.5f,3);
		System.out.println("Created with ID:"+pdao.save(p));
		Product p2 = new Product("BBB",45.0f,12);
		System.out.println("Created with ID:"+pdao.save(p2));
		Product p3 = new Product("CCC",23.3f,8);
		System.out.println("Created with ID:"+pdao.save(p3));
	}
}
