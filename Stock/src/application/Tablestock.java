package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tablestock {
	
	private final SimpleStringProperty itemcode;
	private final SimpleStringProperty itemname;
	private final SimpleStringProperty brandid;
	private final SimpleIntegerProperty quantity;
	private final SimpleFloatProperty buyprice;
	private final SimpleFloatProperty sellprice;
	private final SimpleStringProperty color;
	private final SimpleStringProperty size;
	private final SimpleIntegerProperty categoryid;
	private final SimpleIntegerProperty subcategryid;
	private final SimpleStringProperty dddate;
	
	
	public Tablestock(String itemcode, String itemname, String brandid,
			Integer quantity,Float buyprice, Float sellprice,
			String color, String size, Integer categoryid,
			Integer subcategryid, String dddate) {
		super();
		this.itemcode = new SimpleStringProperty(itemcode);
		this.itemname = new SimpleStringProperty(itemname);
		this.brandid = new SimpleStringProperty(brandid);
		this.quantity = new SimpleIntegerProperty(quantity);
		this.buyprice = new SimpleFloatProperty(buyprice);
		this.sellprice = new SimpleFloatProperty(sellprice);
		this.color = new SimpleStringProperty(color);
		this.size = new SimpleStringProperty(size);
		this.categoryid = new SimpleIntegerProperty(categoryid);
		this.subcategryid = new SimpleIntegerProperty(subcategryid);
		this.dddate = new SimpleStringProperty(dddate);
	}
	
	public String getItemcode() {
		 return itemcode.get();
	}
	public String getItemname() {
		 return itemname.get();
	}
	public String getBrandid() {
		return brandid.get();
	}
	public Integer getQuantity() {
		return quantity.get();
	}
	public Float getBuyprice() {
		return buyprice.get();
	}
	public Float getSellprice() {
		return sellprice.get();
	}
	public String getColor() {
		return color.get();
	}
	public String getSize() {
		return size.get();
	}
	public Integer getCategoryid() {
		return categoryid.get();
	}
	public Integer getSubcategryid() {
		return subcategryid.get();
	}
	public String getAdddate() {
		return dddate.get();
	}
	
	/*
	public void setItemcode(String itemcode) {
		 this.itemcode=itemcode;
	}
	public void setItemname(String itemname) {
		this.itemname=itemname;
	}
	public void setBrandid(String brandid) {
		this.brandid=brandid;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	public void setBuyprice(float buyprice) {
		this.buyprice=buyprice;
	}
	public void setSellprice(float sellprice) {
		this.sellprice=sellprice;
	}
	public void setColor(String color) {
		this.color=color;
	}
	public void setSize(int size) {
		this.size=size;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid=categoryid;
	}
	public void setSubcategryid(int subcategryid) {
		this.subcategryid=subcategryid;
	}
	public void setAdddate(String adddate) {
		this.adddate=adddate;
	}*/
	

}
