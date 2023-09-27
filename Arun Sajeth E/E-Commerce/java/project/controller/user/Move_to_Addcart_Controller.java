package project.controller.user;

import java.io.IOException;
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


@WebServlet("/Move_to_Addcart_Controller")
public class Move_to_Addcart_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession();
		String email = (String) sess.getAttribute("userid");
		int pid = Integer.parseInt(request.getParameter("pid"));
		System.out.println(pid);
		System.out.println(email);
		List<Product> list = null;
		AddCart_Service as = new AddCart_Service();
		try {
			list = as.addcartService(pid);			
			int temp =as.addToDatabase(pid, email);
			System.out.println(8888888);
			List<Integer> wishlist = (List<Integer>) sess.getAttribute("wishlist");
			wishlist.remove(wishlist.indexOf(pid));
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.include(request, response);
			response.getWriter().println("<br><br><br><br><h4><center>Product moved to cart</h4></center>");
			
				
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
