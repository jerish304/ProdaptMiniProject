package project.controller.admin;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.service.admin.Edit_Service;



@WebServlet("/Edit_Controller")
public class Edit_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double price = Double.parseDouble(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("quan"));
		int id = Integer.parseInt(request.getParameter("ID"));
		Edit_Service es = new Edit_Service();
		try {
			es.editService(id, price, qty);
			RequestDispatcher rd = request.getRequestDispatcher("View_Service_Controller");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
