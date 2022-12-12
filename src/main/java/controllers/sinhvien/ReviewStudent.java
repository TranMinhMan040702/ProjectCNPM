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
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/sinhvien/review")
public class ReviewStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        ProjectStudentService projectStudentService = new ProjectStudentService();
        ProjectStudentModel projectStudentModel = projectStudentService.Get(userModel.getUsername());

        request.setAttribute("projectStudent",projectStudentModel);

        request.getRequestDispatcher("/views/user/sinhvien/review.jsp").forward(request, response);
    }
}
