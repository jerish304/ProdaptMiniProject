package project.controller.admin;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.model.Registration;
import project.service.admin.ActiveCostumer_Service;




@WebServlet("/Active_Customer")
public class Active_Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActiveCostumer_Service acs = new ActiveCostumer_Service();
		List<Registration> list = new ArrayList<Registration>();
		try {
			list = acs.service();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("ActiveCustomer.jsp");
		rd.forward(request, response);
	}

	

}
