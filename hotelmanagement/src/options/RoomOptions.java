package options;
import rules.RoomManagement;
import models.Room;
import java.util.Scanner;
import java.util.List;
public class RoomOptions {
	public RoomOptions(){
		System.out.println("Select an option:");
		System.out.println("1. Add a room");
		System.out.println("2. View Room details");
		System.out.println("3. Update Room information");
		System.out.println("4. Delete a Room");
		System.out.println("5. Get all room details");
		System.out.println("6. Exit");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if(option==6) System.exit(0);
		RoomManagement rm = new RoomManagement();
		switch(option) {
		case 1:
			System.out.println("Enter Room number:");
			int roomNumber = sc.nextInt();
			System.out.println("Enter room type:");
			String type = sc.nextLine();
			System.out.println("Enter price per night");
			double price = sc.nextDouble();
			System.out.println("Enter availability status: True or false");
			boolean availability = sc.nextBoolean();
			rm.addRoom(new Room(roomNumber, type, price, availability));
			break;
		case 2:
			System.out.println("Enter room number");
			int rnum = sc.nextInt();
			Room r= rm.getRoom(rnum);
			if(r!=null) System.out.println(r.getDetails());
			else System.out.println("Details not found");
			break;
		case 3:
			System.out.println("Enter room number: ");
			int rn = sc.nextInt();
			System.out.println("Enter availability true or false: ");
			boolean availabilit = sc.nextBoolean();
			rm.updateRoom(rn, availabilit);
			break;
		case 4:
			System.out.println("Enter room number: ");
			int rnd = sc.nextInt();
			rm.deleteRoom(rnd);
			break;
		case 5:
			List<Room> rooms = rm.getAllRooms();
			for(int i=0;i<rooms.size();i++) {
				System.out.println(rooms.get(i).getDetails());
			}
		}
	}
	
}
