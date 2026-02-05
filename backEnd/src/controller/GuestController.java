package controller;

import dao.GuestDAO;
import model.Guest;

import java.sql.Date;

public class GuestController {

    public static void main(String[] args) {

        GuestDAO guestDAO = new GuestDAO();

        // Test Reservation Data

        Guest guest = new Guest(
                "Komeshan Moorthy",
                "Galle, Sri Lanka",
                "0712345678",
                201,
                "Deluxe",
                Date.valueOf("2026-02-10"),
                Date.valueOf("2026-02-15")
        );

        if (guestDAO.addGuest(guest)) {
            System.out.println("Reservation added successfully!");
        } else {
            System.out.println("Failed to add reservation.");
        }
    }
}
