package service;

import entity.User;
import models.LoginModel;
import models.UserModel;

public interface IUserService {
    LoginModel login(String username, String password);
    UserModel getUser (String username);
}
