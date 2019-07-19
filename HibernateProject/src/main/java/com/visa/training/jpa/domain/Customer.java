package com.visa.training.jpa.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String firstName;
	String middleName;
	String lastName;
	Date dateOfJoin;
	
	@ManyToMany(cascade = CascadeType.PERSIST) //Between Address and Customer
	@JoinTable(name = "customer_address", joinColumns=@JoinColumn(name="cust_id"),inverseJoinColumns = @JoinColumn(name = "address_id"))
	List<Address> addresses = new ArrayList<>();
	
	public List<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
	List<Account> accounts = new ArrayList<>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(String firstName, String middleName, String lastName, Date dateOfJoin) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfJoin = dateOfJoin;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", dateOfJoin=" + dateOfJoin + "]";
	}	
}
