package controllers.admin;

import dao.UserDAO;
import models.ProjectLecturersModel;
import models.ProjectStudentModel;
import service.ProjectLecturersService;
import service.ProjectStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/account/delete")
public class DeleteAccountController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDAO userDAO = new UserDAO();
        userDAO.delete(id);
        response.sendRedirect("../account");
    }
}
