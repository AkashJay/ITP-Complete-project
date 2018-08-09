package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;

public class ViewStockController implements Initializable{
	
	ObservableList<Tablestock> list1 = FXCollections.observableArrayList();
	ObservableList<Tablestock> list2 = FXCollections.observableArrayList();
	ObservableList<Tablestock> list3 = FXCollections.observableArrayList();
	ObservableList<Tablestock> list4 = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Tablestock> Jtable_gents;
	@FXML
	private TableColumn<Tablestock, String> Jcol_Gitemcode;
	@FXML
	private TableColumn<Tablestock, String> Jcol_Gitemname;
	@FXML
	private TableColumn<Tablestock, String> Jcol_Gbrandid;
	@FXML
	private TableColumn<Tablestock, Integer> Jcol_Gquantity;
	@FXML
	private TableColumn<Tablestock, Float> Jcol_Gbuyingprice;
	@FXML
	private TableColumn<Tablestock, Float> Jcol_Gsellingprice;
	@FXML
	private TableColumn<Tablestock, String> Jcol_Gcolor;
	@FXML
	private TableColumn<Tablestock, String> Jcol_Gsize;
	@FXML
	private TableColumn<Tablestock, Integer> Jcol_Gsubcategoryid;
	@FXML
	private TableColumn<Tablestock, String> Jcol_Gadddate;
	
	
    @FXML
    private TableView<Tablestock> Jtable_women;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Witemcode;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Witemname;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Wbrandid;
    @FXML
    private TableColumn<Tablestock, Integer> Jcol_Wquantity;
    @FXML
    private TableColumn<Tablestock, Float> Jcol_Wbuyingprice;
    @FXML
    private TableColumn<Tablestock, Float> Jcol_Wsellingprice;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Wcolor;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Wsize;
    @FXML
    private TableColumn<Tablestock, Integer> Jcol_Wsubcategoryid;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Wadddate;
	
    
    
    @FXML
    private TableView<Tablestock> Jtable_kids;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Kitemid;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Kitemname;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Kbrandid;
    @FXML
    private TableColumn<Tablestock, Integer> Jcol_Kquantity;
    @FXML
    private TableColumn<Tablestock, Float> Jcol_Kbuyingprice;
    @FXML
    private TableColumn<Tablestock, Float> Jcol_Ksellingprice;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Kcolor;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Ksize;
    @FXML
    private TableColumn<Tablestock, Integer> Jcol_Ksubcategory;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Kadddate; 
    
    @FXML
    private TableView<Tablestock> Jtable_cosmetics;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Citemid;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Citemname;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Cbrandid;
    @FXML
    private TableColumn<Tablestock, Integer> Jcol_Cquantity;
    @FXML
    private TableColumn<Tablestock, Float> Jcol_Cbuyingprice;
    @FXML
    private TableColumn<Tablestock, Float> Jcol_Csellingprice;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Ccolor;
    @FXML
    private TableColumn<Tablestock, Integer> Jcol_Csubcategory;
    @FXML
    private TableColumn<Tablestock, String> Jcol_Cadddate;
    
    @FXML
	private JFXButton Jbtn_home;
    @FXML
    private JFXButton Jbtn_home2;
    @FXML
    private JFXButton Jbtn_home3;
    @FXML
    private JFXButton Jbtn_home4;
    @FXML
	private ComboBox<String> Jcombo_Gsub;
    @FXML
    private ComboBox<String> Jcombo_Wsub;
    @FXML
    private ComboBox<String> Jcombo_Ksub;

    @FXML
    private TextField Jtxt_search;
    @FXML
    private TextField Jtxt_wsearch;
    @FXML
    private TextField Jtxt_ksearch;
    @FXML
    private TextField Jtxt_csearch;
	
    ObservableList<String> gsublist = FXCollections.observableArrayList();
    ObservableList<String> wsublist = FXCollections.observableArrayList();	
    ObservableList<String> ksublist = FXCollections.observableArrayList();
    ObservableList<String> csublist = FXCollections.observableArrayList();
	// Event Listener on JFXButton[#Jbtn_home].onAction
	@FXML
	public void btn_home(ActionEvent event) throws Exception {
		// TODO Autogenerated
		//System.out.println(Jcombo_Gsub.getValue());
		
		((Node)event.getSource()).getScene().getWindow().hide();
    	Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/login.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void removeAllRows(){
	    for ( int i = 0; i<Jtable_gents.getItems().size(); i++) {
	    	Jtable_gents.getItems().clear(); 
	    } 
	}
	
	public void loadGentstable(){
		try{
			Connection c = (Connection) DBcon.ConnerDb();
			String q = "select * from items where categoryid = '1' " ;
			PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				list1.add(new Tablestock(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getFloat(5), 
						rs.getFloat(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getInt(9), 
						rs.getInt(10), 
						rs.getString(11)));
				Jtable_gents.setItems(list1);
			}

			FilteredList<Tablestock> filteredData1 = new FilteredList<>(list1, p -> true);
			SortedList<Tablestock> sortedData1 = new SortedList<>(filteredData1);
			sortedData1.comparatorProperty().bind(Jtable_gents.comparatorProperty());
			Jtable_gents.setItems(sortedData1);
			
			FilteredList<Tablestock> filteredData = new FilteredList<>(list1, p -> true);
			
			////// metiken thama sort wenne
			Jtxt_search.textProperty().addListener((observable, oldValue, newValue) -> {
				filteredData.setPredicate(Tablestock -> {
					// If filter text is empty, display all persons.
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}
					
					// Compare first name and last name of every person with filter text.
					String lowerCaseFilter = newValue.toLowerCase();
					
					if (Tablestock.getItemcode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches first name.
					} /*else if (Add_Allowance_T.getEmp_id().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches last name.
					}*/
					return false; // Does not match.
				});
			});
			
			SortedList<Tablestock> sortedData = new SortedList<>(filteredData);
			sortedData.comparatorProperty().bind(Jtable_gents.comparatorProperty());
			Jtable_gents.setItems(sortedData);
			
			
			rs.close();
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	
	
	public void loadWomentable(){
		try{
			Connection c = (Connection) DBcon.ConnerDb();
			String q = "select * from items where categoryid = '2' " ;
			PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				list2.add(new Tablestock(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getFloat(5), 
						rs.getFloat(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getInt(9), 
						rs.getInt(10), 
						rs.getString(11)));
				Jtable_women.setItems(list2);
				
				FilteredList<Tablestock> filteredData1 = new FilteredList<>(list2, p -> true);
				SortedList<Tablestock> sortedData1 = new SortedList<>(filteredData1);
				sortedData1.comparatorProperty().bind(Jtable_women.comparatorProperty());
				Jtable_women.setItems(sortedData1);
				
				FilteredList<Tablestock> filteredData = new FilteredList<>(list2, p -> true);
				
				////// metiken thama sort wenne
				Jtxt_wsearch.textProperty().addListener((observable, oldValue, newValue) -> {
					filteredData.setPredicate(Tablestock -> {
						// If filter text is empty, display all persons.
						if (newValue == null || newValue.isEmpty()) {
							return true;
						}
						
						// Compare first name and last name of every person with filter text.
						String lowerCaseFilter = newValue.toLowerCase();
						
						if (Tablestock.getItemcode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
							return true; // Filter matches first name.
						} /*else if (Add_Allowance_T.getEmp_id().toLowerCase().indexOf(lowerCaseFilter) != -1) {
							return true; // Filter matches last name.
						}*/
						return false; // Does not match.
					});
				});
				
				SortedList<Tablestock> sortedData = new SortedList<>(filteredData);
				sortedData.comparatorProperty().bind(Jtable_women.comparatorProperty());
				Jtable_women.setItems(sortedData);
				
			}
			rs.close();
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	
	
	
	public void loadKidstable(){
		try{
			Connection c = (Connection) DBcon.ConnerDb();
			String q = "select * from items where categoryid = '3' " ;
			PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				list3.add(new Tablestock(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getFloat(5), 
						rs.getFloat(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getInt(9), 
						rs.getInt(10), 
						rs.getString(11)));
				Jtable_kids.setItems(list3);
				
				FilteredList<Tablestock> filteredData1 = new FilteredList<>(list3, p -> true);
				SortedList<Tablestock> sortedData1 = new SortedList<>(filteredData1);
				sortedData1.comparatorProperty().bind(Jtable_kids.comparatorProperty());
				Jtable_kids.setItems(sortedData1);
				
				FilteredList<Tablestock> filteredData = new FilteredList<>(list3, p -> true);
				
				////// metiken thama sort wenne
				Jtxt_ksearch.textProperty().addListener((observable, oldValue, newValue) -> {
					filteredData.setPredicate(Tablestock -> {
						// If filter text is empty, display all persons.
						if (newValue == null || newValue.isEmpty()) {
							return true;
						}
						
						// Compare first name and last name of every person with filter text.
						String lowerCaseFilter = newValue.toLowerCase();
						
						if (Tablestock.getItemcode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
							return true; // Filter matches first name.
						} /*else if (Add_Allowance_T.getEmp_id().toLowerCase().indexOf(lowerCaseFilter) != -1) {
							return true; // Filter matches last name.
						}*/
						return false; // Does not match.
					});
				});
				
				SortedList<Tablestock> sortedData = new SortedList<>(filteredData);
				sortedData.comparatorProperty().bind(Jtable_kids.comparatorProperty());
				Jtable_kids.setItems(sortedData);
				
			}
			rs.close();
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	public void loadCosmeticstable(){
		try{
			Connection c = (Connection) DBcon.ConnerDb();
			String q = "select * from items where categoryid = '4' " ;
			PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				list4.add(new Tablestock(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getFloat(5), 
						rs.getFloat(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getInt(9), 
						rs.getInt(10), 
						rs.getString(11)));
				Jtable_cosmetics.setItems(list4);
				FilteredList<Tablestock> filteredData1 = new FilteredList<>(list4, p -> true);
				SortedList<Tablestock> sortedData1 = new SortedList<>(filteredData1);
				sortedData1.comparatorProperty().bind(Jtable_cosmetics.comparatorProperty());
				Jtable_cosmetics.setItems(sortedData1);
				
				FilteredList<Tablestock> filteredData = new FilteredList<>(list1, p -> true);
				
				////// metiken thama sort wenne
				Jtxt_csearch.textProperty().addListener((observable, oldValue, newValue) -> {
					filteredData.setPredicate(Tablestock -> {
						// If filter text is empty, display all persons.
						if (newValue == null || newValue.isEmpty()) {
							return true;
						}
						
						// Compare first name and last name of every person with filter text.
						String lowerCaseFilter = newValue.toLowerCase();
						
						if (Tablestock.getItemcode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
							return true; // Filter matches first name.
						} /*else if (Add_Allowance_T.getEmp_id().toLowerCase().indexOf(lowerCaseFilter) != -1) {
							return true; // Filter matches last name.
						}*/
						return false; // Does not match.
					});
				});
				
				SortedList<Tablestock> sortedData = new SortedList<>(filteredData);
				sortedData.comparatorProperty().bind(Jtable_cosmetics.comparatorProperty());
				Jtable_cosmetics.setItems(sortedData);
				
			}
			rs.close();
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	
	
	public void addvaluetoGsubcombo(){
		try{
			
			Connection c = (Connection) DBcon.ConnerDb();
			
			String q = "select * from subcategory where categoryid = '1'" ;
			
			PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				gsublist.add(rs.getString(2));	
			}
			rs.close();
		}
		catch(Exception e){
			System.err.println(e);	
		}	
	}
	
	public void addvaluetoWsubcombo(){
		try{
			
			Connection c = (Connection) DBcon.ConnerDb();
			
			String q = "select * from subcategory where categoryid = '2'" ;
			
			PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				wsublist.add(rs.getString(2));	
			}
			rs.close();
		}
		catch(Exception e){
			System.err.println(e);	
		}	
	}
	public void addvaluetoKsubcombo(){
		try{
			
			Connection c = (Connection) DBcon.ConnerDb();
			
			String q = "select * from subcategory where categoryid = '3'" ;
			
			PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ksublist.add(rs.getString(2));	
			}
			rs.close();
		}
		catch(Exception e){
			System.err.println(e);	
		}	
	}
	public void Gcombochanged(ActionEvent event){
		try{
			ObservableList<Tablestock> list5 = FXCollections.observableArrayList();
			Connection c = (Connection) DBcon.ConnerDb();
			String q1 = "select * from subcategory where subcategoryname = '"+Jcombo_Gsub.getValue().toString()+"'";
			PreparedStatement ps1 = (PreparedStatement) c.prepareStatement(q1);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
			int v = rs1.getInt(1);
			String q = "select * from items where categoryid = '1' and subcategoryid ='"+v+"'" ;
			PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				list5.add(new Tablestock(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getFloat(5), 
						rs.getFloat(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getInt(9), 
						rs.getInt(10), 
						rs.getString(11)));
				Jtable_gents.setItems(list5);
			}
			rs.close();
		}}
		catch(Exception e){
			System.err.println(e);
		}
	}
	public void Wcombochanged(ActionEvent event){
		try{
			ObservableList<Tablestock> list5 = FXCollections.observableArrayList();
			Connection c = (Connection) DBcon.ConnerDb();
			String q1 = "select * from subcategory where subcategoryname = '"+Jcombo_Wsub.getValue().toString()+"'";
			PreparedStatement ps1 = (PreparedStatement) c.prepareStatement(q1);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
			int v = rs1.getInt(1);
			String q = "select * from items where categoryid = '2' and subcategoryid ='"+v+"'" ;
			PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				list5.add(new Tablestock(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getFloat(5), 
						rs.getFloat(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getInt(9), 
						rs.getInt(10), 
						rs.getString(11)));
				Jtable_women.setItems(list5);
			}
			rs.close();
		}}
		catch(Exception e){
			System.err.println(e);
		}
	}
	public void kcombochanged(ActionEvent event){
		try{
			ObservableList<Tablestock> list5 = FXCollections.observableArrayList();
			Connection c = (Connection) DBcon.ConnerDb();
			String q1 = "select * from subcategory where subcategoryname = '"+Jcombo_Gsub.getValue().toString()+"'";
			PreparedStatement ps1 = (PreparedStatement) c.prepareStatement(q1);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
			int v = rs1.getInt(1);
			String q = "select * from items where categoryid = '3' and subcategoryid ='"+v+"'" ;
			PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				list5.add(new Tablestock(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4), 
						rs.getFloat(5), 
						rs.getFloat(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getInt(9), 
						rs.getInt(10), 
						rs.getString(11)));
				Jtable_kids.setItems(list5);
			}
			rs.close();
		}}
		catch(Exception e){
			System.err.println(e);
		}
	}
	
	public void Jtable_gents(){
		Jtable_gents.setOnMouseClicked(e -> {
			Tablestock p= Jtable_gents.getItems().get(Jtable_gents.getSelectionModel().getSelectedIndex());
			int dbt = JOptionPane.showConfirmDialog(null, "Do you want to delete this data ","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
			if(dbt ==0){
				JOptionPane.showMessageDialog(null,"Succesfully deleted");
				try{
					Connection c = (Connection) DBcon.ConnerDb();
					String q = "DELETE FROM items WHERE itemcode = '"+p.getItemcode()+"'";
					PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
					ps.executeUpdate();
				}
				catch(Exception ee){
					System.out.println(ee);
				}
				//removeAllRows();
				list1.removeAll(list1);
				Jtable_gents.setItems(list1);
				loadGentstable();
			}
			
			
	});	
	}
	public void Jtable_women(){
		Jtable_women.setOnMouseClicked(e -> {
			Tablestock p= Jtable_women.getItems().get(Jtable_women.getSelectionModel().getSelectedIndex());
			int dbt = JOptionPane.showConfirmDialog(null, "Do you want to delete this data ","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
			if(dbt ==0){
				JOptionPane.showMessageDialog(null,"Succesfully deleted");
				try{
					Connection c = (Connection) DBcon.ConnerDb();
					String q = "DELETE FROM items WHERE itemcode = '"+p.getItemcode()+"'";
					PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
					ps.executeUpdate();
				}
				catch(Exception ee){
					System.out.println(ee);
				}
				//loadWomentable();
				list2.removeAll(list2);
				Jtable_women.setItems(list2);
				loadWomentable();
				
			}
	});	
	}
	public void Jtable_kids(){
		Jtable_kids.setOnMouseClicked(e -> {
			Tablestock p= Jtable_kids.getItems().get(Jtable_kids.getSelectionModel().getSelectedIndex());
			int dbt = JOptionPane.showConfirmDialog(null, "Do you want to delete this data ","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
			if(dbt ==0){
				JOptionPane.showMessageDialog(null,"Succesfully deleted");
				try{
					Connection c = (Connection) DBcon.ConnerDb();
					String q = "DELETE FROM items WHERE itemcode = '"+p.getItemcode()+"'";
					PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
					ps.executeUpdate();
				}
				catch(Exception ee){
					System.out.println(ee);
				}
				list3.removeAll(list3);
				Jtable_kids.setItems(list3);
				loadKidstable();
			}
	});	
	}
	public void Jtable_cosmetics(){
		Jtable_cosmetics.setOnMouseClicked(e -> {
			Tablestock p= Jtable_cosmetics.getItems().get(Jtable_cosmetics.getSelectionModel().getSelectedIndex());
			int dbt = JOptionPane.showConfirmDialog(null, "Do you want to delete this data ","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
			if(dbt ==0){
				JOptionPane.showMessageDialog(null,"Succesfully deleted");
				try{
					Connection c = (Connection) DBcon.ConnerDb();
					String q = "DELETE FROM items WHERE itemcode = '"+p.getItemcode()+"'";
					PreparedStatement ps = (PreparedStatement) c.prepareStatement(q);
					ps.executeUpdate();
				}
				catch(Exception ee){
					System.out.println(ee);
				}
				list4.removeAll(list4);
				Jtable_cosmetics.setItems(list4);
				loadCosmeticstable();
			}
	});	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub	
		
		loadGentstable();
		
		Jcol_Gitemcode.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("itemcode"));
		Jcol_Gitemname.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("itemname"));
		Jcol_Gbrandid.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("brandid"));
		Jcol_Gquantity.setCellValueFactory(new PropertyValueFactory<Tablestock,Integer>("quantity"));
		Jcol_Gbuyingprice.setCellValueFactory(new PropertyValueFactory<Tablestock,Float>("buyprice"));
		Jcol_Gsellingprice.setCellValueFactory(new PropertyValueFactory<Tablestock,Float>("sellprice"));
		Jcol_Gsize.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("color"));
		Jcol_Gcolor.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("size"));
		Jcol_Gsubcategoryid.setCellValueFactory(new PropertyValueFactory<Tablestock,Integer>("subcategryid"));
		Jcol_Gadddate.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("dddate"));
		Jtable_gents.setItems(list1);
		
		
		
		
		//loadGentstable();
		
		Jcombo_Gsub.setItems(gsublist);
		addvaluetoGsubcombo();
		Jcombo_Wsub.setItems(wsublist);
		addvaluetoWsubcombo();
		Jcombo_Ksub.setItems(ksublist);
		addvaluetoKsubcombo();
		loadWomentable();
		Jcol_Witemcode.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("itemcode"));
		Jcol_Witemname.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("itemname"));
		Jcol_Wbrandid.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("brandid"));
		Jcol_Wquantity.setCellValueFactory(new PropertyValueFactory<Tablestock,Integer>("quantity"));
		Jcol_Wbuyingprice.setCellValueFactory(new PropertyValueFactory<Tablestock,Float>("buyprice"));
		Jcol_Wsellingprice.setCellValueFactory(new PropertyValueFactory<Tablestock,Float>("sellprice"));
		Jcol_Wcolor.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("color"));
		Jcol_Wsize.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("size"));
		Jcol_Wsubcategoryid.setCellValueFactory(new PropertyValueFactory<Tablestock,Integer>("subcategryid"));
		Jcol_Wadddate.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("dddate"));
		Jtable_women.setItems(list2);
		//loadWomentable();
		loadKidstable();
		Jcol_Kitemid.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("itemcode"));
		Jcol_Kitemname.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("itemname"));
		Jcol_Kbrandid.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("brandid"));
		Jcol_Kquantity.setCellValueFactory(new PropertyValueFactory<Tablestock,Integer>("quantity"));
		Jcol_Kbuyingprice.setCellValueFactory(new PropertyValueFactory<Tablestock,Float>("buyprice"));
		Jcol_Ksellingprice.setCellValueFactory(new PropertyValueFactory<Tablestock,Float>("sellprice"));
		Jcol_Kcolor.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("color"));
		Jcol_Ksize.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("size"));
		Jcol_Ksubcategory.setCellValueFactory(new PropertyValueFactory<Tablestock,Integer>("subcategryid"));
		Jcol_Kadddate.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("dddate"));
		Jtable_kids.setItems(list3);
		//loadKidstable();
		loadCosmeticstable();
		Jcol_Citemid.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("itemcode"));
		Jcol_Citemname.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("itemname"));
		Jcol_Cbrandid.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("brandid"));
		Jcol_Cquantity.setCellValueFactory(new PropertyValueFactory<Tablestock,Integer>("quantity"));
		Jcol_Cbuyingprice.setCellValueFactory(new PropertyValueFactory<Tablestock,Float>("buyprice"));
		Jcol_Csellingprice.setCellValueFactory(new PropertyValueFactory<Tablestock,Float>("sellprice"));
		Jcol_Ccolor.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("color"));
		Jcol_Csubcategory.setCellValueFactory(new PropertyValueFactory<Tablestock,Integer>("subcategryid"));
		Jcol_Cadddate.setCellValueFactory(new PropertyValueFactory<Tablestock,String>("dddate"));
		Jtable_cosmetics.setItems(list4);
		//loadCosmeticstable();
		
		Jtable_gents();
		Jtable_women();
		Jtable_kids();
		Jtable_cosmetics();
		
		
		
		
		
		
	}
	
}
