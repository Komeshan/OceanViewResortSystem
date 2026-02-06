package controller;

import dao.GuestDAO;
import model.Guest;

import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class GuestController {

    static GuestDAO dao = new GuestDAO();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===== Ocean View Resort =====");

        while (true) {

            System.out.println("\n1. View Reservation");
            System.out.println("2. Print Bill");
            System.out.println("3. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewReservation();
                    break;

                case 2:
                    printBill();
                    break;

                case 3:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void viewReservation() {

        System.out.print("Enter Reservation Number: ");
        int resNo = sc.nextInt();

        Guest g = dao.getGuestByReservationNumber(resNo);

        if (g == null) {
            System.out.println("Reservation not found!");
            return;
        }

        System.out.println("\n--- Reservation Details ---");
        System.out.println("Name: " + g.getName());
        System.out.println("Address: " + g.getAddress());
        System.out.println("Contact: " + g.getContactNumber());
        System.out.println("Room: " + g.getRoomType());
        System.out.println("Check-in: " + g.getCheckIn());
        System.out.println("Check-out: " + g.getCheckOut());
    }

    static void printBill() {

        System.out.print("Enter Reservation Number: ");
        int resNo = sc.nextInt();

        Guest g = dao.getGuestByReservationNumber(resNo);

        if (g == null) {
            System.out.println("Reservation not found!");
            return;
        }

        long days = ChronoUnit.DAYS.between(
                g.getCheckIn().toLocalDate(),
                g.getCheckOut().toLocalDate()
        );

        int rate = getRoomRate(g.getRoomType());

        long total = days * rate;

        System.out.println("\n------ BILL ------");
        System.out.println("Guest: " + g.getName());
        System.out.println("Room: " + g.getRoomType());
        System.out.println("Nights: " + days);
        System.out.println("Rate: Rs." + rate);
        System.out.println("Total: Rs." + total);
        System.out.println("------------------");
    }

    static int getRoomRate(String type) {

        switch (type.toLowerCase()) {

            case "standard":
                return 3000;

            case "deluxe":
                return 5000;

            case "suite":
                return 8000;

            default:
                return 2500;
        }
    }
}
