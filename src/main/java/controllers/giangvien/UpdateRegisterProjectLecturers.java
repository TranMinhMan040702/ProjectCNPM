package controllers.giangvien;

import models.ProjectLecturersModel;
import models.UserModel;
import service.ProjectLecturersService;
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

@WebServlet("/giangvien/registration/update")
public class UpdateRegisterProjectLecturers extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        int id = Integer.parseInt(request.getParameter("id"));
        ProjectLecturersService projectLecturersService = new ProjectLecturersService();
        ProjectLecturersModel projectLecturersModel = projectLecturersService.getUser(id);
        List<ProjectLecturersModel> projectLecturersModels =projectLecturersService.GetList(userModel.getUsername());
        request.setAttribute("projectLecturersDAOS", projectLecturersModels);
        request.setAttribute("projectLecturersModel", projectLecturersModel);
        request.setAttribute("action", "update");
        request.setAttribute("lecturers", userModel);
        request.getRequestDispatcher("/views/user/giangvien/project-registration.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String topic = request.getParameter("topic");
        String requestParameter = request.getParameter("request");
        String target = request.getParameter("target");
        int id = Integer.parseInt(request.getParameter("id"));
        ProjectLecturersService projectLecturersService = new ProjectLecturersService();
        ProjectLecturersModel projectLecturersModel = projectLecturersService.getUser(id);
        projectLecturersModel.setTopic(topic);
        projectLecturersModel.setRequest(requestParameter);
        projectLecturersModel.setTarget(target);
        projectLecturersService.update(projectLecturersModel);
        response.sendRedirect("../registration");
    }
}
