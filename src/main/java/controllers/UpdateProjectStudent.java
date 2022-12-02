package controllers;

import models.ProjectLecturersModel;
import models.ProjectStudentModel;
import models.UserModel;
import service.ProjectLecturersService;
import service.ProjectStudentService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/truongbomon/browse-project/update")
public class UpdateProjectStudent extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        ProjectStudentService projectStudentService = new ProjectStudentService();
        ProjectStudentModel projectStudentModel = projectStudentService.getStudent(id);
        if(action.equals("duyet")){
            projectStudentModel.setStatus("Đã được duyệt");
        }
        else {
            projectStudentModel.setStatus("Không được duyệt");
        }
        projectStudentService.update(projectStudentModel);
        response.sendRedirect("../browse-project");
    }
}
