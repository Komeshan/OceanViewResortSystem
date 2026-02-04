package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/oceanview_resort?useSSL=false&serverTimezone=UTC";
                String username = "root";  // your MySQL username
                String password = "Ocean@123"; // your MySQL password

                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Database connected successfully!");
            } catch (SQLException e) {
                System.out.println("Error connecting to database:");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
