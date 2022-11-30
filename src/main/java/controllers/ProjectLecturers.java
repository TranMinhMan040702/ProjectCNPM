package controllers;

import models.UserModel;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/giangvien/registration")
public class ProjectLecturers extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "1234";
        UserService userService = new UserService();
        UserModel userModel = userService.getUser(username);
        request.setAttribute("lecturers", userModel);
        request.getRequestDispatcher("/views/user/giangvien/project-registration.jsp").forward(request, response);
    }
}
