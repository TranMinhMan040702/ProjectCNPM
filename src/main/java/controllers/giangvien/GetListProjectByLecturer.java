package controllers.giangvien;

import models.ProjectStudentModel;
import models.UserModel;
import service.ReviewService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "/giangvien/review")
public class GetListProjectByLecturer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetListProjectByLecturer(){super();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ReviewService reviewService = new ReviewService();
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        List<ProjectStudentModel> projectStudentModels = reviewService.GetList(userModel.getUsername());
        request.setAttribute("projectStudentModels", projectStudentModels);
        request.getRequestDispatcher("/views/user/giangvien/review.jsp").forward(request, response);
    }
}
