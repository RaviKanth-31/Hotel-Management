package models;

public class Guest {
	private int guestId;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	public Guest(int guestId, String name, String email, String phoneNumber, String address) {
		this.guestId = guestId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public void setName(String x) {
		name = x;
	}
	public void setEmail(String x) {
		email = x;
	}
	public void setPhoneNumber(String x) {
		phoneNumber = x;
	}
	public void setAddress(String x) {
		address = x;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public String getDetails() {
		return name + ", " + email + ", " + phoneNumber + ", " + address; 
	}
	
}
