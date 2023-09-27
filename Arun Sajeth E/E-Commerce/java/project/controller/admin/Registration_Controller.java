package project.controller.admin;

import java.io.IOException;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.model.Registration;
import project.service.admin.*;

@WebServlet("/Registration_Controller")
public class Registration_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Registration_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		System.out.println(request.getParameter("dob"));
		String temp = request.getParameter("dob");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = null;
		try {
			dob = df.parse(temp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(dob);
		String mail = request.getParameter("email");
		String phno = request.getParameter("Phno");
		String password = request.getParameter("pwd");
		
		
		Registration r = new Registration(name,dob,mail,phno,password);
		System.out.println(r);
		Registration_Service rs = new Registration_Service();
		
		try {
			rs.service(r);
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e)
		{
			response.getWriter().println("<html><h1><center>Entered Email Id is already existing.</center></html>");
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
			rd.include(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
