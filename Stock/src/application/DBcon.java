package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBcon {
	
	 public static Connection ConnerDb(){
	        try{
	     
	            Class.forName("com.mysql.jdbc.Driver");
	           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockdb", "root", "");
	           //Statement st=conn.createStatement();
	            System.err.println("db con ok");
	    return conn;
	    
	        }catch(ClassNotFoundException | SQLException ee){
	        JOptionPane.showMessageDialog(null, ee);
	        System.out.println(ee);
	        return null;
	        }
	 }
}