package service;

import models.LoginModel;
import models.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IUserService {
    LoginModel login(String username, String password);

    UserModel getUser(String username);

    void create(UserModel userModel);

    void update(HttpServletRequest request, HttpServletResponse response);

    void updateUser(UserModel userModel);

    List<UserModel> getAllUser();
}
