package com.visa.training.jpa.dal;

import java.util.List;

import javax.persistence.*;

import com.visa.training.jpa.domain.Product;

public class JpaProductDAO {
	
	public Product save(Product p)
	{
		EntityManagerFactory emf = JpaUtil.getEmf();
		EntityManager em = emf.createEntityManager();
		try
		{
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(p);
			tx.commit();
			em.persist(p);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return p;
	}
	
	public Product findById(int id)
	{
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			Product p = em.find(Product.class, id);
			return p;
		} finally {
			em.close();
		}
	}
	
	public List<Product> findAll()
	{
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Query q = em.createQuery("select p from Product as p"); 
		List<Product > all = q.getResultList();
		em.close();
		return all;
	}
	
	public List<Product> findByPriceGreaterThan(float price)
	{
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Query q = em.createQuery("select p from Product as p where p.price > ?");
		q.setParameter(1, price);
		List<Product > all = q.getResultList();
		em.close();
		return all;
	}
	
	public Product removeById(int id)
	{
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Product toBeRemoved = em.find(Product.class,id);
			if(toBeRemoved != null) em.remove(toBeRemoved);
			tx.commit();
			return toBeRemoved;
		} finally {
			em.close();
		}
	}
	
	public Product updateById(Product toBeUpdated)
	{
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Product updated = em.merge(toBeUpdated);			
			tx.commit();
			return updated;
		} finally {
			em.close();
		}
		
	}
}
