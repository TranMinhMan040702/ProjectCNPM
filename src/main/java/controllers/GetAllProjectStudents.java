package controllers;

import models.ProjectStudentModel;
import models.RegistrationPeriodModel;
import models.UserModel;
import service.BrowseProjectService;
import service.ProjectStudentService;
import service.RegistrationPeriodService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/truongbomon/duyetdetai"})
public class GetAllProjectStudents extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public GetAllProjectStudents(){super();}
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ProjectStudentService projectStudentService = new ProjectStudentService();
        List<ProjectStudentModel> projectStudentModelList= projectStudentService.getAll();
        request.setAttribute("projectStudentModelList", projectStudentModelList);
        System.out.println(projectStudentModelList.size());
        request.getRequestDispatcher("../views/user/truongbomon/censor-project.jsp").forward(request, response);
    }
}
