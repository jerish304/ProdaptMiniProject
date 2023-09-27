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
import project.service.admin.View_Edit_Delete_Service;




@WebServlet("/View_Edit_Delete_Controller")
public class View_Edit_Delete_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		String viewchoice = request.getParameter("viewchoice");
		System.out.println(pid);
		View_Edit_Delete_Service veds = new View_Edit_Delete_Service();
		List<Product> l=null;
		try {
			l = veds.service(pid);
			request.setAttribute("list", l);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(viewchoice.equals("EDIT"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Edit.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Delete_Controller");
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
