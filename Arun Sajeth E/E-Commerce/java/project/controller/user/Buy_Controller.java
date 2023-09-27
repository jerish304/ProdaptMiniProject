package project.controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.model.Product;
import project.service.user.Buy_Service;
import project.service.user.DisplayAddCart_Service;


@WebServlet("/Buy_Controller")
public class Buy_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		HttpSession sess = request.getSession();
		String email = (String)sess.getAttribute("userid");
		
		Buy_Service bs = new Buy_Service();
		
		Product prod = null;
		try {
			prod = bs.purchase(pid);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
				
		request.setAttribute("prod", prod);
		RequestDispatcher rd = request.getRequestDispatcher("buy.jsp");
		rd.forward(request, response);
	}

}
