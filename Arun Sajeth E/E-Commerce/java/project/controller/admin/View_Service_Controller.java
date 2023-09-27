package project.controller.admin;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.model.Product;
import project.service.admin.View_Product_Service;



@WebServlet("/View_Service_Controller")
public class View_Service_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		View_Product_Service vps = new View_Product_Service();
		try 
		{
			List<Product> list = vps.viewProduct();
			System.out.println(list);
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("View_Product.jsp");
			rd.forward(request, response);
			System.out.println("!!!!!!!");
			
		}
		catch (SQLException | ClassNotFoundException e) 
		{
			RequestDispatcher rd = request.getRequestDispatcher("Add_Product.jsp");
			rd.include(request, response);
			response.getWriter().println("<h3>NO DATA AVAILABLE IN PRODUCTS</h3>");
			e.printStackTrace();
		}
	}



}
