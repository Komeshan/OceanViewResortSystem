package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ReservationDAO;
import model.Reservation;

@WebServlet("/reservation/view")
public class ViewReservationController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Reservation r = ReservationDAO.getReservationByNumber(id);

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

            if(r != null) {
                out.print("{");
                out.print("\"reservationNumber\":" + r.getReservationNumber() + ",");
                out.print("\"guestName\":\"" + r.getGuestName() + "\",");
                out.print("\"address\":\"" + r.getAddress() + "\",");
                out.print("\"contact\":\"" + r.getContact() + "\",");
                out.print("\"roomType\":\"" + r.getRoomType() + "\",");
                out.print("\"checkIn\":\"" + r.getCheckIn() + "\",");
                out.print("\"checkOut\":\"" + r.getCheckOut() + "\"");
                out.print("}");
            } else {
                out.print("{}");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
