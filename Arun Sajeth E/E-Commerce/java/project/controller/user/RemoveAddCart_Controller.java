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

import project.service.user.RemoveAddCart_Service;



@WebServlet("/RemoveAddCart_Controller")
public class RemoveAddCart_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("pid"));
		
		HttpSession sess = request.getSession();
		String mail = (String)sess.getAttribute("userid");
		
		RemoveAddCart_Service ras = new RemoveAddCart_Service();
		
		try {
			ras.delete(id, mail);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.include(request, response);
		response.getWriter().println("<br><br><br><h4><center>Removed From My Cart</center></h4>");
	}

}
