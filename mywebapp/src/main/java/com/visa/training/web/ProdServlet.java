package com.visa.training.web;

import com.visa.training.jdbc.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/product")
public class ProdServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("product_name");
		String price=request.getParameter("product_price");
		String qoh=request.getParameter("product_qoh");
		
		ProductDAO pdao = new ProductDAO();
		Product p = new Product(name,Float.parseFloat(price),Integer.parseInt(qoh));
		
		PrintWriter out = response.getWriter();
		try {
		out.println("Created with ID:"+pdao.save(p));
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
