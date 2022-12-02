package controllers;

import models.UserModel;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/account")
public class GetAllUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetAllUserController(){super();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserService userService = new UserService();
        List<UserModel> userModelList= userService.getAllUser();
        request.setAttribute("action", "create");
        request.setAttribute("userModelList", userModelList);
        request.getRequestDispatcher("../views/admin/create-account.jsp").forward(request, response);
    }
}