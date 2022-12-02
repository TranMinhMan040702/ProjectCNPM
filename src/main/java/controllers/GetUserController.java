package controllers;


import entity.User;
import models.UserModel;
import service.UserService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = {"/sinhvien/account", "/giangvien/account", "/truongbomon/account"})
public class GetUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserModel userModel = (UserModel)SessionUtil.getInstance().getValue(request,"USERMODEL");
        String date1;
        date1 = new SimpleDateFormat("yyyy-MM-dd").format(userModel.getBirthday());
        request.setAttribute("birthday",date1);
        request.setAttribute("user", userModel);
//        request.getRequestDispatcher("/login").forward(request, response);
        request.getRequestDispatcher("/views/user/profile.jsp").forward(request, response);
    }
}