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
import project.service.user.Search_Service;


@WebServlet("/Search_Controller")
public class Search_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = request.getParameter("search");
		
		Search_Service ss = new Search_Service();
		List<Product> list = null;
		try {
			list = ss.service(search);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("Search_Display.jsp");
		rd.forward(request, response);
		
	}

	
}
