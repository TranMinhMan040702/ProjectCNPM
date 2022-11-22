package controllers;


import models.UserModel;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/sinhvien/account", "/giangvien/account", "/truongbomon/account"})
public class GetUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String username = request.getParameter("username");
        String username = "20110677";
        UserService userService = new UserService();
        UserModel userModel = userService.getUser(username);
        request.setAttribute("user", userModel);
        request.getRequestDispatcher("account.jsp").forward(request, response);
    }
}