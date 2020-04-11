package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import com.itextpdf.text.DocumentException;

import service.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import dao.*;
import model.*;
class FirstClass {

	static Map<Integer,User> map= new HashMap<Integer,User>();
	CrudDAO crud=new CrudDAO();
//Admin function	
	void admin() {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
	
		System.out.println("1.Insert");
		System.out.println("2.Delete");
		System.out.println("3.Update");
		System.out.println("4.Instrument Details");
		System.out.println("5.Customer Order Details");
		System.out.println("6.Customer Details");
		System.out.println("7.Exit");
		System.out.println("\nWhich Action You want to Perform?(1-7)");
		System.out.println("*----------------------------------------*");
		String id;
		String iname;
		String  price;
		String yn;
		Instrument instrument = null;
		CovertToPDF pdf =new CovertToPDF();
		InstrumentOperations ins=new InstrumentOperations();
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("*----------------------------------------*");
			System.out.println("         Enter Instrument Details         ");
			System.out.println("*----------------------------------------*");
			System.out.print("Enter Instrument ID : ");
			id = sc.next();
			System.out.print("Enter Instrument Name : ");
			iname = sc.next();
			System.out.print("Enter Instrument Price : ");
			price = sc.next();
			instrument = new Instrument(id,iname,price);
			try {
				ins.Insert(instrument);
			} catch (Exception e) {
			
				e.getMessage();
			}
			System.out.println("Inserted Successfully!");
			System.out.println("*----------------------------------------*");
			break;
		case 2:
			System.out.println("*----------------------------------------*");
			System.out.println("         Delete Instrument Details        ");
			System.out.println("*----------------------------------------*");
			System.out.print("Enter Instrument ID You Wants to Delete : ");
			id = sc.next();
			ins.deleteInstrument(id);
			System.out.println("*----------------------------------------*");
			break;
		case 3:
			System.out.println("*----------------------------------------*");
			System.out.println("         Update Instrument Details        ");
			System.out.println("*----------------------------------------*");
			System.out.print("Enter Instrument ID You Wants to Update : ");
			id = sc.next();
			ins.updateInstrument(id);
			System.out.println("*----------------------------------------*");
			break;
		
		case 4:
			System.out.println("*----------------------------------------*");
			System.out.println("            Instrument Details            ");
			System.out.println("*----------------------------------------*");
			System.out.println("Id         Instrument_Name     Price");
			System.out.println("*----------------------------------------*");
			ins.getAllInstrument();
			System.out.println("*----------------------------------------*");

			break;
		case 5:
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.println("                                               Customer Order Details                                                     ");
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.println("Mobile_No\t\tCustomer_Name\tIns_Id\t\tIns_Name\tPrice\t\tQuantity\tOrder Date & Time");
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			ins.getOrderDetails();
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.print("Do you want to generate PDF(Press : Y/N) : ");
			yn = sc.next();
			if(yn.equals("Y")||yn.equals("y")) {
				try {
					pdf.ConvertToPDF();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else
				System.out.println("Cancelled");
			System.out.println("*----------------------------------------*");
			break;
		case 6:
			System.out.println("*---------------------------------------------------------*");
			System.out.println("                    Customer Details               ");
			System.out.println("*---------------------------------------------------------*");
			System.out.println("Mobile_Number       Customer_Name            Date & Time");
			System.out.println("*---------------------------------------------------------*");
			crud.getAllUsers();
			System.out.println("*---------------------------------------------------------*");		
			break;
		case 7:
			 
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
	 }while(choice!=7);
	}
	
	
	//Customer function	
	@SuppressWarnings("null")
	void customer(String customername,String mobileno ) {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("*----------------------------------------*");
		System.out.println("   WELCOME TO  MUSICAL INSTRUMENT STORE   ");
		System.out.println("\t\t"+customername.toUpperCase());
		System.out.println("*----------------------------------------*");
		do {
		System.out.println("1.Instrument Details");
		System.out.println("2.Order Instrument");
		System.out.println("3.Your Orders");
		System.out.println("4.Exit");
		System.out.println("*----------------------------------------*");
		String id;
		String iname;
		String  price;
		String quantity;
		String yn;
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String fDate = myDateObj.format(myFormatObj);
		Order instrument =null;
	    choice = sc.nextInt();
	   
	    Billpdf bill = new Billpdf();

		InstrumentOperations ins=new InstrumentOperations();
		switch (choice) {
		case 1:
			System.out.println("*----------------------------------------*");
			System.out.println("            Instrument Details               ");
			System.out.println("*----------------------------------------*");
			System.out.println("Id         Instrument_Name     Price");
			System.out.println("*----------------------------------------*");
			ins.getAllInstrument();
			System.out.println("*----------------------------------------*");
			
			break;
		case 2:
			System.out.print("Enter Your Instrument ID : ");
			id = sc.next();
			Instrument intru=ins.SearchById(id);
		
			System.out.print("Enter Your Instrument Quantity : ");
			quantity = sc.next();
			System.out.print("Confirm Your Order(Press : Y/N) : ");
			yn = sc.next();
			if(yn.equals("Y")||yn.equals("y")) {
				instrument = new Order(mobileno,customername,id,intru.getId(),intru.getPrice(),quantity,fDate);
				try {
					ins.order(instrument);
				} catch (Exception e) {
			
					e.getMessage();
				}
				System.out.println("Order Successfull!");
				System.out.print("Do you want bill(Press : Y/N) : ");
				yn = sc.next();	
				if(yn.equals("Y")||yn.equals("y")) {
					try {
						bill.Billpdf(mobileno,customername,id,intru.getId(),intru.getPrice(),quantity,fDate);
					} catch (DocumentException e) {
			
						e.printStackTrace();
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				}
				System.out.println("*----------------------------------------*");
			}
			else
				System.out.println("Order Cancelled");
			System.out.println("*----------------------------------------*");
				
			break;
		case 3:
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.println("                                              "+customername+" Order Details                                              ");
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			System.out.println("Mobile_No\t\tCustomer_Name\tIns_Id\t\tIns_Name\tPrice\t\tQuantity\tOrder Date & Time");
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			ins.SearchByMobileno(mobileno);
			System.out.println("*------------------------------------------------------------------------------------------------------------------------*");
			break;
		case 4:
			System.out.println("THANK YOU COME AGAIN!");
			System.out.println("*----------------------------------------*");
			
			break;
		default:
			System.out.println("Wrong Choice");
			break;
		}
	  }while(choice!=4);
   }
}	

public class Main {
		
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("*----------------------------------------*");
		System.out.println("        MUSICAL INSTRUMENT STORE          ");
		System.out.println("*----------------------------------------*");
		while (true) {
			System.out.println("1.Admin");
			System.out.println("2.Customer");
			System.out.println("3.Exit");
			System.out.println("*----------------------------------------*");
			String username;
			String password;
			String mobileno;
			String customername;
			User user = null;
			FirstClass fc = new FirstClass();
			CrudDAO crud=new CrudDAO();
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String fDate = myDateObj.format(myFormatObj);
			
			int choice = sc.nextInt();
			
			ValidateUserFields validate=new ValidateUserFields();
			switch(choice) {
				case 1:
					System.out.print("Enter your username : ");
				    username = sc.next();
					System.out.print("Enter you password :");
					password = sc.next();
					if(validate.adminlogin(username,password) ){
						System.out.println("Login Successfull!");
						System.out.println("*----------------------------------------*");
						fc.admin();
					}
					else
						System.out.println("Check your username and password");
					    System.out.println("*----------------------------------------*");
					break;
				
				case 2:
					System.out.print("Enter your mobile number : ");
					mobileno = sc.next();
					System.out.print("Enter your name : ");
					customername = sc.next();
					user=new User(mobileno,customername,fDate);
										
					try {
						crud.addListUser(user);
					} catch (Exception e) {
					
						e.getMessage();
					}
					fc.customer(customername,mobileno);
					break;
				case 3:
					System.out.println("THANK YOU!");
					System.exit(0);
					break;
				default:
					System.out.println("Wrong Choice!!");
					break;
				}
	        }
		}
	}




