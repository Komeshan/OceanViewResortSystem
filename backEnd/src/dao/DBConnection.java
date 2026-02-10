package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/oceanview_resort"; // replace with your DB name
    private static final String USER = "root"; // replace with your DB username
    private static final String PASSWORD = "Ocean@123"; // replace with your DB password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
