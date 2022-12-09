//package controllers.giangvien;
//
//import entity.ProjectStudent;
//import models.ProjectStudentModel;
//import models.UserModel;
//import org.apache.commons.beanutils.BeanUtils;
//import service.ReviewService;
//import service.UserService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@WebServlet(urlPatterns = "/giangvien/review")
//public class ReviewLecturer extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    ReviewService reviewService = new ReviewService();
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        //String username = request.getParameter("username");
//
//        ProjectStudentModel projectStudentModel = reviewService.get("20110609");
//        request.setAttribute("projectStudentModel", projectStudentModel);
//        System.out.println(projectStudentModel.getPoint());
//        request.getRequestDispatcher("/views/user/giangvien/review.jsp").forward(request, response);
//    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        String username = request.getParameter("username");
//        System.out.println(username);
//        ProjectStudentModel projectStudentModel = reviewService.get(username);
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
//        response.sendRedirect("/giangvien/review");
//    }
//}
