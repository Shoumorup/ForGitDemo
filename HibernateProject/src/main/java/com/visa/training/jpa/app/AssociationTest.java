package com.visa.training.jpa.app;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.jpa.dal.JpaUtil;
import com.visa.training.jpa.domain.Account;
import com.visa.training.jpa.domain.Address;
import com.visa.training.jpa.domain.Customer;
import com.visa.training.jpa.domain.SavingsAccount;

public class AssociationTest {
	
	public static void createAccountAndCustomerSeparately()
	{
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer c = new Customer("fn","mnn","ldd",new Date(System.currentTimeMillis()));
		SavingsAccount sa = new SavingsAccount(1234);
		sa.setCustomer(c);
		em.persist(c);
		em.persist(sa);
		tx.commit();
		em.close();
	}
	
	private static void testManyToMnay()
	{
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer c = new Customer("fffn","mnnn","llln",new Date(System.currentTimeMillis()));
		Address a = new Address("sl1","sl2","blr","ka","56","in");
		
		c.getAddresses().add(a);
		
		em.persist(c);
		
		tx.commit();
		em.close();
	}
	
	public static void createAccountAndCustomerTogether()
	{
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer c = new Customer("fn","mnn","ldd",new Date(System.currentTimeMillis()));
		SavingsAccount sa = new SavingsAccount(1234);
		sa.setCustomer(c);
		
		em.persist(sa);
		tx.commit();
		em.close();
	}
	
	public static void readAccountAlongWithCustomer()
	{
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		
		SavingsAccount sa = em.find(SavingsAccount.class, 2);
		System.out.println(sa.getCustomer().getFirstName());
		em.close();
	}
	
	public static void testLazy()
	{
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		Customer c1 = em.find(Customer.class,39);
		em.close();
		System.out.println(c1.getFirstName());
		Account a = c1.getAccounts().get(0);
		System.out.println(a.getBalance());// Prints Balance of customer's account as expected with em.close() following it.
		
	}
	
	public static void main(String[] args) {
		//createAccountAndCustomerSeparately();
		//createAccountAndCustomerTogether();
		//readAccountAlongWithCustomer();
		//testLazy();
		testManyToMnay();
		System.exit(0);
	}

}
