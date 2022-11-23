package controllers;

import models.LoginModel;
import service.IUserService;
import service.UserService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/logout"})
public class LoginController extends HttpServlet {
    IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("login")) {
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else if (url.contains("logout")) {
            SessionUtil.getInstance().removeValue(req, "USERMODEL");
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("login")) {
            LoginModel model = userService.login(req.getParameter("username"), req.getParameter("password"));
            System.out.println(model.getRole());
            if (model != null) {
                SessionUtil.getInstance().putValue(req, "USERMODEL", model);
                if (model.getRole().equals("sinhvien")) {
                    resp.sendRedirect(req.getContextPath() + "/sinhvien");
                } else if (model.getRole().equals("giangvien")) {
                    resp.sendRedirect(req.getContextPath() + "/giangvien");
                } else if (model.getRole().equals("truongbomon")) {
                    resp.sendRedirect(req.getContextPath() + "/truongbomon");
                } else if (model.getRole().equals("admin")) {
                    resp.sendRedirect(req.getContextPath() + "/admin-home");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/login");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        }
    }
}
