package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-home", "/sinhvien", "/giangvien", "/truongbomon"})
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("admin-home")) {
            req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
        } else if (url.contains("sinhvien")) {
            req.getRequestDispatcher("/views/web/SinhVien/home.jsp").forward(req, resp);
        } else if (url.contains("giangvien")) {
            req.getRequestDispatcher("/views/web/GiangVien/home.jsp").forward(req, resp);
        } else if (url.contains("truongbomon")) {
            req.getRequestDispatcher("/views/web/TruongBoMon/home.jsp").forward(req, resp);
        }

    }
}
