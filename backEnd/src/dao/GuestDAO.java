package dao;

import model.Guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GuestDAO {

    public boolean addGuest(Guest guest) {

        String sql = "INSERT INTO guest " +
                "(name, address, contact_number, reservation_number, room_type, check_in, check_out) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, guest.getName());
            stmt.setString(2, guest.getAddress());
            stmt.setString(3, guest.getContactNumber());
            stmt.setInt(4, guest.getReservationNumber());
            stmt.setString(5, guest.getRoomType());
            stmt.setDate(6, guest.getCheckIn());
            stmt.setDate(7, guest.getCheckOut());

            int rows = stmt.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error adding reservation:");
            e.printStackTrace();
            return false;
        }
    }
}
