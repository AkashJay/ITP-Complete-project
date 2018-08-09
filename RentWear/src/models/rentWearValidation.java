package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DBcon.dbconnection;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class rentWearValidation {
	
	
	public Boolean email(String email) {
		
		Pattern p=Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher m=p.matcher(email);
		if(m.find() && m.group().equals(email)){
			
			return true;
		}
		else{
			Alert a1=new Alert(AlertType.WARNING);
	    	a1.setHeaderText(null);
	    	//a1.initStyle(StageStyle.UNDECORATED);
	    	a1.setContentText("Your Entered data: ("+email+") is not correct\nPlease enter a valid Email address with correct syntax");  
	    	a1.showAndWait();
	    	
	    	
		
	    	return false;
		}

	}

	
public boolean name(String name){
		
		Pattern p=Pattern.compile("^[\\p{L} .'-]+$");
		Matcher m1=p.matcher(name);
		
		if(m1.find() && m1.group().equals(name) ){
				
				return true;
			}
			else{
				Alert a1=new Alert(AlertType.WARNING);
		    	a1.setHeaderText(null);
		    	//a1.initStyle(StageStyle.UNDECORATED);
		    	a1.setContentText("Your Entered data: ("+name+") is not correct\nPlease enter the name without space");  
		    	a1.showAndWait();
		    	return false;
			}
		
		
	}


public boolean nameEmpty(String name){
	
	if(name.equals("")){
		Alert a1=new Alert(AlertType.WARNING);
    	a1.setHeaderText(null);
    	//a1.initStyle(StageStyle.UNDECORATED);
    	a1.setContentText("You Entered empty data for Name field.. \nPlease enter the correct name");  
    	a1.showAndWait();
    	return false;
		
	}
	return true;
	
}


public Boolean validatePhone(String phnNO) {
	
	Pattern p=Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
	Matcher m=p.matcher(phnNO);
	
	if(m.find() && m.group().equals(phnNO)){
		
		return true;
	}
	else{
		Alert a2=new Alert(AlertType.WARNING);
		a2.setHeaderText(null);
		//a2.initStyle(StageStyle.UNDECORATED);
		a2.setContentText("Your Entered data: ("+phnNO+") is not correct\nPlease enter a valid phone number which contain 10 digits");    		    	
		a2.showAndWait();
    
		
    	return false;
	}
	
	
}

public boolean datecompaire(LocalDate hire,LocalDate retu){
	
	
	
	if(hire.compareTo(retu) < 0){
		return true;
	}
	else{
		Alert a1=new Alert(AlertType.WARNING);
    	a1.setHeaderText(null);
    	//a1.initStyle(StageStyle.UNDECORATED);
    	a1.setContentText("You entered incorect data for the hire date and return date\n return date must be bigger than the start date..");  
    	a1.showAndWait();
    	
    	
		return false;
	}


}

public Boolean validateAmount(String ammount) {
	
	Pattern p=Pattern.compile("[0-9]+");
	Matcher m=p.matcher(ammount);
	
	if(m.find() && m.group().equals(ammount)){
		
		return true;
	}
	else{
		Alert a2=new Alert(AlertType.WARNING);
		a2.setHeaderText(null);
		//a2.initStyle(StageStyle.UNDECORATED);
		a2.setContentText("Your Entered data: ("+ammount+") is not correct\nAmount can only have a number(digits)..cam't have characters...");    		    	
		a2.showAndWait();
		
    	
    	return false;
	}
	
	
}

public Boolean nic(String nic) {
	Pattern p=Pattern.compile("^[0-9]{9}[vVxX]$");
	Matcher m=p.matcher(nic);
	
	if(m.find() && m.group().equals(nic)){
		
		return true;
	}
	else{
		
		Alert a1=new Alert(AlertType.WARNING);
    	a1.setHeaderText(null);
    	//a1.initStyle(StageStyle.UNDECORATED);
    	a1.setContentText("Your Entered data: ("+nic+") is not correct\nPlease enter a valid national ID number with 'v' at the end");
    	a1.showAndWait();
    	
    	return false;
	}

	
	
}

public boolean checkWear(String id){
	
	try {
		
		Connection c= dbconnection.mycon();
		Statement s= c.createStatement();
		ResultSet rsc=s.executeQuery(" SELECT * FROM `wearinfo` WHERE itemCode='"+id+"' ");
		
		while(rsc.next()){
			
			return true;
			
		}
		
	} catch (Exception e) {
		System.out.println(e);
	}
	Alert a1=new Alert(AlertType.WARNING);
	a1.setHeaderText(null);
	//a1.initStyle(StageStyle.UNDECORATED);
	a1.setContentText("System Has No ("+id+") Wear");
	a1.showAndWait();
	
	return false;
}


public boolean checInvoice(String id){
	
	try {
		
		Connection c= dbconnection.mycon();
		Statement s= c.createStatement();
		ResultSet rsc=s.executeQuery(" SELECT * FROM hiredetails Where invoiceNo='"+id+"' ");
		
		while(!rsc.next()){
			
			Alert a1=new Alert(AlertType.WARNING);
			a1.setHeaderText(null);
			//a1.initStyle(StageStyle.UNDECORATED);
			a1.setContentText("("+id+")\n Incorrect Invoice No");
			a1.showAndWait();
			
			return false;
			
			
		}
		
	} catch (Exception e) {
		System.out.println(e);
	}
	return true;
	
}

}

