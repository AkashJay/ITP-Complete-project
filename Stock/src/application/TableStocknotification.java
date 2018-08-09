package application;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableStocknotification {

	private final SimpleIntegerProperty subid;
	private final SimpleStringProperty subname;
	private final SimpleIntegerProperty catid;
	private final SimpleIntegerProperty minquantity;
	private final SimpleIntegerProperty maxquantity;
	public TableStocknotification(Integer subid, String subname, Integer catid,
			Integer minquantity, Integer maxquantity) {
		super();
		this.subid =  new SimpleIntegerProperty(subid);
		this.subname = new SimpleStringProperty(subname);
		this.catid = new SimpleIntegerProperty(catid);
		this.minquantity = new SimpleIntegerProperty(minquantity);
		this.maxquantity = new SimpleIntegerProperty(maxquantity);
	}
	public Integer getSubid() {
		return subid.get();
	}
	public String getSubname() {
		return subname.get();
	}
	public Integer getCatid() {
		return catid.get();
	}
	public Integer getMinquantity() {
		return minquantity.get();
	}
	public Integer getMaxquantity() {
		return maxquantity.get();
	}
	
	
}
