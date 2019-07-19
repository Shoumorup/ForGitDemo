package com.visa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

//This class will have business logic.
@Service
public class ProductServiceImpl implements ProductService{

	ProductDAO dao;
	@Override
	public int addNewProduct(Product p) {
		int id = 0;
		if(p.getPrice() * p.getQoh() >=10000)
		{
			Product created = dao.save(p);
			id = created.getId();
		}
		else throw new IllegalArgumentException("Minimum value of stock should be at least 10K");
		return id;
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public void deleteProduct(int id) {
		Product p =dao.findById(id);
		if(p.getPrice() * p.getQoh() >1000)
			throw new IllegalArgumentException("Can't remove when value >1000");
		else dao.remove(id);
		
	}

	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}
	
}
