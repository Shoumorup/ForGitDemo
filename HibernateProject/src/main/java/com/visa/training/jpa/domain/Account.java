package com.visa.training.jpa.domain;

import javax.persistence.*;

@Entity
@Table(name="account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="acct_type",discriminatorType = DiscriminatorType.STRING)
public abstract class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	float balance;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cust_id")
	Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(float balance) {
		super();
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}	
}
