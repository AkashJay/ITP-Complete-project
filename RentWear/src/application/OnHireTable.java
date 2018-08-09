package application;

import javafx.beans.property.SimpleStringProperty;

public class OnHireTable {
	
	private final SimpleStringProperty invNo;
	private final SimpleStringProperty cname;
	private final SimpleStringProperty cnic;
	private final SimpleStringProperty cmobile;
	private final SimpleStringProperty wcode;
	private final SimpleStringProperty hdate;
	private final SimpleStringProperty rdate;
	
	
	public OnHireTable(String invNo, String cname, String cnic,String cmobile, String wcode, String hdate, String rdate) {
		super();
		this.invNo =new SimpleStringProperty(invNo);
		this.cname =new SimpleStringProperty(cname);
		this.cnic = new SimpleStringProperty(cnic);
		this.cmobile = new SimpleStringProperty(cmobile);
		this.wcode = new SimpleStringProperty(wcode);
		this.hdate = new SimpleStringProperty(hdate);
		this.rdate = new SimpleStringProperty(rdate);
	}


	public String getInvNo() {
		return invNo.get();
	}


	public String getCname() {
		return cname.get();
	}


	public String getCnic() {
		return cnic.get();
	}


	public String getCmobile() {
		return cmobile.get();
	}


	public String getWcode() {
		return wcode.get();
	}



	public String getHdate() {
		return hdate.get();
	}


	public String getRdate() {
		return rdate.get();
	}
	
	

}
