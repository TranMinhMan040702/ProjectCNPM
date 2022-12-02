package controllers;

import dao.ProjectLecturersDAO;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/giangvien/registration/delete")
public class DeleteRegistrationLecturers extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProjectLecturersDAO projectLecturersDAO = new ProjectLecturersDAO();
        projectLecturersDAO.delete(Integer.parseInt(id));
        response.sendRedirect("../registration");
    }
}
