package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;
import com.teknikindustries.bulksms.SMS;

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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.rentWearValidation;

public class rentWearsController implements Initializable {

	   @FXML
	    private Label invoiceno;

	    @FXML
	    private JFXTextField txtwcode;

	    @FXML
	    private JFXTextField txtwname;

	    @FXML
	    private JFXTextField txtwcat;

	    @FXML
	    private JFXTextField txtwsize;

	    @FXML
	    private JFXTextField txtcname;

	    @FXML
	    private JFXTextField txtcmobile;

	    @FXML
	    private JFXTextField txtdepNo;

	    @FXML
	    private JFXTextField txtdepamount;

	    @FXML
	    private JFXTextField txtcemail;

	    @FXML
	    private JFXDatePicker txthdate;

	    @FXML
	    private JFXDatePicker txtrdate;

	    @FXML
	    private JFXTextField txtamount;

	    @FXML
	    private JFXRadioButton radionic;


	    @FXML
	    private JFXRadioButton radiopass;

	    @FXML
	    private JFXRadioButton radiolic;
	    
	    @FXML
	    private JFXButton buttonpay;

	    @FXML
	    private JFXButton buttonclear;
	    
	    private String deposit;
	    
	    @FXML
	    private Tab damagewear;
	    
	    @FXML
	    private StackPane stack1;
	    
	    @FXML
	    private JFXTextField txtsearch1;

	    
	   //return interface variables
	    
	    @FXML
	    private JFXTextField txtrinvoiceno;

	    @FXML
	    private JFXTextField txtrcname;

	    @FXML
	    private JFXTextField txtrcmobile;

	    @FXML
	    private JFXTextField txtrwcode;

	    @FXML
	    private JFXTextField txtrwname;

	    @FXML
	    private JFXTextField txtrwcat;

	    @FXML
	    private JFXTextField txtrcnicno;

	    @FXML
	    private JFXDatePicker rreturndate;

	    @FXML
	    private JFXDatePicker rhiredate;

	    @FXML
	    private JFXTextField txtrlateday;

	    @FXML
	    private JFXTextField txtrlatefee;

	    @FXML
	    private JFXTextField txtrdamount;

	    @FXML
	    private JFXCheckBox rcheckdep;

	    @FXML
	    private JFXCheckBox rchecknic;

	    @FXML
	    private JFXRadioButton rdamage;

	    @FXML
	    private JFXRadioButton rnodamge;
	    @FXML
	    private JFXTextField txtrdamage;

	    @FXML
	    private JFXTextField txtrrenewl;
	    
	    private String damage;
	    
	    private String latefee;
	    
	    @FXML
	    private StackPane stack;
	    private String phone=null;
	    
	    @FXML
	    private JFXRadioButton rNotReturn;
	    
	    @FXML
	    private JFXRadioButton rReturn;
	    
	    private String dd;
	    private String dd2;
		
	    
	    
	//table colum varibles--------------------------------------
	  
	    
	    @FXML
	    private TableView<OnHireTable> onHireDetails;

	    @FXML
	    private TableColumn<OnHireTable , String > tinvno;

	    @FXML
	    private TableColumn<OnHireTable , String > tcname;

	    @FXML
	    private TableColumn<OnHireTable , String > tcnic;

	    @FXML
	    private TableColumn<OnHireTable , String > tcmobile;

	    @FXML
	    private TableColumn<OnHireTable , String > twcode;


	    @FXML
	    private TableColumn<OnHireTable , String > thdate;
	    
	    @FXML
	    private TableColumn<OnHireTable , String > trdate;
	    
	    public ObservableList<OnHireTable> hireDetailList= FXCollections.observableArrayList();
	    
	    
	    @FXML
	    private JFXTextField txtsearch;
	    
 // damage table column variable
	    
	    @FXML
	    private TableView<damageWearTable> damageTable;
	    
	    @FXML
	    private TableColumn<damageWearTable, String> daminvNo;

	    @FXML
	    private TableColumn<damageWearTable, String> damWcode;

	    @FXML
	    private TableColumn<damageWearTable, String> damStatus;

	    @FXML
	    private TableColumn<damageWearTable, String> damAmount;

	    @FXML
	    private TableColumn<damageWearTable, String> damDate;
	    
	    public ObservableList<damageWearTable> damageDetailList= FXCollections.observableArrayList();

	    
	    
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		grabFocus();
		grabFocus2(); 
		grab3();
		invoice();
		radiodamage();
		tabellord1();
		cancelOrder();
		cancelOrder1();
		damageTableLord() ;
		//day();
	}	
	
	
	
	
	public void tabellord1() {
		
		try {
			
			Connection c= dbconnection.mycon();
			//Statement s= c.createStatement();
			
			ResultSet rs=c.createStatement().executeQuery("select * from hiredetails");
			while(rs.next()){
				hireDetailList.add(new OnHireTable(rs.getString(1),rs.getString(3),rs.getString(7),rs.getString(4),rs.getString(2),rs.getString(9),rs.getString(10)));
				
				
				

			}
			tinvno.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("invNo"));
			tcname.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("cname"));
			tcnic.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("cnic"));
			tcmobile.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("cmobile"));
			twcode.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("wcode"));
			thdate.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("hdate"));
			trdate.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("rdate"));
			onHireDetails.setItems(hireDetailList);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	//	onHireDetails.setItems(hireDetailList);

	}
	
	
	public void addReturnTableValues() {
		int a=0;
		
		hireDetailList.removeAll(hireDetailList);
		onHireDetails.setItems(hireDetailList);
		
		
		
try {
			
			Connection c= dbconnection.mycon();
			//Statement s= c.createStatement();
			
			ResultSet rs=c.createStatement().executeQuery("select * from hiredetails where `status`='"+a+"'");
			while(rs.next()){
				hireDetailList.add(new OnHireTable(rs.getString(1),rs.getString(3),rs.getString(7),rs.getString(4),rs.getString(2),rs.getString(9),rs.getString(10)));
				
				
				

			}
			tinvno.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("invNo"));
			tcname.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("cname"));
			tcnic.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("cnic"));
			tcmobile.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("cmobile"));
			twcode.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("wcode"));
			thdate.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("hdate"));
			trdate.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("rdate"));
		
			onHireDetails.setItems(hireDetailList);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	
	
	public void addNotReturnTableValues() {
		int a=1;
		
		hireDetailList.removeAll(hireDetailList);
		onHireDetails.setItems(hireDetailList);
		
		
		
try {
			
			Connection c= dbconnection.mycon();
			//Statement s= c.createStatement();
			
			ResultSet rs=c.createStatement().executeQuery("select * from hiredetails where `status`='"+a+"'");
			while(rs.next()){
				hireDetailList.add(new OnHireTable(rs.getString(1),rs.getString(3),rs.getString(7),rs.getString(4),rs.getString(2),rs.getString(9),rs.getString(10)));
				
				
				

			}
			tinvno.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("invNo"));
			tcname.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("cname"));
			tcnic.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("cnic"));
			tcmobile.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("cmobile"));
			twcode.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("wcode"));
			thdate.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("hdate"));
			trdate.setCellValueFactory(new PropertyValueFactory<OnHireTable , String>("rdate"));
		
			onHireDetails.setItems(hireDetailList);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
		
	public void cancelOrder(){
		onHireDetails.setOnMouseClicked(e -> {
			OnHireTable p= onHireDetails.getItems().get(onHireDetails.getSelectionModel().getSelectedIndex());
			txtsearch.setText(p.getInvNo());
			
		});
		}		
	

			
	public void btncancel(){	
		
			String wcode=null;
			int dbt = JOptionPane.showConfirmDialog(null, "Do you want to delete this data ","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
			if(dbt ==0){
				JOptionPane.showMessageDialog(null,"Succesfully deleted");
				try{
					Connection c= dbconnection.mycon();
					Statement s= c.createStatement();
					ResultSet rs=s.executeQuery("Select * from hiredetails where invoiceNo='"+txtsearch.getText()+"'");
					while(rs.next()) {
						wcode=rs.getString("itemCode");
					}
					s.executeUpdate("UPDATE wearinfo SET status='1' where itemCode='"+wcode+"'");
					String q = "DELETE FROM hiredetails WHERE invoiceNo = '"+txtsearch.getText()+"'";
					
					PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
					ps.executeUpdate();
					System.out.println("bbb");	
					
				}
				catch(Exception ee){
					System.out.println(ee);
				}
				
				hireDetailList.removeAll(hireDetailList);
				onHireDetails.setItems(hireDetailList);
			    
			}				
				
			}

public void damageTableLord() {
		
		try {
			
			Connection c= dbconnection.mycon();
			//Statement s= c.createStatement();
			
			ResultSet rs=c.createStatement().executeQuery("SELECT * FROM damage");
			while(rs.next()){
				damageDetailList.add(new damageWearTable(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
				
				
				

			}
			daminvNo.setCellValueFactory(new PropertyValueFactory<damageWearTable , String>("invNo"));
			damWcode.setCellValueFactory(new PropertyValueFactory<damageWearTable , String>("wcode"));
    		damStatus.setCellValueFactory(new PropertyValueFactory<damageWearTable , String>("damage"));
			damAmount.setCellValueFactory(new PropertyValueFactory<damageWearTable , String>("renewl"));
			damDate.setCellValueFactory(new PropertyValueFactory<damageWearTable , String>("date"));
			
			damageTable.setItems(damageDetailList);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	

	}

	public void cancelOrder1(){
	damageTable.setOnMouseClicked(e -> {
		damageWearTable p= damageTable.getItems().get(damageTable.getSelectionModel().getSelectedIndex());
		txtsearch1.setText(p.getWcode());
		
	});
	}
	
	public void damagereturn() {
		
		
		int dbt = JOptionPane.showConfirmDialog(null, "Is Damage Return Is Okay","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
		if(dbt ==0){
			JOptionPane.showMessageDialog(null,"Succesfully return!!!!");
			
			try{
				Connection c= dbconnection.mycon();
				Statement s= c.createStatement();
				s.executeUpdate("DELETE FROM damage WHERE itemCode = '"+txtsearch1.getText()+"'");
				s.executeUpdate("UPDATE wearinfo SET status='1' where itemCode='"+txtsearch1.getText()+"'");
				
				
			}
			catch(Exception ee){
				System.out.println(ee);
			}
			
			damageDetailList.removeAll(damageDetailList);
			damageTable.setItems(damageDetailList);
		}
		
	}
	
		
	
	
	public void main(javafx.event.ActionEvent e) {
		
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
	

// Prepared Hire Interface code segment.....
	
	public void  grabFocus() {
		
		
		
		txtwcode.setOnKeyPressed(e->{
			
			if(e.getCode()==KeyCode.ENTER){
				String status=null;
				int stat=0;
				String amount=null;
				int amo=0;
				
				try {
					rentWearValidation v= new rentWearValidation();
					
					if(v.checkWear(txtwcode.getText())){
					Connection c= dbconnection.mycon();
					Statement s= c.createStatement();
					
					ResultSet rs= s.executeQuery("select * from wearinfo where itemCode='"+txtwcode.getText()+"'");
					
					while(rs.next()){
					 
						txtwname.setText(rs.getString("name"));
						txtwcat.setText(rs.getString("category"));
						txtwsize.setText(rs.getString("size"));
						txtamount.setText(rs.getString("rentFee"));
						status=rs.getString("status");
						stat=Integer.parseInt(status);
						if(stat==0) {
							System.out.println("aa");
							Alert a1=new Alert(AlertType.WARNING);
					    	a1.setHeaderText(null);
					    	//a1.initStyle(StageStyle.UNDECORATED);
					    	a1.setContentText("wear doesn,t exsist");  
					    	a1.showAndWait();
					    	clearData();
						}
						txtcname.requestFocus();				
					}
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
			
		});
		
	}

	public void grab1(){
		
		txtcmobile.requestFocus();
		
		
	}
	public void grab2(){
		
		txtcemail.requestFocus();
		
		
	}
	
	
	public void grab9(){
		
		radionic.setSelected(true);
		radionic.requestFocus();
		
		
	}
	
	
	public void grab3(){
		
		radionic.setOnKeyPressed(e->{
			
			if(e.getCode()==KeyCode.ENTER){
						
				deposit= radionic.getText();
				txtdepNo.requestFocus();	
				
			}
			
});	
		radiopass.setOnKeyPressed(e->{
			
			if(e.getCode()==KeyCode.ENTER){
				
				deposit= radiopass.getText();		
				txtdepNo.requestFocus();	
				
			}
			
});
		radiolic.setOnKeyPressed(e->{
			
			if(e.getCode()==KeyCode.ENTER){
				
				deposit= radiolic.getText();		
				txtdepNo.requestFocus();	
				
			}
		});		
}
	
	
	
	public void grab4(){
		
		txtdepNo.requestFocus();
		
		
	}
	
	
	public void grab5(){
		
		txtdepamount.requestFocus();
		
		
	}
	
	public void grab6(){
		
		txthdate.requestFocus();
		
		
	}
	
		
	public void grab7(){
		
		txtrdate.requestFocus();
		
		
	}
	
	public void grab8(){
		
		txtamount.requestFocus();
		
		
	}
	
	public void invoice(){
		
		double x= 0;
		x=Math.random()*10000;
		DecimalFormat d1= new DecimalFormat("#");
		int y= Integer.parseInt(d1.format(x));
		
		String inv= "INV"+Integer.toString(y);
		
		invoiceno.setText(inv);
		
		
		
	}
	
	
	public void pay() {
		int buyers=0;
		double incm=0;
		rentWearValidation v=new rentWearValidation();
		
		if(validation())
		{	
			if(v.nameEmpty(txtcname.getText()) && v.name(txtcname.getText())  && v.email(txtcemail.getText()) && v.validatePhone(txtcmobile.getText()) && v.datecompaire(txthdate.getValue(), txtrdate.getValue()) && v.validateAmount(txtdepamount.getText()) && v.nic(txtdepNo.getText())){
			
			try{
				Connection c= dbconnection.mycon();
				Statement s= c.createStatement();
				ResultSet rs= s.executeQuery("select * from wearinfo where itemCode='"+txtwcode.getText()+"'");
				while(rs.next()) {
					buyers=Integer.parseInt(rs.getString("noOfBuyers"));
					incm=Double.parseDouble(rs.getString("income"));
					buyers=buyers+1;
					incm=incm+Double.parseDouble(txtamount.getText());
				}
				
				s.executeUpdate("INSERT INTO `hiredetails`(`invoiceNo`, `itemCode`, `cName`, `cMobile`, `cEmail`, `deposit`, `depositNo`, `depmount`, `hireDate`, `returnDate`, `amount`,`status`) VALUES ('"+invoiceno.getText()+"','"+txtwcode.getText()+"','"+txtcname.getText()+"','"+txtcmobile.getText()+"','"+txtcemail.getText()+"','"+deposit+"','"+txtdepNo.getText()+"','"+txtdepamount.getText()+"','"+txthdate.getValue()+"','"+txtrdate.getValue()+"','"+txtamount.getText()+"','1')");
				s.executeUpdate("UPDATE `wearinfo` SET status='0',noOfBuyers='"+buyers+"',income='"+incm+"'  where itemCode='"+txtwcode.getText()+"'");
				
				openBill();
				clearData();
				invoice();
				
				
				
				
				
			}
			catch (Exception e1) {
				System.out.println(e1);
				
			}
		}
				
				
				
			
			
		}
		
	}
	
	public void clearData(){
		
			
		txtwcode.clear();
		txtcname.clear();
		txtamount.clear();
		txtcemail.clear();
		txtcmobile.clear();
		txtdepamount.clear();
		txtdepNo.clear();
		txthdate.setValue(null);
		txtrdate.setValue(null);
		txtwcat.clear();
		txtwcode.clear();
		txtwname.clear();
		txtwsize.clear();
		radiolic.setSelected(false);
		radionic.setSelected(false);
		radiopass.setSelected(false);
		
		
		 
	}
	
	
	
	
	public void openBill(){
    	try {
			//Open the home window
    		FXMLLoader fxmloder=new FXMLLoader(getClass().getResource("/application/CustomerBill.fxml"));
			Parent root1=(Parent) fxmloder.load();
			
			Stage stage =new Stage();
			//stage.initStyle(StageStyle.TRANSPARENT);
			//stage.setMaximized(true);
			stage.setScene(new Scene(root1));
			stage.show();
		
			((CustomerBillController)fxmloder.getController()).setLetter(invoiceno.getText());;
			
			
			//Close the current window(call above method)
			//close();
			
			
			
			
		} catch(Exception e1) {
			e1.printStackTrace();
		}
    	
    }
    
	
// end Prepared Hire interface code segment
	//------------------------------------------------------------------------------------------------------------------------------
	
// start return wear interface
		
public void  grabFocus2() {
		
		txtrinvoiceno.setOnKeyPressed(e->{
			
			if(e.getCode()==KeyCode.ENTER){
				
				try {
					
					rentWearValidation v=new rentWearValidation();
					
					if(v.checInvoice(txtrinvoiceno.getText())){
						
					
					Connection c1= dbconnection.mycon();
					Statement s= c1.createStatement();
					
					ResultSet rs= s.executeQuery("SELECT  * FROM hiredetails WHERE invoiceNo='"+txtrinvoiceno.getText()+"'");
					
					
					if(rs.next()){
						
						txtrwcode.setText(rs.getString("itemCode"));
						txtrcname.setText(rs.getString("cName"));
						txtrcmobile.setText(rs.getString("cMobile"));
						txtrdamount.setText(rs.getString("depmount"));
						LocalDate hiredate= LocalDate.parse(rs.getString("hireDate"));
						rhiredate.setValue(hiredate);
						LocalDate returndate= LocalDate.parse(rs.getString("returnDate"));
						String retrun=rs.getString("returnDate");
						rreturndate.setValue(returndate);
						
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						Date dd12 = new Date();
						String date = dateFormat.format(dd12);
						
						String[] ss=retrun.split("-");
						String[] ss1=date.split("-");
						
						
						int day =Integer.parseInt(ss[2]);
						int month = Integer.parseInt(ss[1]);
						
						int day1 = Integer.parseInt(ss1[2]);
						int month1 = Integer.parseInt(ss[1]);
						
						int sum=(month1-month)+(day1-day);
						
						if (sum>0){
							String sum11=Integer.toString(sum);
							txtrlateday.setText(sum11);
							
						}
						else{
						
						txtrlateday.setText("0");
						}
						//day();
						
										
					}
					autofill();
					rnodamge.requestFocus();
					rnodamge.setSelected(true);
					txtrdamage.setDisable(true);
					txtrrenewl.setDisable(true);
					
				
				
					}	
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
			}
			
		});
		
	}

	public void autofill() {
		
	
		
		try {
			
			Connection c1= dbconnection.mycon();
			Statement s= c1.createStatement();
			
			
			
			ResultSet rs1= s.executeQuery("SELECT * FROM wearinfo WHERE itemCode='"+txtrwcode.getText()+"'");
			
			
			
			if(rs1.next()){
				 
				System.out.println();
				txtrwname.setText(rs1.getString("name"));
				txtrwcat.setText(rs1.getString("category"));
				//txtrlatefee.setText(rs1.getString("lateFree"));	
				String ss=rs1.getString("lateFree");
				double return1=Double.parseDouble(ss);
				int day=Integer.parseInt(txtrlateday.getText());
				double sum=return1*day;
				txtrlatefee.setText(Double.toString(sum));
				
			
			}
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
public void radiodamage(){
		
	rnodamge.setOnKeyPressed(e->{
			
			if(e.getCode()==KeyCode.ENTER){
				
				txtrdamage.setDisable(true);
				txtrrenewl.setDisable(true);
						
			
					
				
			}
			
});	
		rdamage.setOnKeyPressed(e->{
			
			if(e.getCode()==KeyCode.ENTER){
				
				txtrdamage.setDisable(false);
				txtrrenewl.setDisable(false);
			
		
				
				
				
			}
			
});
		
	
}	

public void radioMouseClick(ActionEvent e){
	
	txtrdamage.setDisable(true);
	txtrrenewl.setDisable(true);
			
	
	

}

public void radioMouseClick2(ActionEvent e){
	
	txtrdamage.setDisable(false);
	txtrrenewl.setDisable(false);
	txtrdamage.requestFocus();	
			
	

}

public void grab10(){
	
	txtrrenewl.requestFocus();
	
	
}


public void insertSuccessfullReturnData(){
	
	
		
	try{
		
		
		
		Connection c= dbconnection.mycon();
		Statement s= c.createStatement();
		
		
		
		if(rnodamge.isSelected()){
			
			
			
			Alert a1=new Alert(AlertType.CONFIRMATION);
	    	a1.setHeaderText(null);
	    	a1.initStyle(StageStyle.UNDECORATED);
	    	a1.setContentText("Return Is successfully?");
	    	a1.getDialogPane().getStylesheets().add(getClass().getResource("/application/alert.css").toExternalForm());
	    	Optional<ButtonType>aa=a1.showAndWait();
	    	System.out.println("a3");
	    	if(aa.get() == ButtonType.OK){
	    		s.executeUpdate("UPDATE `wearinfo` SET status='1' where itemCode='"+txtrwcode.getText()+"'");
	
			s.executeUpdate("UPDATE hiredetails SET lateDays='"+txtrlateday.getText()+"',latefee='"+txtrlatefee.getText()+"',status='0' WHERE invoiceNo='"+txtrinvoiceno.getText()+"'");
		
			
			
			
			clearReturnInfData();
	    	}
			
		}
		else if(rdamage.isSelected()){
				
				JFXDialogLayout content1=new JFXDialogLayout();
				content1.setHeading(new Text("Confirmation"));
				content1.setBody(new Text("If Wear Has Any Damage Can't Return successfully!!!"));
				JFXDialog s12=new JFXDialog(stack,content1,JFXDialog.DialogTransition.TOP);
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
		}
		
		
		
		
		
		
		
	}
	catch (Exception e1) {
		System.out.println(e1);
		
	}

		
		}	
	
	



public void insertDamageReturnData(){
	
	rentWearValidation v=new rentWearValidation();
	
		
		
		
	
	try{
		Connection c= dbconnection.mycon();
		Statement s= c.createStatement();
		
		
		if(rdamage.isSelected()){
			
			if(v.validateAmount(txtrrenewl.getText())){
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date dd12 = new Date();
				String date = dateFormat.format(dd12);
				
				s.executeUpdate("INSERT INTO `damage`(`invoiceNo`, `itemCode`, `damageDesc`, `renewlAmount`, `date`) VALUES ('"+txtrinvoiceno.getText()+"', '"+txtwcode.getText()+"', '"+txtrdamage.getText()+"', '"+txtrrenewl.getText()+"', '"+date+"')");
			
			Alert a1=new Alert(AlertType.CONFIRMATION);
	    	a1.setHeaderText(null);
	    	a1.initStyle(StageStyle.UNDECORATED);
	    	a1.setContentText("Return Has Damage?");
	    	a1.getDialogPane().getStylesheets().add(getClass().getResource("/application/alert.css").toExternalForm());
	    	Optional<ButtonType>aa=a1.showAndWait();
	    	
			s.executeUpdate("UPDATE hiredetails SET status='0' WHERE invoiceNo='"+txtrinvoiceno.getText()+"'");
			
			
			clearReturnInfData();
			}
			
		}
		else if(rnodamge.isSelected()){
			
			 JFXDialogLayout content1=new JFXDialogLayout();
  		   content1.setHeading(new Text("Confirmation"));
  		   content1.setBody(new Text("Wear Has No Damages Pleease Return successfull!!!"));
  		   JFXDialog s12=new JFXDialog(stack,content1,JFXDialog.DialogTransition.TOP);
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
		}
			
	}
	catch (Exception e1) {
		System.out.println(e1);
		System.out.println("dsgsssssssssssssssssssssssssssssssss");
	
	}
		}
	






public void clearReturnInfData() {
	
	txtrinvoiceno.clear();;
	txtrcname.clear();;
	txtrcmobile.clear();;
	txtrwcode.clear();;
	txtrwname.clear();;
	txtrwcat.clear();;
	txtrcnicno.clear();
	rreturndate.setValue(null);
	rhiredate.setValue(null);
	txtrlateday.clear();
	txtrlatefee.clear();
	txtrdamount.clear();
	rdamage.setSelected(false);
	rnodamge.setSelected(false);
	txtrdamage.clear();
	txtrrenewl.clear();

	
	
}

//-------------------------------------------------------------------------------------
//interface 3 onHireDetails




//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//interface one validation

private Boolean validation() {
	
	if(txtwcode.getText().isEmpty() || txtwname.getText().isEmpty() || txtwcat.getText().isEmpty() || txtwsize.getText().isEmpty() || 
			 txtcname.getText().isEmpty() || txtcmobile.getText().isEmpty()||txtcemail.getText().isEmpty() || txtdepNo.getText().isEmpty() || txtdepamount.getText().isEmpty()|| txtamount.getText().isEmpty()
			 || txthdate.getValue()==null || txtrdate.getValue()==null  ){
		
		 	JFXDialogLayout content1=new JFXDialogLayout();
		    content1.setHeading(new Text("Warning"));
		    content1.setBody(new Text("You Didn't Fill The Fields!!"+ " " + " Please Fill The Fields."));
		    JFXDialog s12=new JFXDialog(stack1,content1,JFXDialog.DialogTransition.TOP);
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
	
	
	
	
	    else if(!(radiolic.isSelected() || radionic.isSelected() || radiopass.isSelected())){
		
		 JFXDialogLayout content1=new JFXDialogLayout();
		    content1.setHeading(new Text("Warning"));
		    content1.setBody(new Text("You Didn't Choose a Gender!!"+ " " + " Please Select The Gender."));
		    JFXDialog s12=new JFXDialog(stack,content1,JFXDialog.DialogTransition.TOP);
			JFXButton b1=new JFXButton("Okay");
			content1.setStyle("-fx-border-color:#3196de;-fx-border-radius:5px;-fx-background-color:white;-fx-border-width:2px;");
			b1.setButtonType(com.jfoenix.controls.JFXButton.ButtonType.RAISED);
			b1.setStyle("-fx-text-fill:WHITE;-fx-background-color:#3196de;-fx-background-radius:10px");
			b1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				s12.close();
				radiolic.requestFocus();
				}
			});
			content1.setActions(b1);
			s12.show();
		return false;
	}
	return true;
	
}

public void send(){
	
	try{
		Connection c= dbconnection.mycon();
		Statement s= c.createStatement();
		
		ResultSet rs=s.executeQuery("SELECT * FROM `hiredetails` WHERE invoiceNo='"+txtsearch.getText()+"'");
		
		while(rs.next()){
			
			
			
			
			phone=rs.getString("cMobile");
				sms("Return Date of wear has Exceed.\nPlease Return It quickly.", phone);
			System.out.println(phone);
			
			Alert a1=new Alert(AlertType.WARNING);
				    	a1.setHeaderText(null);
				    	//a1.initStyle(StageStyle.UNDECORATED);
				    	a1.setContentText("Alert Is Send Succsesfully ("+phone+") ");  
		   	    	a1.showAndWait();
		}
		
	}
	catch(Exception ee){
		System.out.println(ee);
	}
	
	
	
	
}

//*************************Send SMS*************************
	 public void sms(String msg,String number) {
		 int a=2;
		 char no[]=new char[11];
		 no[0]='9';
		 no[1]='4';
		 
		 for(int i=1;i<number.length();i++){
			 
			 no[a]=number.charAt(i);
			 a++;
		 }
		 String num=String.valueOf(no);
		
		 
		try {
			 SMS sms=new SMS();
			 sms.SendSMS("dressmo99 ", "shalika93", msg, num, "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
			
			
			
		} catch (Exception e2) {
			System.out.println(e2);
			
		}
	}
	
}




