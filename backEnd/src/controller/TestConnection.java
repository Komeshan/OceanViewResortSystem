package controller;
import dao.DBConnection;

public class TestConnection {
    public static void main(String[] args) {
        DBConnection.getConnection();
    }
}
