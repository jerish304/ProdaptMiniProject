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

import project.model.Product;
import project.service.user.User_View_Product_Service;


@WebServlet("/User_View_Product_Controller")
public class User_View_Product_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User_View_Product_Service uvps = new User_View_Product_Service();
		try {
			List<Product> list = uvps.userviewProduct();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("User_View_Product.jsp");
			rd.forward(request, response);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
