package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class recover {
	
	public static boolean empty(JFXTextField a,JFXTextField b,JFXTextField c,Label m) {
		
		if(a.getText().isEmpty() || b.getText().isEmpty() || c.getText().isEmpty()){
			m.setStyle("-fx-text-fill:red");
			m.setText("TextField Cannot Be Empty!!!!!!!");
			return false;
		}
		return true;
		
	}
	
	public static boolean phone(JFXTextField a,Label b) {
		
		Pattern p=Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
		Matcher m=p.matcher(a.getText());
		
		if(m.find() && m.group().equals(a.getText())){
			return true;
		}
		else{
			b.setStyle("-fx-text-fill:red");
			b.setText("Please Enter 9 Digits For Phone Field After '94'."+"\n" + "Please Enter Digits");
	    	return false;
		}	
		
	}
		

}
