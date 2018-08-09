package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;

import DBcon.dbconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.rentWearValidation;

public class wearController implements Initializable{


    
    
    @FXML
    private JFXTextField txtwcode;

    @FXML
    private JFXTextField txtwname;

    @FXML
    private JFXTextField txtwmat;

    @FXML
    private JFXTextField txtwsize;

    @FXML
    private JFXComboBox<String> comcat;

    @FXML
    private JFXTextField txtwrentfee;

    @FXML
    private JFXTextField txtwlatefee;

    @FXML
    private JFXTextField txtwcost;

    @FXML
    private JFXTextField txtwsupplier;
    
    @FXML
    private StackPane stack2;


    @FXML
    private JFXTextField txtwdes;
    
    
    
    ObservableList<String> label=FXCollections.observableArrayList("Ariya Sinhala", "Bollywood", "British", "European");
	
    
    
    //wearTable
    
    @FXML
    private TableView<wearInfoTable> wearTable;

    @FXML
    private TableColumn<wearInfoTable, String> twcode;

    @FXML
    private TableColumn<wearInfoTable, String> twname;

    @FXML
    private TableColumn<wearInfoTable, String> tcat;

    @FXML
    private TableColumn<wearInfoTable, String> tmat;

    @FXML
    private TableColumn<wearInfoTable, String> twsize;

    @FXML
    private TableColumn<wearInfoTable, String> twsupplier;

    @FXML
    private TableColumn<wearInfoTable, String> twrentfee;

    @FXML
    private TableColumn<wearInfoTable, String> twlatefee;

    @FXML
    private TableColumn<wearInfoTable, String> twstatus;

    @FXML
    private TableColumn<wearInfoTable, String> twdes;
    
    @FXML
    private JFXTextField txtwsearch;
    
	
    public ObservableList<wearInfoTable> wearInfoList= FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		comcat.setItems(label);
		grab1();
		 tabellord1();
		 selectWear();
		
	}
	
	public void main(ActionEvent e) {
		
		try {
			Stage s1= new Stage();
			FXMLLoader loder= new FXMLLoader();
			Parent root=FXMLLoader.load(getClass().getResource("/application/home.fxml"));
			Scene scene = new Scene(root);
			((Node)e.getSource()).getScene().getWindow().hide();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			s1.setScene(scene);
			s1.show();
		} catch(Exception e1) {
			e1.printStackTrace();
		}

	}
	
	
	public void tabellord1() {
		
		try {
			
			Connection c= dbconnection.mycon();
			//Statement s= c.createStatement();
			
			ResultSet rs=c.createStatement().executeQuery("select * from wearinfo");
			while(rs.next()){
				wearInfoList.add(new wearInfoTable(rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(3),rs.getString(5),rs.getString(12),rs.getString(6),rs.getString(7),rs.getString(11),rs.getString(13)));
				
				
				

			}
			twcode.setCellValueFactory(new PropertyValueFactory<wearInfoTable , String>("wcode"));
			twname.setCellValueFactory(new PropertyValueFactory<wearInfoTable , String>("wname"));
			tcat.setCellValueFactory(new PropertyValueFactory<wearInfoTable , String>("wcat"));
			tmat.setCellValueFactory(new PropertyValueFactory<wearInfoTable , String>("wmat"));
			twsize.setCellValueFactory(new PropertyValueFactory<wearInfoTable , String>("wsize"));
			twsupplier.setCellValueFactory(new PropertyValueFactory<wearInfoTable , String>("wsupp"));
			twrentfee.setCellValueFactory(new PropertyValueFactory<wearInfoTable , String>("wrentfee"));
			twlatefee.setCellValueFactory(new PropertyValueFactory<wearInfoTable , String>("latefee"));
			twstatus.setCellValueFactory(new PropertyValueFactory<wearInfoTable , String>("wstatus"));
			twdes.setCellValueFactory(new PropertyValueFactory<wearInfoTable , String>("wdes"));
			wearTable.setItems(wearInfoList);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		wearTable.setItems(wearInfoList);

	}
	
	public void selectWear(){
		wearTable.setOnMouseClicked(e -> {
			wearInfoTable p= wearTable.getItems().get(wearTable.getSelectionModel().getSelectedIndex());
			txtwsearch.setText(p.getWcode());
			
		});
		}
	
	public void deleteWear(){	
		
		String wcode=null;
		int dbt = JOptionPane.showConfirmDialog(null, "Do you want to Remove this Wear ","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
		if(dbt ==0){
			JOptionPane.showMessageDialog(null,"Succesfully deleted");
			try{
				Connection c= dbconnection.mycon();
				Statement s= c.createStatement();
				ResultSet rs=s.executeQuery("Select * from wearinfo where 	itemCode='"+txtwsearch.getText()+"'");
				while(rs.next()) {
					wcode=rs.getString("itemCode");
				}
				
				String q = "DELETE FROM wearinfo WHERE itemCode = '"+txtwsearch.getText()+"'";
				
				PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
				ps.executeUpdate();
				System.out.println("bbb");	
				
			}
			catch(Exception ee){
				System.out.println(ee);
			}
			
			wearInfoList.removeAll(wearInfoList);
			wearTable.setItems(wearInfoList);
		    
		}				
			
		}

		
		
	
public void grab1(){
		
		txtwcode.requestFocus();
		
		
	}
	public void grab2(){

		
		txtwname.requestFocus();
		
		
	}	

	public void grab3(){
		
		txtwmat.requestFocus();
		
		
	}
	
public void grab4(){
		
		txtwsize.requestFocus();
		
		
	}

public void grab5(){
	
	comcat.requestFocus();
	
	
}

public void grab6(){
	
	txtwrentfee.requestFocus();
	
	
}

public void grab7(){
	
	txtwlatefee.requestFocus();
	
	
}

public void grab8(){
	
	txtwcost.requestFocus();
	
	
}

public void grab9(){
	
	txtwsupplier.requestFocus();
	
	
}

public void grab10(){
	
	txtwdes.requestFocus();
	
	
}

	
public void addWear() {
	
	
	rentWearValidation v=new rentWearValidation();

if(validation())
{	
	if(v.validateAmount(txtwlatefee.getText()) && v.validateAmount(txtwrentfee.getText()) && v.validateAmount(txtwcost.getText()))
	try{
		Connection c= dbconnection.mycon();
		Statement s= c.createStatement();
		
		s.executeUpdate("INSERT INTO wearinfo (`itemCode`, `name`, `matirial`, `category`, `size`, `rentFee`, `lateFree`, `wearCost`, `supplier`, `wearDescription`)"
				+ " VALUES ('"+txtwcode.getText()+"','"+txtwname.getText()+"','"+txtwmat.getText()+"','"+comcat.getValue().toString()+"','"+txtwsize.getText()+"',"
				+ "'"+txtwrentfee.getText()+"','"+txtwlatefee.getText()+"','"+txtwcost.getText()+"','"+txtwsupplier.getText()+"','"+txtwdes.getText()+"')");
		
		
		clearData();
		
	}
	catch (Exception e) {
	e.printStackTrace();
	
	}
	}
		
		
	
}

public void clearData() {
	
	
	txtwcode.clear();;
	txtwcost.clear();;
	txtwdes.clear();;
	txtwlatefee.clear();;
	txtwmat.clear();;
	txtwmat.clear();;
	txtwname.clear();
	txtwsupplier.clear();
	txtwrentfee.clear();
	txtwsize.clear();
	
}

	
	private Boolean validation() {
		
		if(txtwcode.getText().isEmpty() || txtwname.getText().isEmpty() || txtwmat.getText().isEmpty() || txtwsize.getText().isEmpty() || 
				txtwrentfee.getText().isEmpty() || txtwlatefee.getText().isEmpty()||txtwcost.getText().isEmpty() || txtwsupplier.getText().isEmpty()){
			
			 	JFXDialogLayout content1=new JFXDialogLayout();
			    content1.setHeading(new Text("Warning"));
			    content1.setBody(new Text("You Didn't Fill The Fields!!"+ " " + " Please Fill The Fields."));
			    JFXDialog s12=new JFXDialog(stack2,content1,JFXDialog.DialogTransition.TOP);
				JFXButton b1=new JFXButton("Okay");
				content1.setStyle("-fx-border-color:#3196de;-fx-border-radius:5px;-fx-background-color:white;-fx-border-width:2px;");
				b1.setButtonType(com.jfoenix.controls.JFXButton.ButtonType.RAISED);
				b1.setStyle("-fx-text-fill:WHITE;-fx-background-color:#3196de;-fx-background-radius:10px");
				b1.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						s12.close();
						
						}
				});
				content1.setActions(b1);
				s12.show();
	   	return false;
			
		}
		return true;
	}	}
		


