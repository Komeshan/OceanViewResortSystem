package model;

import java.sql.Date;

public class Guest {

    private String name;
    private String address;
    private String contactNumber;
    private int reservationNumber;
    private String roomType;
    private Date checkIn;
    private Date checkOut;

    public Guest(String name, String address, String contactNumber,
                 int reservationNumber, String roomType,
                 Date checkIn, Date checkOut) {

        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.reservationNumber = reservationNumber;
        this.roomType = roomType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
}
