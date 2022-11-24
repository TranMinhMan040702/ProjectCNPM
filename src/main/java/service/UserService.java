package service;

import dao.IUserDAO;
import dao.UserDAO;
import models.LoginModel;
import models.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserService implements IUserService{
    IUserDAO userDAO = new UserDAO();
    @Override
    public LoginModel login(String username, String password) {
        return userDAO.login(username, password);
    }

    public UserModel getUser (String username){
        return userDAO.get(username);
    }

    public static void main(String[] args) {
        String username = "20110677";
        UserService userService = new UserService();
        UserModel userModel = userService.getUser(username);
        System.out.println(userModel.getFullname());
    }
    public void update(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        UserModel userModel = userDAO.get(username);
        userModel.setPassword(request.getParameter("password"));
        userModel.setFullname(request.getParameter("fullname"));
        userModel.setMale(request.getParameter("male"));
        userModel.setEmail(request.getParameter("email"));
        //userModel.setBirthday(request.getParameter("birthday"));
        userModel.setAddress(request.getParameter("address"));
        userModel.setPhone(request.getParameter("phone"));
        userModel.setSchoolyear(request.getParameter("schoolyear"));
        userModel.setDepartment(request.getParameter("department"));
        userModel.setRole(request.getParameter("role"));
        String availableDate = request.getParameter("availableDate");
        try {
            Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(availableDate);
            userModel.setBirthday(date1);
        } catch (ParseException e) {

            throw new RuntimeException(e);
        }
        userDAO.update(userModel);
    }
}
