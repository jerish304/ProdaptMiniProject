package project.service.admin;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.connect.DAOClass;
import project.model.Registration;


public class InactiveCustomer_Service 
{
	public List<Registration> service() throws ClassNotFoundException, SQLException
	{
		Connection con = DAOClass.getConnect();
		List<Registration> list = new ArrayList<Registration>();
		PreparedStatement ps = con.prepareStatement("select * from register where status='inactive';");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			list.add(new Registration(rs.getString(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		return list;
	}
}
