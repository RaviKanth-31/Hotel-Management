package main;
import options.*;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to Hotel XYZ");
		System.out.println("Please select an option from below.");
		System.out.println("1. Reservation Details");
		System.out.println("2. Room Details");
		System.out.println("3. Guest Details");
		System.out.println("4. Exit");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if(option==4) System.exit(0);
		switch(option) {
		case 1:
			ReservationOptions rops = new ReservationOptions();
		case 2:
			RoomOptions rmops = new RoomOptions();
			break;
		case 3:
			GuestOptions gops = new GuestOptions();
		}
	}
}
