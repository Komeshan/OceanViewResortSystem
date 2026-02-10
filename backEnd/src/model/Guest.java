package model;

public class Guest {
    private String name;
    private String address;
    private String contact;

    public Guest(String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    // Getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getContact() { return contact; }
}
