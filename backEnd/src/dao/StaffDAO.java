package dao;

import model.Staff;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {

    public static void addStaff(Staff s) throws SQLException {
        String sql = "INSERT INTO staff (name, username, password) VALUES (?,?,?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getUsername());
            ps.setString(3, s.getPassword());

            ps.executeUpdate();
        }
    }

    public static List<Staff> getAllStaff() throws SQLException {
        List<Staff> list = new ArrayList<>();
        String sql = "SELECT * FROM staff";

        try(Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)) {

            while(rs.next()) {
                Staff s = new Staff(
                    rs.getString("name"),
                    rs.getString("username"),
                    rs.getString("password")
                );
                list.add(s);
            }
        }
        return list;
    }
}