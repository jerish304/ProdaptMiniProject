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
import javax.servlet.http.HttpSession;

import project.service.admin.Login_Service;




@WebServlet("/Login_Controller")
public class Login_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("email");
		String passwd = request.getParameter("password");
		
		if(user.equalsIgnoreCase("Admin@gmail.com") && passwd.equals("Reset@123"))
		{
			System.out.println(11111);
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		}
		else
		{
			String temp = null;
			Login_Service ls = new Login_Service();
			try 
			{
				temp=ls.userChecking(user, passwd);
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			if(temp.equals("act"))
			{
				HttpSession session = request.getSession();
				session.setAttribute("userid", user);
				
				List<Integer> wishlist = null;
				session.setAttribute("wishlist", wishlist);
				
				RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
				response.getWriter().println("<br><h4><center>"+temp+"<cneter></h4>");
			}
		}
	}


}
