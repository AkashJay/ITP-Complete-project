package application;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.PasswordField;

public class login_C {
	
	@FXML
	private Button Jbtn_login;
	@FXML
	private TextField Jtxtusername;
	@FXML
	private PasswordField Jtxtpwd;
	
	 
	@FXML
    private JFXButton Jbtn_close;
	
	
	public void btn_act(ActionEvent click) throws Exception{
		((Node)click.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		primaryStage.setMaximized(true);
		Parent root = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	  @FXML
	    void btn_close(ActionEvent event) {
		  Platform.exit();	
	    }

}
