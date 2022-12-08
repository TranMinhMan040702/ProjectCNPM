package dao;

import models.LoginModel;
import models.UserModel;

import java.util.List;

public interface IUserDAO {
    LoginModel login(String username, String password, String role);
    void create(UserModel userModel);
    UserModel get(String username);
    void update(UserModel user);

    List<UserModel> getAll();
}
