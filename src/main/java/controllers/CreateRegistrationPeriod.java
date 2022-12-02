package controllers;

import models.RegistrationPeriodModel;
import service.RegistrationPeriodService;

import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/admin/createregistrationperiod")
public class CreateRegistrationPeriod extends HttpServlet {
    RegistrationPeriodService registrationPeriodService = new RegistrationPeriodService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegistrationPeriodModel registrationPeriodModel = new RegistrationPeriodModel();
        String start = req.getParameter("startday");
        String end = req.getParameter("endday");
        try {
            Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
            Date enddate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
            registrationPeriodModel.setStartday(startdate);
            registrationPeriodModel.setEndday(enddate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        registrationPeriodModel.setRole(req.getParameter("role"));
        registrationPeriodService.create(registrationPeriodModel);
        resp.sendRedirect("../admin/create-registration");
    }
}