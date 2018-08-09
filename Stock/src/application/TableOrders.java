package application;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableOrders {

	
	private final SimpleStringProperty ordeid;
	private final SimpleStringProperty itemcode;
	private final SimpleIntegerProperty amount;
	private final SimpleFloatProperty cost;
	private final SimpleStringProperty supplierid;
	private final SimpleStringProperty orderdate;
	
	
	public TableOrders(String ordeid, String itemcode, Integer amount,
			Float cost,String supplierid,String orderdate) {
		super();
		this.ordeid = new SimpleStringProperty(ordeid);
		this.itemcode = new SimpleStringProperty(itemcode);
		this.amount = new SimpleIntegerProperty(amount);
		this.cost = new SimpleFloatProperty(cost);
		this.supplierid = new SimpleStringProperty(supplierid);
		this.orderdate = new SimpleStringProperty(orderdate);
	}


	public String getOrdeid() {
		return ordeid.get();
	}


	public String getItemcode() {
		return itemcode.get();
	}


	public Integer getAmount() {
		return amount.get();
	}


	public Float getCost() {
		return cost.get();
	}


	public String getSupplierid() {
		return supplierid.get();
	}


	public String getOrderdate() {
		return orderdate.get();
	}
}
