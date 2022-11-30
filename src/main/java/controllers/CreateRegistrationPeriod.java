package controllers;

import models.RegistrationPeriodModel;

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

@WebServlet(urlPatterns = {"/admin/create-registration_period"})
public class CreateRegistrationPeriod extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegistrationPeriodModel registrationPeriodModel = new RegistrationPeriodModel();
        try {
            String start = req.getParameter("startday");
            String end = req.getParameter("endday");
            String ID = req.getParameter("id");
            try {
                int Id = Integer.parseInt(ID);
                Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
                Date enddate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
                registrationPeriodModel.setId(Id);
                registrationPeriodModel.setStartday(startdate);
                registrationPeriodModel.setEndday(enddate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            registrationPeriodModel.setRole(req.getParameter("role"));
            registrationPeriodModel.setDepartment(req.getParameter("department"));
            registrationPeriodModel.setTitle(req.getParameter("title"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        resp.sendRedirect("./registration_period");
    }
}
