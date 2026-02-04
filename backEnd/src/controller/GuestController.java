package controller;

import dao.GuestDAO;
import model.Guest;

public class GuestController {
    public static void main(String[] args) {
        GuestDAO guestDAO = new GuestDAO();

        // Test data - replace with any values
        Guest guest = new Guest("Komeshan Moorthy", "Galle, Sri Lanka", "0712345678", 101);

        if (guestDAO.addGuest(guest)) {
            System.out.println("Guest added successfully!");
        } else {
            System.out.println("Failed to add guest.");
        }
    }
}
