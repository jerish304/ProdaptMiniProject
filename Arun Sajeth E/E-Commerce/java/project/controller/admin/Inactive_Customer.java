package project.controller.admin;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.model.Registration;
import project.service.admin.InactiveCustomer_Service;



@WebServlet("/Inactive_Customer")
public class Inactive_Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InactiveCustomer_Service ics = new InactiveCustomer_Service();
		List<Registration> list = new ArrayList<Registration>();
		
		try {
			list = ics.service();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("InactiveCustomer.jsp");
		rd.forward(request, response);

	}



}
