package project.service.admin;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.connect.DAOClass;


public class AdminRegistration_Service 
{
	public void approve(String email) throws ClassNotFoundException, SQLException
	{
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("update register set status='active' where email=?");
		ps.setString(1, email);
		ps.executeUpdate();
	}
	
	public void deactivate(String email) throws ClassNotFoundException, SQLException
	{
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("update register set status='deactive' where email=?");
		ps.setString(1, email);
		ps.executeUpdate();
	}
	
	public void remove(String email) throws ClassNotFoundException, SQLException
	{
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("delete from register where email=?");
		ps.setString(1, email);
		ps.executeUpdate();
	}
}
