package controllers.giangvien;

import models.ProjectStudentModel;
import service.ProjectStudentService;
import service.ReviewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/giangvien/review/at")
public class ReviewController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        ReviewService reviewService = new ReviewService();
        ProjectStudentModel projectStudentModel = reviewService.get(id);
        if(action.equals("duyet")){
            projectStudentModel.setStatus("Đã được duyệt");
        }
        else {
            projectStudentModel.setStatus("Không được duyệt");
        }
        reviewService.update(projectStuden);
        response.sendRedirect("../browse-project");
    }
}
