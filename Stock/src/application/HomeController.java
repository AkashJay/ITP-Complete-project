package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomeController implements Initializable {
	@FXML
	private AnchorPane pan1;
	@FXML
	private JFXButton Jbtn_analysis;
	@FXML
	private JFXButton Jbtn_notification;
	@FXML
	private JFXButton Jbtn_orders;
	@FXML
	private JFXButton Jbtn_suppliers;
	@FXML
	private JFXButton Jbtn_viewstock;
	@FXML
	private JFXButton Jbtn_additems;
	@FXML
	private JFXButton jbtn_logout;
	@FXML
	private Label Jlbl_date;
	@FXML
	private Label Jlbl_time;


	
	ObservableList<TableStocknotification> List1 = FXCollections.observableArrayList();
	ObservableList<tableExpire> List3 = FXCollections.observableArrayList();
	// Event Listener on JFXButton[#Jbtn_analysis].onAction
	@FXML
	public void btn_analysis(ActionEvent event)throws Exception {
		// TODO Autogenerated
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/SalesAnalysis.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// Event Listener on JFXButton[#Jbtn_notification].onAction
	@FXML
	public void btn_notification(ActionEvent event) throws Exception {
		// TODO Autogenerated
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/ViewNotifications.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// Event Listener on JFXButton[#Jbtn_orders].onAction
	@FXML
	public void btn_orders(ActionEvent event) throws Exception {
		// TODO Autogenerated
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/ViewOrders.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// Event Listener on JFXButton[#Jbtn_suppliers].onAction
	@FXML
	public void btn_suppliers(ActionEvent event) throws Exception {
		// TODO Autogenerated
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/ViewSuppliers.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// Event Listener on JFXButton[#Jbtn_viewstock].onAction
	@FXML
	public void btn_viewstock(ActionEvent event) throws Exception{
		// TODO Autogenerated
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/ViewStock.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// Event Listener on JFXButton[#Jbtn_additems].onAction
	@FXML
	public void btn_additems(ActionEvent event) throws Exception {
		// TODO Autogenerated
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/AddItems.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// Event Listener on JFXButton[#jbtn_logout].onAction
	@FXML
	public void logout(ActionEvent event) throws Exception {
		// TODO Autogenerated
		((Node)event.getSource()).getScene().getWindow().hide();
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/login.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void loadexpiretable(){
		DateFormat df = new SimpleDateFormat("dd/MM/yy"); 
		Calendar calobj = Calendar.getInstance();
		try{
			Connection c = (Connection) DBcon.ConnerDb();
			String q1 = "select * from expire where Expire_date	<'"+df.format(calobj.getTime())+"'" ;
			PreparedStatement ps1 = (PreparedStatement) c.prepareStatement(q1);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				List3.add(new tableExpire(
						rs1.getString(1),
						rs1.getString(2)));
				
			}
			if(!List3.isEmpty()){
				Alert alert1 = new Alert(AlertType.WARNING);
				alert1.setTitle("DATA ERROR");
				//alert.setHeaderText("Information Alert");
				String s1 ="There Expiered Items";
				alert1.setContentText(s1);
				alert1.show();
			}
		}
		catch(Exception e){System.out.println(e);}}
	
	public void stocknottable(){
		try{
			Connection c = (Connection) DBcon.ConnerDb();
			String q1 = "select * from subcategory" ;
			PreparedStatement ps1 = (PreparedStatement) c.prepareStatement(q1);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				int id = rs1.getInt(1);
				int min = rs1.getInt(4);
				int tot = 0;
				String q2 = "SELECT * FROM items WHERE 	subcategoryid ='"+id+"'" ;
				PreparedStatement ps2 = (PreparedStatement) c.prepareStatement(q2);
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next()){
					tot=tot+rs2.getInt(4);
				}
				System.out.print(rs1.getInt(1)+"   ");
				System.out.println(tot);
				if(tot<min){
					
					List1.add(new TableStocknotification(
							rs1.getInt(1), 
							rs1.getString(2), 
							rs1.getInt(3), 
							rs1.getInt(4),
							rs1.getInt(5)));
					
				}
			}
			
			if(!List1.isEmpty()){
			Alert alert1 = new Alert(AlertType.WARNING);
			alert1.setTitle("DATA ERROR");
			//alert.setHeaderText("Information Alert");
			String s1 ="Stock items are getting down";
			alert1.setContentText(s1);
			alert1.show();
		}}
		
		catch(Exception e){
			System.out.print(e);
		}
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	DateFormat df = new SimpleDateFormat("dd/MM/yy"); 
	DateFormat dft = new SimpleDateFormat("HH:mm:ss"); 
	Calendar calobj = Calendar.getInstance();
	Calendar calobjj = Calendar.getInstance();
	//System.out.println(df.format(calobj.getTime()));
	Jlbl_date.setText(df.format(calobj.getTime()));
	Jlbl_time.setText(dft.format(calobjj.getTime()));
	
	stocknottable();
	loadexpiretable();
		
		
	}
	
	
	
}
