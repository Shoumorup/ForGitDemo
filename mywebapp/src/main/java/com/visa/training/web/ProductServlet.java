package com.visa.training.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.jdbc.Product;
import com.visa.training.jdbc.ProductDAO;


@WebServlet({ "/addProduct", "/listProducts", "/removeProduct"})
public class ProductServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		
		if(request.getRequestURI().endsWith("addProduct"))
		{
			String name = request.getParameter("name");
			float price = Float.parseFloat(request.getParameter("price"));
			int qoh = Integer.parseInt(request.getParameter("qoh"));
			Product p = new Product(name,price,qoh);
			try {
				dao.save(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(request.getRequestURI().endsWith("removeProduct"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				dao.removeByID(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		List<Product> productList=null;
		try {
			productList = dao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("products.jsp").forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
