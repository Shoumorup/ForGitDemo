package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet({"/addbooks", "/addcars", "/addbikes"})

public class ShoppingCartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		if(uri.endsWith("addbooks"))
		{
			String[] selectedBooks = request.getParameterValues("Book");
			//Storing in Session as required in future.
			session.setAttribute("selectedBooks", selectedBooks);
			//Forward request to cars
			request.getRequestDispatcher("cars.html").forward(request, response);
		}
		else if(uri.endsWith("addcars"))// Each IF is for Request-Response Cycle
		{
			String[] selectedCars = request.getParameterValues("Car");
			//Storing in Session as required in future.
			session.setAttribute("selectedCars", selectedCars);
			//Forward request to bikes
			request.getRequestDispatcher("bikes.html").forward(request, response);
		}
		else if (uri.endsWith("addbikes"))
		{
			String[] selectedBikes = request.getParameterValues("Bike");
			session.setAttribute("selectedBikes", selectedBikes);
//			String[] selectedBooks =(String[]) session.getAttribute("selectedBooks");
//			String[] selectedCars  =(String[]) session.getAttribute("selectedCars");
			
//			PrintWriter out = response.getWriter();
//			out.println("<html><body>");
//			out.println("<h4>Selected Books</h4>");
//			out.println("<ul>");
//			Stream.of(selectedBooks).map(s->"<li>"+s+"</li>").forEach(out::println);
//			out.println("</ul>"); 
//			out.println("<h4>Selected Cars</h4>");
//			out.println("<ul>");
//			Stream.of(selectedCars).map(s->"<li>"+s+"</li>").forEach(out::println);
//			out.println("</ul>");
//			out.println("<h4>Selected Bikes</h4>");
//			out.println("<ul>");
//			Stream.of(selectedBikes).map(s->"<li>"+s+"</li>").forEach(out::println);
//			out.println("</ul>");
//			out.println("</body></html>");
			
			request.getRequestDispatcher("cart_el.jsp").forward(request, response);
			
			//session.invalidate();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
