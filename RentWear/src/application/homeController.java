package application;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class homeController implements Initializable {
	
	
	@FXML
	private Button btn1;
	

    @FXML
    private Label lbltime;

    @FXML
    private Label lbldate;
	
	

	private int minute;
	private int hour;
	private int second;
	private int day;
	private int month;
	private int year;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {            
	        Calendar cal = Calendar.getInstance();
	        second = cal.get(Calendar.SECOND);
	        minute = cal.get(Calendar.MINUTE);
	        hour = cal.get(Calendar.HOUR);
	        day=cal.get(Calendar.DAY_OF_MONTH);
	        month=cal.get(Calendar.MONTH);
	        year=cal.get(Calendar.YEAR);
	        lbltime.setText(hour + ":" + (minute) + ":" + second);
	        lbldate.setText((month+1) + "/" + day + "/" + year);
	    }),
	         new KeyFrame(Duration.seconds(1))
	    );
	    clock.setCycleCount(Animation.INDEFINITE);
	    clock.play();
		
		
	}
	

	public void wearInfo() {
		
		try {
			Stage s1= new Stage();
			FXMLLoader loder= new FXMLLoader();
			Parent root=FXMLLoader.load(getClass().getResource("/application/wear.fxml"));
			Scene scene = new Scene(root);
			//((Node)e.getSource()).getScene().getWindow().hide();
			//scene.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
			s1.setScene(scene);
			s1.show();
		} catch(Exception e1) {
			e1.printStackTrace();
		}

	}
	

	public void rentWears() {
		
		try {
			Stage s1= new Stage();
			FXMLLoader loder= new FXMLLoader();
			Parent root=FXMLLoader.load(getClass().getResource("/application/rentWears.fxml"));
			Scene scene = new Scene(root);
			//((Node)e.getSource()).getScene().getWindow().hide();
			//scene.getStylesheets().add(getClass().getResource("button.css").toExternalForm());
			s1.setScene(scene);
			s1.show();
		} catch(Exception e1) {
			e1.printStackTrace();
		}

	}


}
