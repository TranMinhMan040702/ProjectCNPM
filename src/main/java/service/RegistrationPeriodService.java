package service;

import dao.IRegistrationPeriodDAO;
import dao.RegistrationPeriodDAO;
import entity.RegistrationPeriod;
import models.RegistrationPeriodModel;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationPeriodService implements IRegistrationPeriodService {
    IRegistrationPeriodDAO registrationPeriodDAO = new RegistrationPeriodDAO();
    @Override
    public void create(RegistrationPeriodModel registrationPeriodModel) {
        registrationPeriodDAO.create(registrationPeriodModel);
    }

    @Override
    public RegistrationPeriodModel getRegistrationPeriod(int Id){
        return registrationPeriodDAO.get(Id);
    }

    @Override
    public void delete(int Id) {
        registrationPeriodDAO.delete(Id);
    }

    @Override
    public void update(@NotNull HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        RegistrationPeriod registrationPeriod = new RegistrationPeriod();
        int id = Integer.parseInt(request.getParameter("id")); //Không thay đổi giá trị Id trên form
        RegistrationPeriodModel registrationPeriodModel = registrationPeriodDAO.get(id); // Lấy được cái model thông qua id
        String startdate = request.getParameter("startday");
        String enddate = request.getParameter("startday");
        try {
            Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startdate);
            registrationPeriodModel.setStartday(start);
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(enddate);
            registrationPeriodModel.setEndday(end);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        registrationPeriodModel.setRole(request.getParameter("role"));
        registrationPeriodModel.setDepartment(request.getParameter("department"));
        registrationPeriodModel.setTitle(request.getParameter("title"));


        registrationPeriod.setId(registrationPeriodModel.getId()); //Lấy lại Id củ
        registrationPeriod.setDepartment(registrationPeriodModel.getDepartment());
        registrationPeriod.setEndday(registrationPeriodModel.getEndday());
        registrationPeriod.setRole(registrationPeriodModel.getRole());
        registrationPeriod.setTitle(registrationPeriodModel.getTitle());

        registrationPeriodDAO.update(registrationPeriod);
        response.sendRedirect("../registration_period");
    }
}
