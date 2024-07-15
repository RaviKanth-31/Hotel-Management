package options;
import java.util.Scanner;
import java.sql.Date;
import models.Reservation;
import rules.ReservationManagement;
public class ReservationOptions {
	public ReservationOptions() {
		System.out.println("Enter an option:");
		System.out.println("1. Reserve a room");
		System.out.println("2. Cancel a reservation");
		System.out.println("3. Update a reservation");
		System.out.println("4. View a reservation");
		System.out.println("5. Exit");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if(option==5) System.exit(0);
		ReservationManagement rm = new ReservationManagement();
		switch(option) {
		case 1:
			System.out.println("Enter room number");
			int num = sc.nextInt();
			System.out.println("Enter guest id");
			int guestId = sc.nextInt();
			System.out.println("Enter date of entry");
			int date = sc.nextInt();
			String dateStr = "2024-07-" + date;
			System.out.println("Enter date of exit");
			int exitdate = sc.nextInt();
			String exitDateStr = "2024-07-" + exitdate;
			System.out.println("Enter Price");
			rm.addReservation(new Reservation(1,2,11, Date.valueOf(dateStr), Date.valueOf(exitDateStr), 899));
			break;
		case 2:
			System.out.println("Enter reservation id");
			int id = sc.nextInt();
			rm.cancelReservation(id);
			break;
		case 3:
			System.out.println("Enter reservation id:");
			int rid = sc.nextInt();
			System.out.println("Enter date of entry");
			int rdate = sc.nextInt();
			String rdateStr = "2024-07-" + rdate;
			System.out.println("Enter date of exit");
			int rexitdate = sc.nextInt();
			String rexitDateStr = "2024-07-" + rexitdate;
			rm.updateReservation(rid, Date.valueOf(rdateStr), Date.valueOf(rexitDateStr));
			break;
		case 4:
			System.out.println("Enter reservation id:");
			int riid = sc.nextInt();
			Reservation rs = rm.getFromReservationId(riid);
			System.out.println(rs.getDetails());
			break;
		}
	}
}
