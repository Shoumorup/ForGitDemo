package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
	
	public static Connection getConnection()
	{
		Connection c = null;
		//Create a Connection object and return it. 
		try
		{
			//Load the Driver Class
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the Connection
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Visa", "visa", "secret");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
}
