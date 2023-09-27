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
import project.service.user.QuantityReducer_Service;
import project.service.user.RemoveAddCart_Service;


@WebServlet("/Quantity_Reducer")
public class Quantity_Reducer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("pid"));
		int com = Integer.parseInt(request.getParameter("comm"));
		QuantityReducer_Service qrs = new QuantityReducer_Service();
		try {
			qrs.reducer(id,com);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		HttpSession sess = request.getSession();
		List<Product> wishlist = (List<Product>) sess.getAttribute("wishlist");
		String email = (String) sess.getAttribute("userid");
		if(wishlist.contains(id))
		{
			wishlist.remove(wishlist.indexOf(id));
		}
		RemoveAddCart_Service ras = new RemoveAddCart_Service();
		try {
			ras.delete(id,email);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.include(request, response);
		response.getWriter().println("<br><br><br><h3><center>THE PRODUCT WILL DELIVIERED WITHIN 2 DAYS</center></h3>");
		
		
	}


}
