package models;

public class Room {
	private int roomNumber;
	private String type;
	private double pricePerNight;
	private boolean availability;
	public Room(int roomNumber, String type, double price, boolean availability){
		this.roomNumber = roomNumber;
		this.type = type;
		this.pricePerNight = price;
		this.availability = availability;
	}
	public void setRoomNumber(int x) { 
		roomNumber = x;
	}
	public void setType(String x) {
		type = x;
	}
	public void setPricePerNight(int x) {
		pricePerNight = x;
	}
	public void setAvailability(boolean x) {
		availability = x;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public String getRoomType() {
		return type;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public boolean getAvailability() {
		return availability;
	}
	public String getDetails() {
		return roomNumber + ", " + type + ", " + pricePerNight + ", " + availability;
	}
}
