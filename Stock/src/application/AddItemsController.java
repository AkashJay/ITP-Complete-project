package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.controlsfx.control.textfield.TextFields;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;

public class AddItemsController implements Initializable{
	@FXML
	private JFXButton jbtn_edit;
	@FXML
	private TextField Jtxt_search;
	@FXML
	private JFXButton jbtn_search;
	@FXML
	private DatePicker Jdate_add;
	@FXML
	private TextField Jtxt_itemcode;
	@FXML
	private TextField Jtxt_name;
	@FXML
	private TextField Jtxt_brandid;
	@FXML
	private TextField Jtxt_sprice;
	@FXML
	private TextField Jtxt_bprice;
	@FXML
	private TextField Jtxt_quantity;
	@FXML
	private TextField Jtxt_cateogory;
	
	@FXML
	private JFXButton Jbtn_submit;
	@FXML
	private TextField Jtxt_color;
	@FXML
	private ComboBox<String> Jcombo_size;
	@FXML
	private JFXButton jbtn_home;
	@FXML
	private JFXButton Jbtn_update;
	@FXML
	private JFXListView<String> Jlist_subcat;
	
	
	ObservableList<Integer> catlist = FXCollections.observableArrayList();
	ObservableList<Integer> subcatlist = FXCollections.observableArrayList();
	ObservableList<String> sizelist = FXCollections.observableArrayList("XS","S","L","M","XL","XXL");
	ObservableList<String> sublist = FXCollections.observableArrayList();
    // Event Listener on JFXButton[#jbtn_search].onAction
	
	@FXML
    void btn_edit(ActionEvent event) throws Exception {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/edit.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
    }
		
	@FXML
	public void Jtxt_itemcode(ActionEvent e){
	String a = Jtxt_itemcode.getText();
		System.out.println(a);
		try{
			//ObservableList<String> itemlist = FXCollections.observableArrayList();
			Connection c = (Connection) DBcon.ConnerDb();
			Statement s = (Statement) c.createStatement();
			ResultSet r = s.executeQuery("select MAX(itemcode) from items where itemcode like'"+a+"%'");
			while(r.next()){
				Integer b = Integer.parseInt(r.getString(1).substring(1));
				//System.out.println(b+1);
				Jtxt_itemcode.setText(a+String.valueOf(b+1));
			}
			
			}
			catch(Exception e1){
				System.out.println(e1);
			}
		if("".equals(Jtxt_itemcode.getText()))
		{	Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("DATA ERROR");
		//alert.setHeaderText("Information Alert");
		String s ="Insert Item Id";
		alert.setContentText(s);
		alert.show();
		}
		else{
			//System.out.println(Jtxt_itemcode.getText().substring(0, 1));
		if("G".equals(Jtxt_itemcode.getText().substring(0, 1)) )
		{
			Jtxt_cateogory.setText("1");
			Jtxt_name.requestFocus();
		}
		else if("W".equals(Jtxt_itemcode.getText().substring(0, 1)))
		{
			Jtxt_cateogory.setText("2");
			Jtxt_name.requestFocus();
		}
		else if("K".equals(Jtxt_itemcode.getText().substring(0, 1)))
		{
			Jtxt_cateogory.setText("3");
			Jtxt_name.requestFocus();
		}
		else if("C".equals(Jtxt_itemcode.getText().substring(0, 1)))
		{
			Jtxt_cateogory.setText("4");
			Jtxt_name.requestFocus();
		}
		else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("DATA ERROR");
			//alert.setHeaderText("Information Alert");
			String s ="Insert valid item code";
			alert.setContentText(s);
			alert.show();
		}
		
	}}
	@FXML
	public void Jtxt_name(ActionEvent e){
		if("".equals(Jtxt_name.getText()))
		{	Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("DATA ERROR");
		//alert.setHeaderText("Information Alert");
		String s ="Insert Item name";
		alert.setContentText(s);
		alert.show();
		}		else
		Jtxt_brandid.requestFocus();
	}
	@FXML
	public void Jtxt_brandid(ActionEvent e){
		if("".equals(Jtxt_brandid.getText()))
		{	
			Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("DATA ERROR");
		//alert.setHeaderText("Information Alert");
		String s ="Insert brand ID";
		alert.setContentText(s);
		alert.show();
	}
		else
		Jtxt_bprice.requestFocus();
	}
	@FXML
	public void Jtxt_sprice(ActionEvent e){
		if("".equals(Jtxt_sprice.getText()))
		{	
			Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("DATA ERROR");
		//alert.setHeaderText("Information Alert");
		String s ="Insert selling price";
		alert.setContentText(s);
		alert.show();
	}
		if(Float.parseFloat(Jtxt_sprice.getText())<=Float.parseFloat(Jtxt_bprice.getText()))
		{	
			Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("DATA ERROR");
		//alert.setHeaderText("Information Alert");
		String s ="Buying price is greater than Selling price";
		alert.setContentText(s);
		alert.show();
	}
		Pattern pattern = Pattern.compile("([0-9]*[.])?[0-9]+");
		Matcher matcher = pattern.matcher(Jtxt_sprice.getText());
		if(!matcher.matches()){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("DATA ERROR");
			//alert.setHeaderText("Information Alert");
			String s ="Invalid Input";
			alert.setContentText(s);
			alert.show();
		}
		else
			Jtxt_quantity.requestFocus();	
	}
	@FXML
	public void Jtxt_bprice(ActionEvent e){
		if("".equals(Jtxt_bprice.getText()))
		{	
			Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("DATA ERROR");
		//alert.setHeaderText("Information Alert");
		String s ="Insert buying price";
		alert.setContentText(s);
		alert.show();
		}
			Pattern pattern = Pattern.compile("([0-9]*[.])?[0-9]+");
			Matcher matcher = pattern.matcher(Jtxt_bprice.getText());
				if(!matcher.matches()){
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("DATA ERROR");
					//alert.setHeaderText("Information Alert");
					String s ="Invalid Input";
					alert.setContentText(s);
				alert.show();
				}
		else
			Jtxt_sprice.requestFocus();	
	}
	@FXML
	public void Jtxt_quantity(ActionEvent e){
		if("".equals(Jtxt_quantity.getText()))
		{	
			Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("DATA ERROR");
		//alert.setHeaderText("Information Alert");
		String s ="Insert qunatity";
		alert.setContentText(s);
		alert.show();
	}
		Pattern pattern = Pattern.compile("([0-9]*[.])?[0-9]+");
		Matcher matcher = pattern.matcher(Jtxt_quantity.getText());
		if(!matcher.matches()){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("DATA ERROR");
			//alert.setHeaderText("Information Alert");
			String s ="Invalid Input";
			alert.setContentText(s);
			alert.show();
		}
		else
		Jtxt_color.requestFocus();
	}
	@FXML
	public void Jtxt_color(ActionEvent e){
		Jtxt_name.requestFocus();
	}
	@FXML
	public void Jcombo_size(ActionEvent e){
		Jbtn_submit.requestFocus();
	}
	@FXML
	public void btn_search(ActionEvent event) {
		// TODO Autogenerated
		if("".equals(Jtxt_search.getText()))
		{	Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("DATA ERROR");
		//alert.setHeaderText("Information Alert");
		String s ="Insert Item Id";
		alert.setContentText(s);
		alert.show();
		}
		else{
		try{
			String a=Jtxt_search.getText();
			Connection c = (Connection) DBcon.ConnerDb();
			String sql="select * from items where itemcode ='"+a+"'";
   		    PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
   		    ResultSet rs=ps.executeQuery();
   		    while(rs.next()){
   		    Jtxt_itemcode.setText(rs.getString(1));
   		    Jtxt_name.setText(rs.getString(2));
   		    Jtxt_brandid.setText(rs.getString(3));
   		    Jtxt_quantity.setText(String.valueOf(rs.getInt(4)));
   		    Jtxt_color.setText(rs.getString(7));
   		    Jtxt_bprice.setText(String.valueOf(rs.getFloat(5)));
   		    Jtxt_sprice.setText(String.valueOf(rs.getFloat(6)));
   		//    Jtxt_subcategoryid.setValue(rs.getInt(10));
   		    Jcombo_size.setValue(rs.getString(8));
   		    Jtxt_cateogory.setText(rs.getString(9));
   		    LocalDate a1 = LocalDate.parse(rs.getString(11));
           Jdate_add.setValue(a1);
   		    }
		}
		catch(Exception e){
			System.out.println(e);
		}
	}}
	
	// Event Listener on JFXButton[#Jbtn_submit].onAction
	@FXML
	public void btn_submit(ActionEvent event) {
		// TODO Autogenerated
		try{
			//System.out.println(Jtxt_itemcode.getText().substring(0, 1));
			//System.out.println(Jtxt_cateogory.getText());
    			if(Jtxt_cateogory.getText()==" " || Jdate_add.getValue()==null || " ".equals(Jtxt_itemcode)||"".equals(Jtxt_bprice)|| "".equals(Jtxt_sprice)|| "".equals(Jtxt_brandid)|| "".equals(Jtxt_quantity)|| "".equals(Jtxt_color)|| "".equals(Jdate_add)|| "".equals(Jcombo_size.getSelectionModel().toString())|| "".equals(Jtxt_name)|| validation2()){
    				Alert alert = new Alert(AlertType.WARNING);
    				alert.setTitle("DATA ERROR");
    				//alert.setHeaderText("Information Alert");
    				String s ="Please Check Inseted Data";
    				alert.setContentText(s);
    				alert.show();
    			}
    			
    			else{
    				Connection c = (Connection) DBcon.ConnerDb();
    				String sql="Insert into items values(?,?,?,?,?,?,?,?,?,?,?)";
    				PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
    				ps.setString(1, Jtxt_itemcode.getText());
    				ps.setString(2, Jtxt_name.getText());
    				ps.setString(3, Jtxt_brandid.getText());
    				ps.setInt(4, Integer.parseInt(Jtxt_quantity.getText()));
    				ps.setFloat(5, Float.parseFloat(Jtxt_bprice.getText()));
    				ps.setFloat(6, Float.parseFloat(Jtxt_sprice.getText()));
             		ps.setString(7, Jtxt_color.getText());
             		ps.setString(8,Jcombo_size.getValue().toString());
             		ps.setString(9, Jtxt_cateogory.getText());
             		ps.setInt(10, Integer.parseInt(Jlist_subcat.getSelectionModel().getSelectedItem().toString().substring(0, 1)));
             		LocalDate ld = Jdate_add.getValue();
             		ps.setString(11, ld.toString());
                        
             		int i=ps.executeUpdate();
             		if(i>0){
             			Alert alert = new Alert(AlertType.INFORMATION);
             			alert.setTitle("DATA ENTER");
             			//alert.setHeaderText("Information Alert");
             			String s ="Insert Succesfull";
             			alert.setContentText(s);
             			alert.show();
//            			 clear();
             		}
             		else{   
             			Alert alert = new Alert(AlertType.ERROR);
             			alert.setTitle("DATA ENTER");
             			//alert.setHeaderText("Information Alert");
             			String s ="Insert UNSuccesfull";
             			alert.setContentText(s);
             			alert.show();
//             			 clear();
                     }
             		c.close();
             		clear();
    		}
		}
    	catch(Exception e){
    		
    			try{
    				if(Jtxt_cateogory.getText()==" " || Jdate_add.getValue()==null || " ".equals(Jtxt_itemcode)||"".equals(Jtxt_bprice)|| "".equals(Jtxt_sprice)|| "".equals(Jtxt_brandid)|| "".equals(Jtxt_quantity)|| "".equals(Jtxt_color)|| "".equals(Jdate_add)|| "".equals(Jcombo_size.getSelectionModel().toString())|| "".equals(Jtxt_name)|| validation2()){
        			Alert alert = new Alert(AlertType.WARNING);
        			alert.setTitle("DATA ERROR");
        			//alert.setHeaderText("Information Alert");
        			String s ="Please insert Category ID & Sub Category ID Date";
        			alert.setContentText(s);
        			alert.show();}
    				
        		
    			{
    				
    				
    				Connection c = (Connection) DBcon.ConnerDb();
    				String code = Jtxt_itemcode.getText();
    				String sql="Update items set itemname=?, brandid=?, quantity=?, buyingprice=?, sellingprice=?, color=?, size=? where itemcode='"+code+"'";
    				PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
    				ps.setString(1, Jtxt_name.getText());
    				ps.setString(2, Jtxt_brandid.getText());
    				ps.setInt(3, Integer.parseInt(Jtxt_quantity.getText()));
    				ps.setFloat(4, Float.parseFloat(Jtxt_bprice.getText()));
    				ps.setFloat(5, Float.parseFloat(Jtxt_sprice.getText()));
    				ps.setString(6, Jtxt_color.getText());
    				ps.setString(7,Jcombo_size.getValue().toString());
    		//		ps.setInt(8, Jtxt_cateogory.getValue());
    			//	ps.setInt(9, Integer.parseInt(Jlist_subcat.getSelectionModel().getSelectedItem().toString().substring(0, 1)));
    			//	LocalDate ld = Jdate_add.getValue();
            	//	ps.setString(11, ld.toString());
            
    				int i=ps.executeUpdate();
    				if(i>0){
    					
    					Alert alert = new Alert(AlertType.INFORMATION);
    					alert.setTitle("INFORMARTION");
    					//alert.setHeaderText("Information Alert");
    					String s ="Update Succesfull";
    					alert.setContentText(s);
    					alert.show();        		clear();
    				}
    				else{   
    					Alert alert = new Alert(AlertType.ERROR);
    					alert.setTitle("ERROR");
    					//alert.setHeaderText("Information Alert");
    					String s ="Update Cannot perform";
            			alert.setContentText(s);
            			alert.show();
                    }
    				Alert alert1 = new Alert(AlertType.WARNING);
    				alert1.setTitle("DATA ERROR");
    				//alert.setHeaderText("Information Alert");
    				String s1 ="You have this record! \t  Update";
    				alert1.setContentText(s1);
    				alert1.show();
					
    				
    				c.close();
    				clear();
    				}
    			}
    		catch(Exception e1){
    			System.err.println(e1);
    		}
    	}
	}
	
	// Event Listener on JFXButton[#jbtn_home].onAction
	@FXML
	public void btn_home(ActionEvent event) throws Exception {
		// TODO Autogenerated
		((Node)event.getSource()).getScene().getWindow().hide();
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/*@FXML
	void btn_update(ActionEvent event) {
		try{
			if(Integer.parseInt(Jlist_subcat.getSelectionModel().getSelectedItem().toString().substring(0, 1))==0 &&  Jtxt_cateogory.getValue()==0 && Jdate_add.getValue()==null && "".equals(Jtxt_itemcode)&&"".equals(Jtxt_bprice)&& "".equals(Jtxt_sprice)){
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("DATA ERROR");
    			//alert.setHeaderText("Information Alert");
    			String s ="Please insert Category ID & Sub Category ID Date";
    			alert.setContentText(s);
    			alert.show();
    		}
			else{
			Connection c = (Connection) DBcon.ConnerDb();
			String code = Jtxt_itemcode.getText();
			String sql="Update items set itemname=?, brandid=?, quantity=?, buyingprice=?, sellingprice=?, color=?, size=?,  categoryid=?, subcategoryid=? where itemcode='"+code+"'";
			PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
			ps.setString(1, Jtxt_name.getText());
			ps.setString(2, Jtxt_brandid.getText());
			ps.setInt(3, Integer.parseInt(Jtxt_quantity.getText()));
			ps.setFloat(4, Float.parseFloat(Jtxt_bprice.getText()));
			ps.setFloat(5, Float.parseFloat(Jtxt_sprice.getText()));
			ps.setString(6, Jtxt_color.getText());
			ps.setString(7,Jcombo_size.getValue().toString());
			ps.setInt(8, Jtxt_cateogory.getValue());
			ps.setInt(9, Integer.parseInt(Jlist_subcat.getSelectionModel().getSelectedItem().toString().substring(0, 1)));
			//LocalDate ld = Jdate_add.getValue();
        	//ps.setString(11, ld.toString());
        
        int i=ps.executeUpdate();
        if(i>0){
        	 Alert alert = new Alert(AlertType.INFORMATION);
       		alert.setTitle("INFORMARTION");
       		//alert.setHeaderText("Information Alert");
       		String s ="Update Succesfull";
       		alert.setContentText(s);
       		alert.show();        		clear();
        }
        else{   
        	 Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("ERROR");
        		//alert.setHeaderText("Information Alert");
        		String s ="Update Cannot perform";
        		alert.setContentText(s);
        		alert.show();
                }
        	c.close();
        	clear();
		}}
		catch(Exception e){
			System.err.println(e);
		}
	}*/
	
	
	
	public void addvaluetocatcombo(){
	try{	
		Connection c = (Connection) DBcon.ConnerDb();
		String q = "select * from category" ;
		PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			catlist.add(rs.getInt(1));	
		}
		rs.close();
	}
	catch(Exception e){
		System.err.println(e);	
		}	
	}

	public void addvaluetosubcatcombo(){
	try{	
		Connection c = (Connection) DBcon.ConnerDb();
		String q = "select * from subcategory" ;
		PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			subcatlist.add(rs.getInt(1));	
		}
		rs.close();
	}
	catch(Exception e){
		System.err.println(e);	
		}	
	}
	
	public void addvaluestolist(){
		try{
			Connection c = (Connection) DBcon.ConnerDb();
			String q = "select * from subcategory" ;
			PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				sublist.add(Integer.toString(rs.getInt(1))+" - "+rs.getString(2));	
			}
			rs.close();
		}
		catch(Exception e){
			System.err.println(e);	
		}	
	}
	
	public void search() throws SQLException{
		try{
		ObservableList<String> data = FXCollections.observableArrayList();
		Connection c = (Connection) DBcon.ConnerDb();
		Statement s = (Statement) c.createStatement();
		ResultSet r = s.executeQuery("select * from items");
		while(r.next()){
			data.add(r.getString(1));
		}
		TextFields.bindAutoCompletion(Jtxt_search,data);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	private Boolean validation2(){
	
			Pattern pattern = Pattern.compile("([0-9]*[.])?[0-9]+");
			Matcher matcher1 = pattern.matcher(Jtxt_bprice.getText());
			Matcher matcher2 = pattern.matcher(Jtxt_sprice.getText());
			Matcher matcher3 = pattern.matcher(Jtxt_quantity.getText());
				if(!matcher1.matches()||!matcher2.matches()||!matcher3.matches()){
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("DATA ERROR");
					//alert.setHeaderText("Information Alert");
					String s ="Invalid Input";
					alert.setContentText(s);
				alert.show();
		return true;
				}
	else
	 return false;
	
	
	}
	public void clear()
	{
		Jtxt_itemcode.setText("");
		Jtxt_name.setText("");
		Jtxt_brandid.setText("");
		Jtxt_quantity.setText("");
		Jtxt_color.setText("");
		Jtxt_bprice.setText("");
		Jtxt_sprice.setText("");
		//Jtxt_subcategoryid.setValue(null);
		Jcombo_size.setValue(null);
		Jtxt_cateogory.setText("");
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Jcombo_size.setValue("");
		Jtxt_cateogory.setText("");
		//Jtxt_subcategoryid.setValue(0);
		Jdate_add.setValue(null);
		Jtxt_itemcode.setText("");
		Jtxt_name.setText("");
		Jtxt_brandid.setText("");
		Jtxt_quantity.setText("");
		Jtxt_color.setText("");
		Jtxt_bprice.setText("");
		Jtxt_sprice.setText("");
		// TODO Auto-generated method stub
		//Jtxt_cateogory.setItems(catlist);
	//	Jtxt_subcategoryid.setItems(subcatlist);
		addvaluetocatcombo();
		
		addvaluetosubcatcombo();
		
		Jcombo_size.setItems(sizelist);
		Jlist_subcat.setItems(sublist);
		addvaluestolist();
		addvaluetocatcombo();
		
		try {
			search();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try{
			ObservableList<String> datab = FXCollections.observableArrayList();
			Connection c = (Connection) DBcon.ConnerDb();
			Statement s = (Statement) c.createStatement();
			ResultSet r = s.executeQuery("select * from brand");
			while(r.next()){
				datab.add(r.getString(1));
			}
			TextFields.bindAutoCompletion(Jtxt_brandid,datab);
			}
			catch(Exception e){
				System.out.println(e);
			}
	
		
		
	
		
		}
	
}