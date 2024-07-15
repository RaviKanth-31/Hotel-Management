package rules;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.Connect;
import models.Reservation;

public class ReservationManagement {
	public static void addReservation(Reservation r) {
		String query = "INSERT INTO Reservation(room_number, guest_id, check_in_date, check_out_date, total_price) VALUES(?,?,?,?,?)";
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, r.getRoomNumber());
			ps.setInt(2, r.getGuestId());
			ps.setDate(3, r.getCheckInDate());
			ps.setDate(4, r.getCheckOutDate());
			ps.setInt(5, r.getPrice());
			ps.executeUpdate();
			System.out.println("Reservation added successfully");
		}
		catch(Exception e) {
			System.out.println("Error" + e);
		}
	}
	public static Reservation getFromReservationId(int reservationId) {
		String query = "SELECT * FROM reservation WHERE reservation_id = ?";
	
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, reservationId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Reservation(rs.getInt("reservation_id"), rs.getInt("room_number"), rs.getInt("guest_id"), rs.getDate("check_in_date"), rs.getDate("check_out_date"), rs.getInt("total_price"));
		}
		catch(SQLException e) {
			System.out.println("No record found");
		}
		catch(Exception e) {
			System.out.println("Error" + e);
		}
		return null;
	}
	public static void updateReservation(int reservationId, Date checkInDate, Date checkOutDate) {
		String query = "UPDATE Reservation SET check_in_date= ?, check_out_date = ? WHERE reservation_id = ?";
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDate(1, checkInDate);
			ps.setDate(2, checkOutDate);
			ps.setInt(3, reservationId);
			int count = ps.executeUpdate();
			if(count!=0) System.out.println("Updated successfully");
			else System.out.println("No record found");
		}
		catch(Exception e) {
			System.out.println("Error" + e);
		}
	}
	public static void cancelReservation(int reservationId) {
		String query = "DELETE FROM reservation WHERE reservation_id = ?";
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, reservationId);
			int count = ps.executeUpdate();
			if(count!=0) System.out.println("Cancelled Successfully");
			else System.out.println("No reservation found");
		}
		catch(Exception e) {
			System.out.println("Error" + e);
		}
	}
	public static void main(String[] args) {
//		addReservation(new Reservation(1,2,11, Date.valueOf("2024-07-05"), Date.valueOf("2024-07-06"), 899));
//		updateReservation(2, Date.valueOf("2024-02-05"), Date.valueOf("2024-03-22"));
//		Reservation rs = getFromReservationId(3);
//		System.out.println(rs.getDetails());
		cancelReservation(3);
	}
}
