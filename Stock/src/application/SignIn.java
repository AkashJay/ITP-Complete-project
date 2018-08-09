package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class SignIn implements Initializable {
	
	@FXML
    private JFXTextField txtuser;

    @FXML
    private JFXPasswordField txtpass;

    @FXML
    private JFXButton btnsign;
    
    @FXML
    private StackPane stackpane;
    
    @FXML
    private Label lblerror;
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	txtuser.requestFocus();
		    }
		});
		
	}
	
	
	public void back(ActionEvent e) {
		
		try {
			
			FXMLLoader loader=new FXMLLoader();
			Parent root1=loader.load(getClass().getResource("/application/Home.fxml"));
			Scene scene = new Scene(root1);
			((Node)e.getSource()).getScene().getWindow().hide();
			Stage st1=new Stage();
			//st1.setScene(new Scene(root1));
			st1.setMaximized(true);
			//st1.initStyle(StageStyle.UNDECORATED);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			st1.setScene(scene);
			st1.show();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}
	public void exit(ActionEvent e) {
		 Platform.exit();
	}
	
	public void forget(ActionEvent e) {
		
try {
			
			FXMLLoader loader=new FXMLLoader();
			Parent root1=loader.load(getClass().getResource("/application/Forget.fxml"));
			Scene scene = new Scene(root1);
			((Node)e.getSource()).getScene().getWindow().hide();
			Stage st1=new Stage();
			//st1.setScene(new Scene(root1));
			//st1.setMaximized(true);
			st1.initStyle(StageStyle.UNDECORATED);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			st1.setScene(scene);
			st1.show();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		 
	}
	
	
	public void login(ActionEvent e) throws ClassNotFoundException, SQLException{
		
		if(forget.attempt(btnsign, stackpane,lblerror) &&  forget.forgetpassword(txtuser, txtpass, stackpane,lblerror) && forget.username(txtuser, stackpane,lblerror) && forget.password(txtpass, stackpane, lblerror)){
		
		try {
			Connection c=DBcon.ConnerDb();
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("Select * From logindetails where username='"+txtuser.getText()+"' and password='"+txtpass.getText()+"' ");
			
			if(rs.next()){
				
				JFXDialogLayout content1=new JFXDialogLayout();
			    content1.setHeading(new Text("Warning"));
			    content1.setBody(new Text("Login Is SuccessFull!!!!!!!"));
			    JFXDialog s12=new JFXDialog(stackpane,content1,JFXDialog.DialogTransition.TOP);
				JFXButton b1=new JFXButton("Okay");
				content1.setStyle("-fx-border-color:#3196de;-fx-border-radius:5px;-fx-background-color:white;-fx-border-width:2px;");
				b1.setButtonType(com.jfoenix.controls.JFXButton.ButtonType.RAISED);
				b1.setStyle("-fx-text-fill:WHITE;-fx-background-color:#3196de;-fx-background-radius:10px");
				b1.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						s12.close();
						back(e);
						}
				});
				content1.setActions(b1);
				s12.show();
			}
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	
		
	}
}
	public void grab() {
		txtpass.requestFocus();
	}
	public void grab1() {
		btnsign.requestFocus();
	}
	

	

}
