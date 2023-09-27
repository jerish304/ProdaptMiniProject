package project.controller.admin;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.service.admin.AdminRegistration_Service;



@WebServlet("/AdminRegistration_Controller")
public class AdminRegistration_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminRegistration_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String choice1 = request.getParameter("viewchoice");
		AdminRegistration_Service ags = new AdminRegistration_Service();
	
		if(choice1.equals("APPROVE"))
		{
			try {
				ags.approve(email);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(choice1.equals("REMOVE"))
		{
			try {
				ags.remove(email);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {
				ags.deactivate(email);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}

	
	
}
