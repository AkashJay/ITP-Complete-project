package application;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SendEmail {

	public void send2(String msg,String path,String remail) {

	    
	    
	    

	    final String username = "dressmo99@gmail.com"; //ur email
	    final String password = "shalika93";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	    protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(username, password);
	    }                            
	});

	    try {
	        
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("dressmo99@gmail.com"));//ur email
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(remail));//u will send to
	        message.setSubject("New Order");    
	        message.setText(msg);//msg
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        Multipart multipart = new MimeMultipart();


	     
	     
	    //attached 1 --------------------------------------------
	        String file = path;
	        String fileName = "Order";
	    messageBodyPart = new MimeBodyPart();   
	    DataSource source = new FileDataSource(file);      
	    messageBodyPart.setDataHandler(new DataHandler(source));
	    messageBodyPart.setFileName(fileName);
	    multipart.addBodyPart(messageBodyPart);
	    //------------------------------------------------------    
	     
	   /*  //attached 2 --------------------------------------------  
	       String file2="path of file";
	       String fileName2 = "AnyName2";
	    messageBodyPart = new MimeBodyPart();   
	    DataSource source2 = new FileDataSource(file2);      
	    messageBodyPart.setDataHandler(new DataHandler(source2));
	    messageBodyPart.setFileName(fileName2);
	    multipart.addBodyPart(messageBodyPart);
	  //attached 3------------------------------------------------
	       
	       String file3="path of file";
	       String fileName3 = "AnyName3";
	    messageBodyPart = new MimeBodyPart();   
	    DataSource source3 = new FileDataSource(file3);      
	    messageBodyPart.setDataHandler(new DataHandler(source3));
	    messageBodyPart.setFileName(fileName3);
	    multipart.addBodyPart(messageBodyPart);
	    //attached 4------------------------------------------------
	    String file4="path of file";
	       String fileName4 = "AnyName4";
	    messageBodyPart = new MimeBodyPart();   
	    DataSource source4 = new FileDataSource(file4);      
	    messageBodyPart.setDataHandler(new DataHandler(source4));
	    messageBodyPart.setFileName(fileName4);
	    multipart.addBodyPart(messageBodyPart);
	    //>>>>>>>>
	   */
	    
	    
	        message.setContent(multipart);

	       
	        System.out.println("sending");
	        Transport.send(message);
	        System.out.println("Done");
	        
	    	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("EMAIL");
			//alert.setHeaderText("Information Alert");
			String s ="Email Send succesfully";
			alert.setContentText(s);
			alert.show();
	   

	            
	}catch (MessagingException e) {
	        e.printStackTrace();
	    }
	  }
}
