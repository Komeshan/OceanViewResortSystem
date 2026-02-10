package controller;
import dao.DBConnection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try {
            DBConnection.getConnection();
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}