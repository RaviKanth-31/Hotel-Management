package rules;
import java.sql.*;
import models.Guest;
import connection.Connect;
public class GuestManagement {
	public static void addGuest(Guest g) {
		String query = "INSERT INTO guest(name, email, phone_number, address) VALUES(?,?,?,?)";
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, g.getName());
			ps.setString(2, g.getEmail());
			ps.setString(3, g.getPhoneNumber());
			ps.setString(4, g.getAddress());
			ps.executeUpdate();
			System.out.println("Guest added successfully");
		}
		catch(Exception e) {
			System.out.println("Error" + e);
		}
	}
	public static Guest getFromPhoneNumber(String phoneNumber) {
		String query = "SELECT * FROM guest WHERE phone_number = ?";
	
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, phoneNumber);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Guest(rs.getInt("guest_id"), rs.getString("name"), rs.getString("email"), rs.getString("phone_number"), rs.getString("address"));
		}
		catch(SQLException e) {
			System.out.println("No record found");
		}
		catch(Exception e) {
			System.out.println("Error" + e);
		}
		return null;
	}
	public static void updateGuest(String phoneNumber, String name) {
		String query = "UPDATE guest SET name= ? WHERE phone_number = ?";
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, phoneNumber);
			int count = ps.executeUpdate();
			if(count!=0) System.out.println("Updated successfully");
			else System.out.println("No record found");
		}
		catch(Exception e) {
			System.out.println("Error" + e);
		}
	}
	public static void deleteGuest(String phoneNumber) {
		String query = "DELETE FROM guest WHERE phone_number = ?";
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, phoneNumber);
			int count = ps.executeUpdate();
			if(count!=0) System.out.println("Deleted Successfully");
			else System.out.println("No record found");
		}
		catch(Exception e) {
			System.out.println("Error" + e);
		}
	}
}
