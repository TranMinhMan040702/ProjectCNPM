package controllers;

import models.UserModel;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = {"/sinhvien/account/edit", "/giangvien/account/edit", "/truongbomon/account/edit", "/edit"})
public class UpdateInforController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserModel userModel = new UserModel();
        userModel.setUsername(request.getParameter("username"));
        userModel.setPassword(request.getParameter("password"));
        userModel.setFullname(request.getParameter("fullname"));
        userModel.setMale(request.getParameter("male"));
        userModel.setEmail(request.getParameter("email"));
        //userModel.setBirthday(request.getParameter("birthday"));
        userModel.setAddress(request.getParameter("address"));
        userModel.setPhone(request.getParameter("phone"));
        userModel.setSchoolyear(request.getParameter("schoolyear"));
        userModel.setDepartment(request.getParameter("department"));
        userModel.setRole(request.getParameter("role"));
        String availableDate = request.getParameter("availableDate");
        try {
            Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(availableDate);
            userModel.setBirthday(date1);
        } catch (ParseException e) {

            throw new RuntimeException(e);
        }
        request.setAttribute("userModel", userModel);
        //request.getRequestDispatcher("/index.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();
        userService.update(request,response);
//        response.sendRedirect("/admin/account");
    }
}
