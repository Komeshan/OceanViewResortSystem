package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Reservation;

public class ReservationDAO {

    public static void addReservation(Reservation r) throws SQLException {
        String sql = "INSERT INTO reservations (reservation_number, guest_name, address, contact, room_type, check_in, check_out) VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, r.getReservationNumber());
            ps.setString(2, r.getGuestName());
            ps.setString(3, r.getAddress());
            ps.setString(4, r.getContact());
            ps.setString(5, r.getRoomType());
            ps.setString(6, r.getCheckIn());
            ps.setString(7, r.getCheckOut());

            ps.executeUpdate();
        }
    }

    public static Reservation getReservationByNumber(int resNumber) throws SQLException {
        String sql = "SELECT * FROM reservations WHERE reservation_number = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, resNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Reservation(
                        rs.getInt("reservation_number"),
                        rs.getString("guest_name"),
                        rs.getString("address"),
                        rs.getString("contact"),
                        rs.getString("room_type"),
                        rs.getString("check_in"),
                        rs.getString("check_out")
                );
            } else {
                return null;
            }
        }
    }
}