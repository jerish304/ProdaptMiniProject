package project.service.admin;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.connect.DAOClass;


public class Delete_Service 
{
	public void deleteservice(int id) throws ClassNotFoundException, SQLException
	{
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("delete from products where pid=?");
		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
