package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class ConnectionTest {
	public static void main(String[] args)throws Exception
	{
		Connection c = JdbcUtil.getConnection();
		DatabaseMetaData metaData = c.getMetaData();
		System.out.println("Product is: "+metaData.getDatabaseProductName());
		System.out.println("Version is: "+metaData.getDatabaseProductVersion());
	}

}
