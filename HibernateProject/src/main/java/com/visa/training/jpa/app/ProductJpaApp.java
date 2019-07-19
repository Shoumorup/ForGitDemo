package com.visa.training.jpa.app;

import java.util.List;

import com.visa.training.jpa.dal.JpaProductDAO;
import com.visa.training.jpa.domain.Product;

public class ProductJpaApp {
	public static void main(String[] args) {
		JpaProductDAO dao = new JpaProductDAO();
		/*
		 * Product test = new Product("box",87,120); Product saved = dao.save(test);
		 * System.out.println("Persisted into DB: "+saved);
		 * 
		 * Product fromDB = dao.findById(saved.getId());
		 * System.out.println("Found from DB: "+fromDB);
		 * 
		 * System.out.println(saved == fromDB); // The above returns false as they are
		 * different copies of the same object
		 * 
		 * //System.out.println(dao.removeById(7));
		 * fromDB.setPrice(fromDB.getPrice()+20);// Here fromDB is a DETACHED object
		 * dao.updateById(fromDB); System.out.println("Updated: "+
		 * dao.findById(fromDB.getId()));
		 */
		
		List<Product> all=dao.findAll();
		all.forEach(System.out::println);
		
		List<Product> allGreaterThan=dao.findByPriceGreaterThan(12.0f);
		allGreaterThan.forEach(System.out::println);
		System.exit(0);
	}
}
