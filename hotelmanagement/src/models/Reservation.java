package models;
import java.sql.Date;
public class Reservation {
	private int reservationId;
	private int roomNumber;
	private int guestId;
	private Date checkInDate;
	private Date checkOutDate;
	private int totalPrice;
	public Reservation(int reservationId, int roomNumber, int guestId, Date checkInDate, Date checkOutDate, int totalPrice){
		this.reservationId = reservationId;
		this.roomNumber = roomNumber;
		this.guestId = guestId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalPrice = totalPrice;
	}
	public void setReservationId(int x) {
		reservationId = x;
	}
	public void setRoomNumber(int x) {
		roomNumber = x;
	}
	public void setGuestId(int x) {
		guestId = x;
	}
	public void setCheckInDate(Date x) {
		checkInDate = x;
	}
	public void setCheckOutDate(Date x) {
		checkOutDate = x;
	}
	public void setTotalPrice(int x) {
		totalPrice = x;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public int getReservationId() {
		return reservationId;
	}
	public int getGuestId() {
		return guestId;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public int getPrice() {
		return totalPrice;
	}
	public String getDetails() {
		return reservationId + ", " + roomNumber + ", " + guestId + ", " + checkInDate + ", " + checkOutDate + ", " + totalPrice; 
	}
}
