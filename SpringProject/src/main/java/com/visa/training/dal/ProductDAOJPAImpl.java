package com.visa.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visa.training.domain.Product;

@Repository
@Transactional
public class ProductDAOJPAImpl implements ProductDAO{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Product save(Product p) {
		em.persist(p);
		return p;
	}

	@Override
	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public List<Product> findAll() {
		return em.createQuery("select p from Product as p").getResultList();
	}

	@Override
	public void update(Product p) {
		em.merge(p);
		
	}

	@Override
	public void remove(int id) {
		Product p = findById(id);
		em.remove(p);
		
	}

}
