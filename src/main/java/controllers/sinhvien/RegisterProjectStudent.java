package controllers.sinhvien;

import entity.ProjectStudent;
import entity.ProjectLecturers;
import entity.User;
import models.ProjectLecturersModel;
import models.ProjectStudentModel;
import models.RegistrationPeriodModel;
import models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import service.ProjectLecturersService;
import service.ProjectStudentService;
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

@WebServlet("/sinhvien/registration/create")
public class RegisterProjectStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ProjectStudentModel projectStudentModel = new ProjectStudentModel();
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        User user = new User();
        try {
            BeanUtils.copyProperties(user, userModel);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        ProjectLecturersService projectLecturersService = new ProjectLecturersService();
        ProjectLecturersModel projectLecturersModel = projectLecturersService.getUser(Integer.parseInt(request.getParameter("id")));
        ProjectLecturers projectLecturers = new ProjectLecturers();
        try {
            BeanUtils.copyProperties(projectLecturers, projectLecturersModel);
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
            projectStudentModel.setCreateAt(date2);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        projectStudentModel.setStatus("Chưa được duyệt");
        projectStudentModel.setUser(user);
        projectStudentModel.setProjectLecturers(projectLecturers);

        ProjectStudentService projectStudentService = new ProjectStudentService();

        RegistrationPeriodService registrationPeriodService = new RegistrationPeriodService();
        RegistrationPeriodModel registrationPeriodModel = registrationPeriodService.getByRole(userModel.getRole());
        if ((date2.after(registrationPeriodModel.getStartday()) && date2.before(registrationPeriodModel.getEndday())) && registrationPeriodModel != null)
        {
            projectStudentService.create(projectStudentModel);
            response.sendRedirect(request.getContextPath()+"/sinhvien/registration/change");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/sinhvien/registration/change?message=register_error");
        }
    }
}
