package controllers;

import dao.ProjectLecturersDAO;
import entity.User;
import models.ProjectLecturersModel;
import models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import service.ProjectLecturersService;
import service.UserService;

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
        String username = request.getParameter("username");
        //String username = (String) request.getSession().getAttribute("username");
        ProjectLecturersModel projectLecturersModel = new ProjectLecturersModel();
        UserService userService = new UserService();
        UserModel userModel = userService.getUser(username);
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
        System.out.println(time);
        try {
            Date date2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").parse(time);
            System.out.println(date2);
            projectLecturersModel.setCreateAt(date2);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //projectLecturersModel.setId(1);
        projectLecturersModel.setTopic(request.getParameter("topic"));
        projectLecturersModel.setDepartment(request.getParameter("department"));
        projectLecturersModel.setUser(user);
        projectLecturersModel.setRequest(request.getParameter("request"));
        projectLecturersModel.setTarget(request.getParameter("target"));
        ProjectLecturersService projectLecturersService = new ProjectLecturersService();
        //projectLecturersService.create(projectLecturersModel);
        ProjectLecturersDAO projectLecturersDAO = new ProjectLecturersDAO();
        projectLecturersService.create(projectLecturersModel);
    }
}
