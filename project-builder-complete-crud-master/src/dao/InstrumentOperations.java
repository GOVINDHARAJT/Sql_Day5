package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


import model.*;
import utility.ConnectionManager;
public class InstrumentOperations {

//Insert instrument details
	public void Insert(Instrument instrument) throws Exception {
			
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			String sql = "INSERT INTO instrumentdetails(id,iname,price)VALUES(?,?,?)";
			PreparedStatement st1 = con.prepareStatement(sql);

			st1.setString(1, instrument.getId());
			st1.setString(2,instrument.getIname());
			st1.setString(3,instrument.getPrice());
						
			st1.executeUpdate();
			con.close();
		}

//Delete Instrument Details
	public void deleteInstrument(String id) {
		try {
			boolean del;
		Connection con = ConnectionManager.getConnection();
		PreparedStatement st= con.prepareStatement("DELETE FROM instrumentdetails WHERE id = ?");
		st.setString(1, id);
	    del = st.executeUpdate()>0;
		if(del==true)
			System.out.println("Instrument ID = "+id+" Deleted Successfully!");
		else
			System.out.println("Incorrect ID!");
	    
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	

//Update Instrument Details
	public void updateInstrument(String id) {
		try {
		boolean up;
		Scanner sc = new Scanner(System.in);
		Connection con = ConnectionManager.getConnection();
		PreparedStatement st= con.prepareStatement("UPDATE instrumentdetails SET iname = ?,price = ? WHERE id = ?");
		System.out.print("Edit Instrument Name : ");
		String iname = sc.next();
		System.out.print("Edit Instrument Price : ");
		String price = sc.next();
		st.setString(1, iname);
		st.setString(2, price);
		st.setString(3, id);
		up = st.executeUpdate()>0;
		if(up==true)
			System.out.println("Instrument ID = "+id+" Updated Successfully!");
		else
			System.out.println("Incorrect ID!");
	    
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	

//Search By ID
	public Instrument SearchById(String id){
		Instrument ins = null;
		try {
		
		Connection con = ConnectionManager.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT id,iname,price FROM instrumentdetails WHERE id =?");
		st.setString(1, id);
	
		ResultSet rs = st.executeQuery();

		while(rs.next())
		{
			String id1 = rs.getString(1);
			String iname = rs.getString(2);
			String price = rs.getString(3);
			System.out.println("Enter Your Instrument Name  : "+iname);
			System.out.println("Enter Your Instrument Price : "+price);
			
			ins = new Instrument(id1,iname,price);
		}
		con.close();		
		} catch (Exception e) {
			System.out.println(e);
		}
		return ins;
	
	}

//customer order	
	public void SearchByMobileno(String mobileno){
		try {
		Instrument ins = null;
		Connection con = ConnectionManager.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT mobileno,customername,id,iname,price,quantity,fDate FROM orderdetails WHERE mobileno =?");
		st.setString(1, mobileno);
	
		ResultSet rs = st.executeQuery();

		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7));
		}
		con.close();		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
//Order Instrument
	public void order(Order instrument) throws Exception {
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		String sql = "INSERT INTO orderdetails(mobileno,customername,id,iname,price,quantity,fDate)VALUES(?,?,?,?,?,?,?)";
		PreparedStatement st1 = con.prepareStatement(sql);

		st1.setString(1, instrument.getMobileno());
		st1.setString(2,instrument.getCustomername());
		st1.setString(3,instrument.getId());
		st1.setString(4,instrument.getIname());
		st1.setString(5, instrument.getPrice());
		st1.setString(6,instrument.getQuantity());
		st1.setString(7,instrument.getfDate());
		
		st1.executeUpdate();
		con.close();
	}

//Get all instrument details	
	public void getAllInstrument(){
		try {
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM instrumentdetails");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
		}
		
		con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//Get Order Details
	public void getOrderDetails(){
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM orderdetails");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7));
			}
			
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}


}




