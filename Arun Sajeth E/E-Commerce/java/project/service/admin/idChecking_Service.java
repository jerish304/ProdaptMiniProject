package project.service.admin;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.connect.DAOClass;


public class idChecking_Service 
{
	public int service(int id) throws ClassNotFoundException, SQLException
	{
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("select * from products where pid=?");
		ps.setInt(1, id);
		int temp = ps.executeUpdate();
		return temp;
	}
}
