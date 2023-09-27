package project.service.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.connect.DAOClass;


public class QuantityReducer_Service 
{
	public void reducer(int id,int comm) throws ClassNotFoundException, SQLException
	{
		int qty =0;
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("select pQty from products where pid =?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			qty = rs.getInt(1)-comm;
		}
		PreparedStatement ps1 = con.prepareStatement("update products set pQty=? where pid = ?");
		ps1.setInt(1, qty);
		ps1.setInt(2, id);
		ps1.executeUpdate();
	}
}
