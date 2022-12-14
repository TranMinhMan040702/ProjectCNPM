package dao;

import models.LoginModel;
import models.UserModel;

import java.util.List;

public interface IUserDAO {
    LoginModel login(String username, String password, String role);

    void create(UserModel userModel);

    UserModel get(String username);

    void delete(String id);

    List<UserModel> getAll();
    List<UserModel> GetList(String username, String department);

    List<UserModel> getListSearch(String username, String search, String department);
    void update(UserModel userModel);

}
