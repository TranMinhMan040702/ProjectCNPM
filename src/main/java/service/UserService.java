package service;

import dao.IUserDAO;
import dao.UserDAO;
import entity.User;
import models.LoginModel;
import models.UserModel;

import javax.servlet.ServletException;
import java.io.IOException;

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
}
