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


@WebServlet("/RemoveFromWishList")
public class RemoveFromWishList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession();
		List<Integer> wishlist = (List<Integer>) sess.getAttribute("wishlist");
		
		int id = Integer.parseInt(request.getParameter("pid"));
		wishlist.remove(wishlist.indexOf(id));
		
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.include(request, response);
		response.getWriter().println("<br><br><br><h4><center>PRODUCT REMOVED FROM WISHLIST</center></h4>");
		
	}


}
