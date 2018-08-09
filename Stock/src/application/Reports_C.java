package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;

public class Reports_C {
	@FXML
	private JFXButton Jbtn_back;

	// Event Listener on JFXButton[#Jbtn_back].onAction
	@FXML
	public void btn_back(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/SalesAnalysis.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
