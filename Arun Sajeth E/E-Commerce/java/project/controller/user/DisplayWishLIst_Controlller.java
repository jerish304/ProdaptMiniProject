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
import project.service.user.DisplayWishList_Service;



@WebServlet("/DisplayWishLIst_Controlller")
public class DisplayWishLIst_Controlller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession();
		List<Integer> wishlist = (List<Integer>) sess.getAttribute("wishlist");
		System.out.println("777777777");
		if(wishlist==null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("MyList.jsp");
			rd.forward(request, response);
		}
		else
		{
			DisplayWishList_Service dws = new DisplayWishList_Service();
			List<Product> displist = null;
			try {
				displist = dws.display(wishlist);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("list", displist);
		
			RequestDispatcher rd = request.getRequestDispatcher("MyList.jsp");
			rd.forward(request, response);
			
		}
	}

}
