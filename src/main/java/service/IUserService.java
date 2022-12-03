package service;

import entity.User;
import models.LoginModel;
import models.UserModel;

public interface IUserService {
    LoginModel login(String username, String password, String role);
    UserModel getUser (String username);
    void create(UserModel userModel);
}
