package project.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Admin_Choice_Controller")
public class Admin_Choice_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String admin_choice = request.getParameter("AdminOpr");
		
		if(admin_choice.equals("ADD PRODUCT"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Add_Product.jsp");
			rd.forward(request, response);
		}
		else if(admin_choice.equals("VIEW PRODUCT"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("View_Service_Controller");
			rd.forward(request, response);
		}
		else if(admin_choice.equals("VIEW INACTIVE CUSTOMER"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Inactive_Customer");
			rd.forward(request, response);
		}
		else if(admin_choice.equals("VIEW ACTIVE CUSTOMER"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Active_Customer");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("View_Costumer.jsp");
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
