package dao;

import models.LoginModel;
import models.UserModel;

public interface IUserDAO {
    LoginModel login(String username, String password);
    void create(UserModel userModel);
    UserModel get(String username);
    void update(UserModel user);
}
