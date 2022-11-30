package controllers;

import service.IRegistrationPeriodService;
import service.RegistrationPeriodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/registration_period/delete"})
public class DeleteRegistrationPeriod extends HttpServlet {
    IRegistrationPeriodService registrationPeriodService = new RegistrationPeriodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        registrationPeriodService.delete(id);
        resp.sendRedirect("/admin/registration_period");
    }
}
