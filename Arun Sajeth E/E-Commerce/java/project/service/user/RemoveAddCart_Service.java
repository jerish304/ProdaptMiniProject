package project.service.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.connect.DAOClass;

public class RemoveAddCart_Service 
{
	public void delete(int id,String mail) throws ClassNotFoundException, SQLException
	{
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("delete from addcart where email=? and pid=?");
		ps.setString(1, mail);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
}
