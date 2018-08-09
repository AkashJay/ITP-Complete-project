package application;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SalesAnalysis_C {

	 @FXML
	    private JFXButton Jbtn_home;
	

	    @FXML
	    private PieChart Jgraph_cat;

	    @FXML
	    private PieChart Jgraph_scat;

	    @FXML
	    private JFXButton Jbtn_reports;

	   
						
	    @FXML
	    void genarete_piechart(ActionEvent event) {
	    	
	    	ObservableList<Data> List = FXCollections.observableArrayList(
	    			new PieChart.Data("Gents", 30),
	    			new PieChart.Data("Ladies", 50),
	    			new PieChart.Data("Kids", 10),
	    			new PieChart.Data("Cosmetics", 10)
	    				    		);
	    	Jgraph_cat.setData(List);
			
			
					
					
			
	    }

	    @FXML
	    void genarete_piechart1(ActionEvent event) {
	    	ObservableList<Data> List = FXCollections.observableArrayList(
	    			new PieChart.Data("Shirts", 10),
	    			new PieChart.Data("Tshirts", 15),
	    			new PieChart.Data("Denims", 10),
	    			new PieChart.Data("Trousers", 20),
	    			new PieChart.Data("Denims", 10),
	    			new PieChart.Data("Denims", 10),
	    			new PieChart.Data("Trousers", 15)
	    			
	    				    		);
	    	Jgraph_scat.setData(List);
			
			
	    }

				


	    @FXML
	    void btn_home(ActionEvent event) throws Exception{
	    	((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(scene);
			primaryStage.show();

	    }
	    @FXML
	    void btn_reports(ActionEvent event) throws Exception{
	    	((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Reports.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(scene);
			primaryStage.show();
	    }
	    }


