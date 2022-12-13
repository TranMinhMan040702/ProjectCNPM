package controllers.giangvien;

import dao.ProjectLecturersDAO;
import entity.User;
import models.ProjectLecturersModel;
import models.RegistrationPeriodModel;
import models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import service.ProjectLecturersService;
import service.RegistrationPeriodService;
import service.UserService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/giangvien/registration/create")
public class RegisterProjectLecturers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        ProjectLecturersModel projectLecturersModel = new ProjectLecturersModel();
        User user = new User();
        try {
            BeanUtils.copyProperties(user, userModel);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ");
        //Date date = formatter;
        String time = current.format(formatter);
        Date date2;
        try {
            date2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").parse(time);
            System.out.println(date2);
            projectLecturersModel.setCreateAt(date2);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        projectLecturersModel.setTopic(request.getParameter("topic"));
        projectLecturersModel.setDepartment(request.getParameter("department"));
        projectLecturersModel.setUser(user);
        projectLecturersModel.setRequest(request.getParameter("request"));
        projectLecturersModel.setTarget(request.getParameter("target"));
        ProjectLecturersService projectLecturersService = new ProjectLecturersService();

        RegistrationPeriodService registrationPeriodService = new RegistrationPeriodService();
        RegistrationPeriodModel registrationPeriodModel = registrationPeriodService.getByRole(userModel.getRole());

        if(registrationPeriodModel == null){
            response.sendRedirect(request.getContextPath()+"/giangvien/registration?message=register_error");
        }
        else if ((date2.after(registrationPeriodModel.getStartday()) && date2.before(registrationPeriodModel.getEndday())) && registrationPeriodModel != null)
        {
            projectLecturersService.create(projectLecturersModel);
            response.sendRedirect(request.getContextPath()+"/giangvien/registration");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/giangvien/registration?message=register_error");
        }

    }
}
