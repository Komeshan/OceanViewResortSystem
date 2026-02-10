package model;

public class Reservation {
    private int reservationNumber;
    private String guestName;
    private String address;
    private String contact;
    private String roomType;
    private String checkIn;
    private String checkOut;

    public Reservation(int reservationNumber, String guestName, String address, String contact, String roomType, String checkIn, String checkOut) {
        this.reservationNumber = reservationNumber;
        this.guestName = guestName;
        this.address = address;
        this.contact = contact;
        this.roomType = roomType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Getters
    public int getReservationNumber() { return reservationNumber; }
    public String getGuestName() { return guestName; }
    public String getAddress() { return address; }
    public String getContact() { return contact; }
    public String getRoomType() { return roomType; }
    public String getCheckIn() { return checkIn; }
    public String getCheckOut() { return checkOut; }
}
