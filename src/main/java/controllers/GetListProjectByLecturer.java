package controllers.giangvien;

import entity.ProjectStudent;
import models.CouncilModel;
import models.ProjectStudentModel;
import models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import service.ProjectStudentService;
import service.ReviewService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/giangvien/review")
public class GetListProjectByLecturer extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ReviewService reviewService = new ReviewService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
            List<CouncilModel> councilModels = reviewService.GetListCouncil(userModel.getUsername());
            List<ProjectStudentModel> projectStudentModels = new ArrayList<>();
            ProjectStudentService projectStudentService = new ProjectStudentService();
            for (CouncilModel councilModel : councilModels) {
                ProjectStudentModel projectStudentModel = projectStudentService.getStudent(councilModel.getProjectStudent().getId());
                projectStudentModels.add(projectStudentModel);
            }
            request.setAttribute("projectStudentModels", projectStudentModels);
            request.getRequestDispatcher("/views/user/giangvien/review.jsp").forward(request, response);
        } else {
            String username = request.getParameter("username");
            System.out.println(username);

        }

    }
    protected void getUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = "";
        System.out.println(username);
        ProjectStudentModel projectStudentModel = reviewService.getByProject(username);
        projectStudentModel.setPoint(Integer.parseInt(request.getParameter("scores")));
        projectStudentModel.setReviews(request.getParameter("review"));
        ProjectStudent projectStudent = new ProjectStudent();
        try {
            BeanUtils.copyProperties(projectStudent, projectStudentModel);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        reviewService.update(projectStudent);
        System.out.println(projectStudent.getPoint());
        response.sendRedirect("/giangvien/review");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        String username = request.getParameter("username");
////        username = "20110609";
//        System.out.println(username);
//        ProjectStudentModel projectStudentModel = reviewService.getByProject(username);
//        projectStudentModel.setPoint(Integer.parseInt(request.getParameter("scores")));
//        projectStudentModel.setReviews(request.getParameter("review"));
//        ProjectStudent projectStudent = new ProjectStudent();
//        try {
//            BeanUtils.copyProperties(projectStudent, projectStudentModel);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//        reviewService.update(projectStudent);
//        System.out.println(projectStudent.getPoint());
//        response.sendRedirect("/giangvien/review");
//    }
    }
}
