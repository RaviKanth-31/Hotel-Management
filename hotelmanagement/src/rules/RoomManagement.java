package rules;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import models.*;
import connection.Connect;
public class RoomManagement {
	public static void addRoom(Room room) {
		String query = "INSERT INTO room values(?, ?, ?, ?)";
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, room.getRoomNumber());
			ps.setString(2, room.getRoomType());
			ps.setDouble(3, room.getPricePerNight());
			ps.setBoolean(4, room.getAvailability());
			ps.executeUpdate();
		}
		catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("Room details already present. Kindly delete the previous record!");
		}
		catch(Exception e) {
			System.out.println("Error" + e);
		}
	}
	public static Room getRoom(int roomNumber) {
		String query = "SELECT * FROM room WHERE room_number = ?";
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, roomNumber);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Room(rs.getInt("room_number"), rs.getString("type"), rs.getDouble("price_per_night"), rs.getBoolean("availability_status"));
			}
		}
		catch(Exception e) {
			System.out.println("Error" + e);
		}
		return null;
	}
	public static List<Room> getAllRooms(){
		List<Room> rooms = new ArrayList<Room>();
		String query = "SELECT * FROM room where availability_status = true";
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rooms.add(new Room(rs.getInt("room_number"), rs.getString("type"), rs.getDouble("price_per_night"), rs.getBoolean("availability_status")));
			}
		}
		catch(Exception e) {
			System.out.println("Exception" + e);
		}
		return rooms;
	}
	public static void updateRoom(int roomNumber, boolean availability) {
		String query = "UPDATE room SET availability_status = ? WHERE room_number = ?";
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setBoolean(1, availability);
			ps.setInt(2, roomNumber);
			ps.executeUpdate();
			System.out.println("Update Successful");
		}
		catch(Exception e) {
			System.out.println("Error" + e);
		}
	}
	public static void deleteRoom(int roomNumber) {
		String query = "DELETE FROM room WHERE room_number = ?";
		try {
			Connection con = Connect.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, roomNumber);
			int count = ps.executeUpdate();
			if(count!=0) System.out.println("Deleted successfully");
			else System.out.println("No room found");
		}
		catch(Exception e) {
			System.out.println("Error" + e);
		}
	}
	public static void main(String[] args) {
//		Room r = getRoom(2);
//		if(r!=null) System.out.println(r.getDetails());
//		else System.out.println("Details not found");
		//
//		List<Room> rooms = getAllRooms();
//		for(int i=0;i<rooms.size();i++) {
//			System.out.println(rooms.get(i).getDetails());
//		}
		//
//		updateRoom(1, true);
		//
		deleteRoom(1);
	}
}
