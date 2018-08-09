package application;

import javafx.beans.property.SimpleStringProperty;

public class tableExpire {

	
	private final SimpleStringProperty Item_Code;
	private final SimpleStringProperty Expire_date;
	
	public tableExpire(String item_Code, String expire_date) {
		super();
		this.Item_Code = new SimpleStringProperty(item_Code);
		this.Expire_date = new SimpleStringProperty(expire_date);
	}
	public String getItem_Code() {
		return Item_Code.get();
	}
	public String getExpire_date() {
		return Expire_date.get();
	}
	
	
}
