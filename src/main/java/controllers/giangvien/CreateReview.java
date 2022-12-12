package controllers.giangvien;

import models.ProjectStudentModel;
import service.ProjectStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/giangvien/review/create")
public class CreateReview extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id  = Integer.parseInt(request.getParameter("idProject"));

        ProjectStudentService projectStudentService = new ProjectStudentService();
        ProjectStudentModel projectStudentModel = projectStudentService.getStudent(id);

        String review = request.getParameter("review");
        int point = Integer.parseInt(request.getParameter("point"));
        projectStudentModel.setReviews(review);
        projectStudentModel.setPoint(point);

        projectStudentService.update(projectStudentModel);

        response.sendRedirect("../review");
    }
}
