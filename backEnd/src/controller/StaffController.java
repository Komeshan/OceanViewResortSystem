package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import dao.StaffDAO;
import model.Staff;

@WebServlet("/staff")
public class StaffController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("staffName");
            String username = request.getParameter("staffUsername");
            String password = request.getParameter("staffPassword");

            Staff s = new Staff(name, username, password);
            StaffDAO.addStaff(s);

            response.sendRedirect("staff.html?success=true");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("staff.html?error=true");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Staff> staffList = StaffDAO.getAllStaff();

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

            out.print("[");
            for (int i = 0; i < staffList.size(); i++) {
                Staff s = staffList.get(i);
                out.print("{\"name\":\"" + s.getName() + "\",\"username\":\"" + s.getUsername() + "\"}");
                if(i < staffList.size() - 1) out.print(",");
            }
            out.print("]");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}