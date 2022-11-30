package service;

import dao.IUserDAO;
import dao.UserDAO;
import entity.User;
import models.LoginModel;
import models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserService implements IUserService{
    IUserDAO userDAO = new UserDAO();
    @Override
    public LoginModel login(String username, String password) {
        return userDAO.login(username, password);
    }

    public UserModel getUser (String username){
        return userDAO.get(username);
    }

    public List<UserModel> getAllUser(){return userDAO.getAll();}
    @Override
    public void create(UserModel userModel) {
        userDAO.create(userModel);
    }

    public static void main(String[] args) {
        String username = "20110677";
        UserService userService = new UserService();
        UserModel userModel = userService.getUser(username);
        System.out.println(userModel.getFullname());
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = new User();
        String username = request.getParameter("username");
        UserModel userModel = userDAO.get(username);
        userModel.setFullname(request.getParameter("fullname"));
        userModel.setMale(request.getParameter("male"));
        userModel.setEmail(request.getParameter("email"));
        //userModel.setBirthday(request.getParameter("birthday"));

        userModel.setAddress(request.getParameter("address"));
        userModel.setPhone(request.getParameter("phone"));
        userModel.setSchoolyear(request.getParameter("schoolyear"));
        userModel.setDepartment(request.getParameter("department"));
        String birthday = request.getParameter("birthday");
        try {
            Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            userModel.setBirthday(date1);
        } catch (ParseException e) {

            throw new RuntimeException(e);
        }

        user.setAddress(userModel.getAddress());
        user.setBirthday(userModel.getBirthday());
        user.setPassword(userModel.getPassword());
        user.setDepartment(userModel.getDepartment());
        user.setRole(userModel.getRole());
        user.setEmail(userModel.getEmail());
        user.setFullname(userModel.getFullname());
        user.setMale(userModel.getMale());
        user.setUsername(userModel.getUsername());
        user.setPhone(userModel.getPhone());
        user.setSchoolyear(userModel.getSchoolyear());
        userDAO.update(user);
        response.sendRedirect("../account");
    }


}
