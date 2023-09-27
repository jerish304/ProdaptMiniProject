package project.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/User_View_Choice_Controller")
public class User_View_Choice_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user1choice = request.getParameter("viewchoice");
		System.out.println("1111111111");
		System.out.println(user1choice);
		
		if(user1choice.equals("ADD TO WIST LIST"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("WishList_Controller");
			rd.forward(request, response);
		}
		else if(user1choice.equals("ADD TO CART"))
		{
			request.setAttribute("id", request.getParameter("pid"));
			RequestDispatcher rd = request.getRequestDispatcher("AddCart_Controller");
			rd.forward(request, response);
		}
		else if(user1choice.equals("REMOVE FROM WIST LIST"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("RemoveFromWishList");
			rd.forward(request, response);
		}
		else if(user1choice.equals("REMOVE FROM ADD CART"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("RemoveAddCart_Controller");
			rd.forward(request, response);
		}
		else if(user1choice.equals("MOVE TO ADDCART"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Move_to_Addcart_Controller");
			rd.forward(request, response);
		}
		else if(user1choice.equals("MOVE TO WIST LIST"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Move_to_WishList_Controller");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Buy_Controller");
			rd.forward(request, response);
		}
	}


}
