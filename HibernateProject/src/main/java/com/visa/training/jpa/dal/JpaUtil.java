package com.visa.training.jpa.dal;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	public static EntityManagerFactory emf;
	
	public static EntityManagerFactory getEmf()
	{
		if(emf==null)
		{
			emf = Persistence.createEntityManagerFactory("mysql");
        }
        return emf;
	}

}
