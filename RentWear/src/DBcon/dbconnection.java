package DBcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
	
public static Connection mycon() throws ClassNotFoundException,SQLException{
	    
        Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/wear1","root","");
        return c;
    } 

}
