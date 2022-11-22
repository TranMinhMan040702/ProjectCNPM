package service;

import entity.User;
import models.LoginModel;

public interface IUserService {
    LoginModel login(String username, String password);
}
