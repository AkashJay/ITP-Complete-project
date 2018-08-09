package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableSupplier {
	private final SimpleStringProperty supplierid;
	private final SimpleStringProperty firstname;
	private final SimpleStringProperty lastname;
	private final SimpleStringProperty address;
	private final SimpleStringProperty dob;
	private final SimpleStringProperty gender;
	private final SimpleStringProperty email;
	private final SimpleIntegerProperty phone;
	private final SimpleStringProperty nic;
	private final SimpleStringProperty companyname;


public TableSupplier(String supplierid, String firstname, String lastname,
		String address,String dob, String gender,
		String email, Integer phone, String nic,
		String companyname) {
	super();
	this.supplierid = new SimpleStringProperty(supplierid);
	this.firstname = new SimpleStringProperty(firstname);
	this.lastname = new SimpleStringProperty(lastname);
	this.address = new SimpleStringProperty(address);
	this.dob = new SimpleStringProperty(dob);
	this.gender = new SimpleStringProperty(gender);
	this.email = new SimpleStringProperty(email);
	this.phone = new SimpleIntegerProperty(phone);
	this.nic = new SimpleStringProperty(nic);
	this.companyname = new SimpleStringProperty(companyname);
}


public String getSupplierid() {
	return supplierid.get();
}

public String getFirstname() {
	return firstname.get();
}

public String getLastname() {
	return lastname.get();
}

public String getAddress() {
	return address.get();
}

public String getDob() {
	return dob.get();
}

public String getGender() {
	return gender.get();
}

public String getEmail() {
	return email.get();
}

public Integer getPhone() {
	return phone.get();
}

public String getNic() {
	return nic.get();
}

public String getCompanyname() {
	return companyname.get();
}


}