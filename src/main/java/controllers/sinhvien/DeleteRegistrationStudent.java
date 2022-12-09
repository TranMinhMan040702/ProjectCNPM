package controllers.sinhvien;

import dao.ProjectLecturersDAO;
import dao.ProjectStudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sinhvien/registration/delete")
public class DeleteRegistrationStudent extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ProjectStudentDAO projectStudentDAO = new ProjectStudentDAO();
        projectStudentDAO.delete(Integer.parseInt(id));
        response.sendRedirect("../registration/change");
    }
}
