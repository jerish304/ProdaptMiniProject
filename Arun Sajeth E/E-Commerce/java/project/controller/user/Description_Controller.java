package project.controller.user;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.model.Product;
import project.service.user.Description_Service;



@WebServlet("/Description_Controller")
public class Description_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("prodid"));
		
		Description_Service ds = new Description_Service();
		Product pro = null;
		try {
			pro =ds.service(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("product", pro);
		RequestDispatcher rd = request.getRequestDispatcher("description.jsp");
		rd.forward(request, response);
	}

}
