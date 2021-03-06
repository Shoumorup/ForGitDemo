package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	
	public int save(Product toBeSaved) throws Exception{
		Connection c = JdbcUtil.getConnection();
		PreparedStatement stmt = c.prepareStatement("INSERT into `product`(product_name,product_price,product_qoh) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, toBeSaved.getName());
		stmt.setFloat(2, toBeSaved.getPrice());
		stmt.setInt(3, toBeSaved.getQoh());
		stmt.executeUpdate();
		
		ResultSet keys = stmt.getGeneratedKeys();
		keys.next(); //As Cursor points to starting of table
		int generatedID = keys.getInt(1);
		c.close();
		return generatedID;
	}
	
	public Product findById(int id)throws Exception
	{
		//Read based on ID
		Product prod = null;
		Connection c = JdbcUtil.getConnection();
		PreparedStatement stmt = c.prepareStatement("SELECT * from product where product_id = ?");
		stmt.setInt(1,id);
		
		ResultSet rs=stmt.executeQuery();
		
		if(rs.next()) prod = mapRow(rs);	
			
		c.close();
		return prod;
	}

	private Product mapRow(ResultSet rs) throws SQLException {
		Product prod = new Product();
		prod.setId(rs.getInt(1));
		prod.setName(rs.getString(2));
		prod.setPrice(rs.getFloat(3));
		prod.setQoh(rs.getInt(4));
		return prod;
	}
	
	public List<Product> findAll()throws  Exception
	{
		//Read all
		Connection c = JdbcUtil.getConnection();
		PreparedStatement stmt = c.prepareStatement("SELECT * from product");
		List<Product> list =new ArrayList<Product>();		
		ResultSet rs=stmt.executeQuery();
		
		while(rs.next()) list.add(mapRow(rs));
		c.close();
		return list;
	}
	
	public void removeByID(int id)throws Exception
	{
		Connection c = JdbcUtil.getConnection();
		PreparedStatement stmt = c.prepareStatement("DELETE FROM product where product_id=?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		c.close();
	}
	
//	public void update(Product updated)
//	{
//		
//	}
}
