package options;
import models.Guest;
import rules.GuestManagement;
import java.util.Scanner;
public class GuestOptions {
	public GuestOptions() {
		System.out.println("Enter an option");
		System.out.println("1. Add a guest");
		System.out.println("2. Delete a guest");
		System.out.println("3. View guest Details");
		System.out.println("4. Update a guest");
		System.out.println("5. Exit");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if(option==5) System.exit(0);
		GuestManagement gm = new GuestManagement();
		switch(option) {
		case 1:
			System.out.println("Enter guest name");
			String name = sc.nextLine();
			System.out.println("Enter guest email");
			String email = sc.nextLine();
			System.out.println("Enter guest phone number");
			String phn = sc.nextLine();
			System.out.println("Enter guest Address");
			String add = sc.nextLine();
			gm.addGuest(new Guest(1, name, email, phn, add));
			break;
		case 2:
			System.out.println("Enter guest mobile number");
			String mob = sc.nextLine();
			gm.deleteGuest(mob);
			break;
		case 3:
			System.out.println("Enter guest mobile number");
			String mob1 = sc.nextLine();
			gm.getFromPhoneNumber(mob1);
			break;
		case 4:
			System.out.println("Enter guest mobile number");
			String mo = sc.nextLine();
			System.out.println("Enter name of guest to edit");
			String nam = sc.nextLine();
			gm.updateGuest(mo, nam);
			break;
		}
	}
}
