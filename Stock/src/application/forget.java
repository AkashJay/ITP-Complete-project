package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class forget {
		
	public static int attempt=0;
	
	public static Boolean forgetpassword(JFXTextField a,JFXPasswordField b,StackPane p,Label m) {
		
		
		if(a.getText().isEmpty() || b.getText().isEmpty()){
			m.setStyle("-fx-text-fill:red");
			m.setText("TextField Cannot Be Empty!!!!!!!");
			 	
	   	return false;
		}
		return true;
	
	
	}
	
	
	public static Boolean username(JFXTextField a,StackPane p,Label m) throws ClassNotFoundException, SQLException {
		
		
			Connection c=DBcon.ConnerDb();
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("Select * From logindetails where username='"+a.getText()+"' ");
			
			if(!rs.next()){
				attempt++;
				m.setStyle("-fx-text-fill:red");
				m.setText("UserName is Wrong!!!!!!!");
			    a.requestFocus();
			   	
	   	return false;
		}
	return true;
	}
	
	
public static Boolean password(JFXPasswordField a,StackPane p,Label m) throws ClassNotFoundException, SQLException {
		
		
		Connection c=DBcon.ConnerDb();
		Statement s=c.createStatement();
		ResultSet rs=s.executeQuery("Select * From logindetails where password='"+a.getText()+"' ");
		
		if(!rs.next()){
			attempt++;
			m.setStyle("-fx-text-fill:red");
			m.setText("Password Is Wrong.!!!!!!!");
		    	
   	return false;
	}
return true;
}

public static boolean attempt(JFXButton a,StackPane p,Label m) {
	
		if(forget.attempt>3){
			
			a.setDisable(true);
			m.setStyle("-fx-text-fill:red");
			m.setText("Your Attempts Are Over.Select Forget Button To \nRecover Your UserName & Password.");
		return false;
		}
		return true;
	}
	
	
	
}
	

