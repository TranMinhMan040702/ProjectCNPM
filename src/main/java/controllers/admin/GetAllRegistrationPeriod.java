package controllers.admin;

import models.RegistrationPeriodModel;
import models.UserModel;
import service.RegistrationPeriodService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = {"/admin/create-registration"})
public class GetAllRegistrationPeriod extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetAllRegistrationPeriod(){super();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RegistrationPeriodService registrationPeriodService = new RegistrationPeriodService();
        List<RegistrationPeriodModel> registrationPeriodModelList= registrationPeriodService.getAll();
        request.setAttribute("registrationPeriodModelList", registrationPeriodModelList);
        request.getRequestDispatcher("../views/admin/create-registration.jsp").forward(request, response);
    }
}
