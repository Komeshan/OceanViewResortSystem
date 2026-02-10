package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Guest;
import dao.GuestDAO;

@WebServlet("/guest")
public class GuestController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String contact = request.getParameter("contact");

            Guest g = new Guest(name, address, contact);
            GuestDAO.addGuest(g);

            response.sendRedirect("html/add_guest.html?success=true");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("html/add_guest.html?error=true");
        }
    }
}
