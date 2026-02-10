package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Reservation;
import dao.ReservationDAO;

@WebServlet("/reservation")
public class ReservationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int resNumber = Integer.parseInt(request.getParameter("reservationNumber"));
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String contact = request.getParameter("contact");
            String roomType = request.getParameter("roomType");
            String checkIn = request.getParameter("checkIn");
            String checkOut = request.getParameter("checkOut");

            Reservation res = new Reservation(resNumber, name, address, contact, roomType, checkIn, checkOut);
            ReservationDAO.addReservation(res);

            response.sendRedirect("html/reservation.html?success=true");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("html/reservation.html?error=true");
        }
    }
}
