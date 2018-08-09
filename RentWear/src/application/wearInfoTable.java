package application;

import javafx.beans.property.SimpleStringProperty;

public class wearInfoTable {
	
	private final SimpleStringProperty wcode;
	private final SimpleStringProperty wname;
	private final SimpleStringProperty wcat;
	private final SimpleStringProperty wmat;
	private final SimpleStringProperty wsize;
	private final SimpleStringProperty wsupp;
	private final SimpleStringProperty wrentfee;
	private final SimpleStringProperty latefee;
	private final SimpleStringProperty wstatus;
	private final SimpleStringProperty wdes;
	
	
	public wearInfoTable(String wcode, String wname, String wcat,
			String wmat, String wsize, String wsupp,
			String wrentfee, String latefee, String wstatus,
			String wdes) {
		super();
		this.wcode = new SimpleStringProperty(wcode);
		this.wname =new SimpleStringProperty(wname);
		this.wcat = new SimpleStringProperty(wcat);
		this.wmat = new SimpleStringProperty(wmat);
		this.wsize =new SimpleStringProperty(wsize);
		this.wsupp = new SimpleStringProperty(wsupp);
		this.wrentfee = new SimpleStringProperty(wrentfee);
		this.latefee = new SimpleStringProperty(latefee);
		this.wstatus = new SimpleStringProperty(wstatus);
		this.wdes = new SimpleStringProperty(wdes);
	}


	public String getWcode() {
		return wcode.get();
	}


	public String getWname() {
		return wname.get();
	}


	public String getWcat() {
		return wcat.get();
	}


	public String getWmat() {
		return wmat.get();
	}


	public String getWsize() {
		return wsize.get();
	}


	public String getWsupp() {
		return wsupp.get();
	}


	public String getWrentfee() {
		return wrentfee.get();
	}


	public String getLatefee() {
		return latefee.get();
	}


	public String getWstatus() {
		return wstatus.get();
	}


	public String getWdes() {
		return wdes.get();
	}
	
	
	
	
	

}
