package project.service.admin;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.connect.DAOClass;


public class Edit_Service 
{
	public int editService(int id,double price,int quan) throws ClassNotFoundException, SQLException
	{
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("Update products set pPrice=?,pQty=? where pid=?");
		ps.setDouble(1, price);
		ps.setInt(2, quan);
		ps.setInt(3, id);
		System.out.println(id);
		System.out.println(price);
		System.out.println(quan);
		int temp = ps.executeUpdate();
		System.out.println("WEEEEEE");
		return temp;
	}
}
