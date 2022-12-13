package controllers.truongbomon;

import models.ProjectStudentModel;
import models.UserModel;
import service.BrowseProjectService;
import service.ProjectStudentService;
import service.UserService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/truongbomon/browse-project"})
public class GetAllProjectStudents extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public GetAllProjectStudents(){super();}
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        BrowseProjectService browseProjectService = new BrowseProjectService();
        List<ProjectStudentModel> projectStudentModelList = browseProjectService.getAllProjectStudentModels(userModel.getDepartment());
        request.setAttribute("projectStudentModelList", projectStudentModelList);
        request.getRequestDispatcher("../views/user/truongbomon/censor-project.jsp").forward(request, response);
    }
}
