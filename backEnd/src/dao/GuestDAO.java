package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Guest;

public class GuestDAO {
    public static void addGuest(Guest g) throws SQLException {
        String sql = "INSERT INTO guests (name, address, contact) VALUES (?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, g.getName());
            ps.setString(2, g.getAddress());
            ps.setString(3, g.getContact());

            ps.executeUpdate();
        }
    }
}
