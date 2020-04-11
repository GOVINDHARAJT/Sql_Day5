package dao;

import java.util.*;

import model.*;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utility.ConnectionManager;
import java.util.Date;
public class CrudDAO {

	public void addListUser(User user)throws Exception{
		try {
				
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		String sql = "INSERT INTO customer(mobileno,name,fdate)VALUES(?,?,?)";
		PreparedStatement st1 = con.prepareStatement(sql);

		st1.setString(1, user.getMobileno());
		st1.setString(2,user.getCustomername());
		st1.setString(3,user.getfDate());
		
		st1.executeUpdate();
		con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}

	
	public void getAllUsers(){
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM customer");
			while(rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print("\t\t"+rs.getString(2));
				System.out.println("\t\t     "+rs.getString(3));
			}
			
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}
	
}
