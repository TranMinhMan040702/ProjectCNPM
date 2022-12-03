package controllers;

import models.RegistrationPeriodModel;
import service.RegistrationPeriodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@WebServlet(urlPatterns = {"/admin/registration_period/edit"})
public class UpdateRegistrationPeriod extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("registrationPeriodModel", registrationPeriodModel);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegistrationPeriodService registrationPeriodService = new RegistrationPeriodService();
        registrationPeriodService.update(req, resp);
        resp.sendRedirect("./admin/create_registration_period");
    }
}