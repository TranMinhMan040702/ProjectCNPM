package dao;

import entity.User;
import models.LoginModel;

public interface IUserDAO {
    LoginModel login(String username, String password);
}
