package controllers.sinhvien;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/sinhvien/registration/change")
public class ChangeDepartmentController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        ProjectStudentService projectStudentService = new ProjectStudentService();
        ProjectStudentModel projectStudentModel = projectStudentService.Get(userModel.getUsername());


        String department =request.getParameter("department");
        ProjectLecturersService projectLecturersService = new ProjectLecturersService();
        List<ProjectLecturersModel> projectLecturersModels =projectLecturersService.GetListDepartment(department);
        request.setAttribute("projectLecturersModels", projectLecturersModels);
        request.setAttribute("department", department);
        request.setAttribute("projectStudentModel", projectStudentModel);
        String message = request.getParameter("message");
        request.setAttribute("message", message);
        System.out.println(projectStudentModel);
        request.getRequestDispatcher("/views/user/sinhvien/project-registration.jsp").forward(request, response);
    }
}
