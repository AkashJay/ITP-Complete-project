package application;
import javafx.beans.property.SimpleStringProperty;

public class damageWearTable {
	
	private final SimpleStringProperty invNo;
	private final SimpleStringProperty wcode;
	private final SimpleStringProperty damage;
	private final SimpleStringProperty renewl;
	private final SimpleStringProperty date;
	
	
	
	public damageWearTable(String invNo, String wcode, String damage,
			String renewl, String date) {
		super();
		this.invNo = new SimpleStringProperty(invNo);
		this.wcode = new SimpleStringProperty(wcode);
		this.damage = new SimpleStringProperty(damage);
		this.renewl = new SimpleStringProperty(renewl);
		this.date = new SimpleStringProperty(date);
	}
	
	
	public String getInvNo() {
		return invNo.get();
	}
	public String getWcode() {
		return wcode.get();
	}
	public String getDamage() {
		return damage.get();
	}
	public String getRenewl() {
		return renewl.get();
	}
	public String getDate() {
		return date.get();
	}
	

}
