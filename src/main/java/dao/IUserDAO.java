package dao;

import entity.User;
import models.LoginModel;
import models.UserModel;

import java.util.List;

public interface IUserDAO {
    LoginModel login(String username, String password);
    void create(UserModel userModel);
    UserModel get(String username);
    void update(User user);

    List<UserModel> getAll();
}
