package dao;

import model.Guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

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

    // ✅ NEW METHOD (INSIDE CLASS)
    public Guest getGuestByReservationNumber(int resNo) {

        String sql = "SELECT * FROM guest WHERE reservation_number = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, resNo);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Guest(
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("contact_number"),
                    rs.getInt("reservation_number"),
                    rs.getString("room_type"),
                    rs.getDate("check_in"),
                    rs.getDate("check_out")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error fetching reservation:");
            e.printStackTrace();
        }

        return null;
    }
}
