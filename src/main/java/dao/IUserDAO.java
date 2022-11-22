package dao;

import entity.User;
import models.LoginModel;
import models.UserModel;

public interface IUserDAO {
    LoginModel login(String username, String password);
    UserModel get(String username);
}
