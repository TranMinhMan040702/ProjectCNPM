package service;

import models.RegistrationPeriodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IRegistrationPeriodService {
    void create(RegistrationPeriodModel registrationPeriodModel);

    RegistrationPeriodModel getRegistrationPeriod(int Id);
    void delete(int Id);
    void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}