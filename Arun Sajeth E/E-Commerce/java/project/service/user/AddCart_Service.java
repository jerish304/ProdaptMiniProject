package project.service.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.connect.DAOClass;
import project.model.Product;



public class AddCart_Service 
{
	public List<Product> addcartService(int id) throws ClassNotFoundException, SQLException
	{
		List<Product> list = new ArrayList<>();
		Connection con = DAOClass.getConnect();
		PreparedStatement ps = con.prepareStatement("select * from products where pid =?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			list.add(new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));
		}
		return list;
	}
	
	public int addToDatabase(int pid, String email) throws ClassNotFoundException, SQLException
	{
		Connection con = DAOClass.getConnect();
		PreparedStatement ps2 = con.prepareStatement("select * from addcart where email=? and pid=?;");
		System.out.println(1111);
		ps2.setString(1,email);
		System.out.println(111);
		ps2.setInt(2, pid);
		System.out.println(1111);
		ResultSet rs1 = ps2.executeQuery();
		
		if(rs1.next())
		{
			System.out.println(22222);
			PreparedStatement ps3 = con.prepareStatement("update addcart set quantity=? where email=? and pid=?");
			System.out.println(22222);
			ps3.setInt(1, rs1.getInt(3)+1);
			System.out.println(22222);
			ps3.setString(2, email);
			ps3.setInt(3, pid);
			System.out.println(22222);
			ps3.executeUpdate();
			return -1;
		}
		else
		{
			int t =1;
			PreparedStatement ps1 = con.prepareStatement("insert into addcart values (?,?,?)");
			ps1.setString(1,email);
			ps1.setInt(2, pid);
			ps1.setInt(3, t);
			int temp = ps1.executeUpdate();
			return temp;
		}
	}
}
