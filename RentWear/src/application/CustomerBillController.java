package application;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

import DBcon.dbconnection;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class CustomerBillController implements Initializable {

	String invoice;

	  @FXML
	    private JFXTextArea text;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	}
	
	

	
	
	
	
	
	
	
	@FXML
	private void print(Node node) {
	    System.out.println("Creating a printer job...");

	    PrinterJob job = PrinterJob.createPrinterJob();
	    if (job != null) {
	      System.out.println(job.jobStatusProperty().asString());

	      boolean printed = job.printPage(node);
	      if (printed) {
	        job.endJob();
	      } else {
	        System.out.println("Printing failed.");
	      }
	    } else {
	      System.out.println("Could not create a printer job.");
	    }
	  }
	
	String deposit;
	
	@FXML
	public void setLetter(String invoice1) {
		// TODO Auto-generated method stub
		 this.invoice=invoice1;
	
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			String today = dateFormat.format(date);
			
		String s1=String.format("%60s\n\n","\n---------------------DRESSMO SHOPPING---------------------");
		String s4=String.format("%5s\n","		Anagarika Dharmapala Mawatha, Matara");
		String s6=String.format("%5s\n","			     http://www.dressmo.lk");
		String s5=String.format("%5s\n\n","			         TEL : 0415 708 700");
		String s2=String.format("%5s\n","Date : "+today);
		String s18=String.format("%5s\n","Invoice Numbet : "+invoice1);
		String s3=String.format("%5s\n","");
		
		String s8=String.format("%5s","------------------------------------------------------------------\n");
		String s7="";
		
		String amount;
		
		try {
			
			Connection c=dbconnection.mycon();
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("SELECT * FROM `hiredetails` WHERE `invoiceNo`='"+invoice1+"'");
			while(rs.next()){
				deposit=rs.getString("depmount");
				s7=s7+String.format("%5s",rs.getString("itemCode")+"\n		"+rs.getString("amount")+"		"+rs.getString("hireDate")+"		"+rs.getString("returnDate")+"\n------------------------------------------------------------------\n");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		String s9=String.format("%5s\n","\nDeposite	Amount				   : "+deposit);
	
		String s13=String.format("%5s\n\n","------------------------------------------------------------------");
		
		String s14=String.format("%5s\n","Exchange Is Possible Withn 7 Days Of Purchase.Items need to be original condition and accompaired with the recipt\n		Items marked [NR] are non returnable");
		String s15=String.format("%5s\n","Get Your Dressmo Loyalty Card Today and Get Rewarded..");
		String s16=String.format("%5s\n","\n	    THANK YOU FOR SHOPPING @ DRESSMO");
		String s17=String.format("%5s\n","	    ********************************************");
		text.setText(s1+s4+s6+s5+s2+s18+s3+s8+s7+s9+s13+s14+s15+s16+s17);
		
	}
	
	public void printnow() {	
	print(text);
	close();
		
	}
	
	
	public void close() {
        Stage stage = (Stage) text.getScene().getWindow();
        stage.close();
    }

}
