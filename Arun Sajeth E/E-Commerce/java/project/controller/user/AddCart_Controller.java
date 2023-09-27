package project.controller.user;

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

import project.model.Product;
import project.service.user.AddCart_Service;


@WebServlet("/AddCart_Controller")
public class AddCart_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AddCart_Service as = new AddCart_Service();
		int id = Integer.parseInt( (String) request.getAttribute("id"));
		List<Product> list = null;
		try {
			list = as.addcartService(id);
			HttpSession session = request.getSession(false);
			String email = (String) session.getAttribute("userid");
			System.out.println(email);
			
			System.out.println(id);
			int temp =as.addToDatabase(id, email);
			System.out.println(8888888);
			
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.include(request, response);
			response.getWriter().println("<br><br><br><br><h4><center>product added to cart</h4></center>");
			
				
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
