package dao;
import java.io.*;
import java.util.*;
import utility.*;
import java.sql.*; 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
public class CovertToPDF {
public void ConvertToPDF() throws SQLException, ClassNotFoundException, FileNotFoundException, DocumentException {
	 
	Connection con = ConnectionManager.getConnection();
	 Statement st = con.createStatement();
     ResultSet query_set = st.executeQuery("SELECT mobileno,customername,id,iname,price,quantity,fDate FROM orderdetails");
     
     Document my_pdf_report = new Document();
   
     PdfWriter.getInstance(my_pdf_report, new FileOutputStream("OrderDetails.pdf"));
     my_pdf_report.open();            
    
     Paragraph p1 = new Paragraph( "*MUSICAL INSTRUMENT STORE*\nORDER DETAILS\n");
     p1.setAlignment(Paragraph.ALIGN_CENTER);
     my_pdf_report.add(p1);
     Paragraph l = new Paragraph("__________________________________________________________________________\n\n");
	 my_pdf_report.add(l);
     PdfPTable my_report_table = new PdfPTable(7);
     PdfPCell table_cell;
     
     String h1 = "MobileNo";
     table_cell=new PdfPCell(new Phrase(h1));
     my_report_table.addCell(table_cell);
     String h2 = "Customer_Name";
     table_cell=new PdfPCell(new Phrase(h2));
     my_report_table.addCell(table_cell);
     String h3 = "Ins_ID";
     table_cell=new PdfPCell(new Phrase(h3));
     my_report_table.addCell(table_cell);
     String h4 = "Ins_Name";
     table_cell=new PdfPCell(new Phrase(h4));
     my_report_table.addCell(table_cell);
     String h5 = "Ins_Price";
     table_cell=new PdfPCell(new Phrase(h5));
     my_report_table.addCell(table_cell);
     String h6 = "Quantity";
     table_cell=new PdfPCell(new Phrase(h6));
     my_report_table.addCell(table_cell);
     String h7 = "Date";
     table_cell=new PdfPCell(new Phrase(h7));
     my_report_table.addCell(table_cell);
     
    
     while (query_set.next()) {                
                     String mobile_no = query_set.getString("mobileno");
                     table_cell=new PdfPCell(new Phrase(mobile_no));
                     my_report_table.addCell(table_cell);
                     String c_name=query_set.getString("customername");
                     table_cell=new PdfPCell(new Phrase(c_name));
                     my_report_table.addCell(table_cell);
                     String id=query_set.getString("id");
                     table_cell=new PdfPCell(new Phrase(id));
                     my_report_table.addCell(table_cell);
                     String i_name=query_set.getString("iname");
                     table_cell=new PdfPCell(new Phrase(i_name));
                     my_report_table.addCell(table_cell);
                     String i_price=query_set.getString("price");
                     table_cell=new PdfPCell(new Phrase(i_price));
                     my_report_table.addCell(table_cell);
                     String i_quantity=query_set.getString("quantity");
                     table_cell=new PdfPCell(new Phrase(i_quantity));
                     my_report_table.addCell(table_cell);
                     String i_date=query_set.getString("fDate");
                     table_cell=new PdfPCell(new Phrase(i_date));
                     my_report_table.addCell(table_cell);
                     
                     }
     
     my_pdf_report.add(my_report_table);                       
     my_pdf_report.close();
     
     
     query_set.close();
     st.close(); 
     con.close();               
	}
}