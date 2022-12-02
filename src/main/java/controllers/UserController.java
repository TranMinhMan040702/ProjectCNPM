package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/home", "/admin/home", "/sinhvien/home", "/giangvien/home",
        "/truongbomon/home", "/admin/create-registration", "/sinhvien/registration",
         "/truongbomon/duyetdetai"}) //"/giangvien/registration",
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getRequestURL().toString();
        if (url.contains("create-registration")) {
            req.getRequestDispatcher("/views/admin/create-registration.jsp").forward(req, resp);
        } else if (url.contains("home")) {
            req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
        } else if (url.contains("sinhvien/registration")) {
            req.getRequestDispatcher("/views/user/sinhvien/project-registration.jsp").forward(req, resp);
        } else if (url.contains("giangvien/registration")) {
            req.getRequestDispatcher("/views/user/giangvien/project-registration.jsp").forward(req, resp);
        } else if (url.contains("/truongbomon/duyetdetai")) {
            req.getRequestDispatcher("/views/user/truongbomon/censor-project.jsp").forward(req, resp);
        }
    }
}
