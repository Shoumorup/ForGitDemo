package com.visa.training.jpa.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends Account{
	
	@Column(name = "OD_limit")
	float ODLimit;
	
	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(float balance,float ODLimit) {
		super(balance);
		this.ODLimit = ODLimit;
		// TODO Auto-generated constructor stub
	}

	public float getODLimit() {
		return ODLimit;
	}

	public void setODLimit(float oDLimit) {
		ODLimit = oDLimit;
	}
	
	

}
