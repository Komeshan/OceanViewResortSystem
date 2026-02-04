package model;

public class Guest {
    private int guestId;
    private String name;
    private String address;
    private String contactNumber;
    private int reservationNumber;

    // Constructor
    public Guest(String name, String address, String contactNumber, int reservationNumber) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.reservationNumber = reservationNumber;
    }

    // Getters and Setters
    public int getGuestId() { return guestId; }
    public void setGuestId(int guestId) { this.guestId = guestId; }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getContactNumber() { return contactNumber; }
    public int getReservationNumber() { return reservationNumber; }
}
