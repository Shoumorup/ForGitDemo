package com.visa.training.bootproject.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.visa.training.bootproject.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{
	
	public Product findById(int id);
	public List<Product> findAll();
}
