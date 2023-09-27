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
import project.service.admin.Delete_Service;



@WebServlet("/Delete_Controller")
public class Delete_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DELETE LIST");
		List<Product> li=(List<Product>) request.getAttribute("list");
		int id=0;
		for(Product p:li)
		{
			id = p.getPid();
		}
		Delete_Service ds = new Delete_Service();
		try 
		{
			ds.deleteservice(id);
			RequestDispatcher rd = request.getRequestDispatcher("View_Service_Controller");
			rd.forward(request, response);
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
