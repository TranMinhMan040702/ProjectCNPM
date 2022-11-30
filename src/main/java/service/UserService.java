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
    public void update(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        UserModel userModel = userDAO.get(username);
        userModel.setPassword(request.getParameter("password"));
        userModel.setFullname(request.getParameter("fullname"));
        userModel.setMale(request.getParameter("male"));
        userModel.setEmail(request.getParameter("email"));
        userModel.setAddress(request.getParameter("address"));
        userModel.setPhone(request.getParameter("phone"));
        String birthday = request.getParameter("birthday");
        try {
            Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            userModel.setBirthday(date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);

        }
        userDAO.update(userModel);
    }

    public List<UserModel> getAllUser(){return userDAO.getAll();}
}
