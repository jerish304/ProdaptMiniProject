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
import project.service.user.DisplayAddCart_Service;


@WebServlet("/DisplayAddCart_Controller")
public class DisplayAddCart_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DisplayAddCart_Service das = new DisplayAddCart_Service();
		
		HttpSession sess = request.getSession();
		String email = (String) sess.getAttribute("userid");
		try {
			List<Integer> list1 = das.service(email);
			List<Integer> list2 = das.service1(email);
			System.out.println(list2);
			List<Product> list = das.display(list1);
			System.out.println(list);
			request.setAttribute("listquantity", list2);
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("displayAddcart.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
