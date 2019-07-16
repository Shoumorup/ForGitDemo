package com.bank.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountServiceTest {

	@Test
	//Self-explanatory
	public void createAccount_returns_valid_id_when_balance_gt_minbal() {
		//Arrange all objects you need to execute the code
		AccountService service = new AccountService();
		//Exercise the code you want to test
		int id = service.createNewAccount("SA", 10001);
		//Assert
		assertTrue(id>0);
//		Object o =new Object();
//		Thread t =new Thread();
//		t.wait
		
		
	}

}
