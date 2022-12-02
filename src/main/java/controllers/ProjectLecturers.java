package controllers;

import dao.ProjectLecturersDAO;
import models.ProjectLecturersModel;
import models.UserModel;
import service.ProjectLecturersService;
import service.UserService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/giangvien/registration")
public class ProjectLecturers extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        ProjectLecturersService projectLecturersService = new ProjectLecturersService();
        List<ProjectLecturersModel> projectLecturersModels =projectLecturersService.GetList(userModel.getUsername());
        request.setAttribute("projectLecturersDAOS", projectLecturersModels);
        request.setAttribute("lecturers", userModel);
        request.setAttribute("action", "create");
        String message = request.getParameter("message");
        if(message != null){
            request.setAttribute("message", message);
        }
        request.getRequestDispatcher("/views/user/giangvien/project-registration.jsp").forward(request, response);

    }
}
