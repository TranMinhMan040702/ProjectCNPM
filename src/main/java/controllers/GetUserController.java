package controllers;


import entity.User;
import models.UserModel;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = {"/sinhvien/account", "/giangvien/account", "/truongbomon/account"})
public class GetUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String username = request.getParameter("username");
        String username = "20110677";
        UserService userService = new UserService();
        UserModel userModel = userService.getUser(username);
        String date1;
        date1 = new SimpleDateFormat("yyyy-MM-dd").format(userModel.getBirthday());
        request.setAttribute("date1",date1);
        request.setAttribute("user", userModel);
        request.getRequestDispatcher("/login").forward(request, response);
    }
}