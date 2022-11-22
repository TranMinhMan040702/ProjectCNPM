package service;

import dao.IUserDAO;
import dao.UserDAO;
import entity.User;
import models.LoginModel;

public class UserService implements IUserService{
    IUserDAO userDAO = new UserDAO();
    @Override
    public LoginModel login(String username, String password) {
        return userDAO.login(username, password);
    }
}
