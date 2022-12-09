package controllers.admin;

import entity.ProjectLecturers;
import entity.ProjectStudent;
import models.CouncilModel;
import models.ProjectLecturersModel;
import models.ProjectStudentModel;
import org.apache.commons.beanutils.BeanUtils;
import service.CouncilService;
import service.ProjectLecturersService;
import service.ProjectStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/admin/council/create")
public class CreateCouncil extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CouncilModel councilModel = new CouncilModel();
        int projectid = Integer.parseInt(request.getParameter("projectid"));
        int numberLecturers = Integer.parseInt(request.getParameter("numberLecturers"));
        String date = request.getParameter("date");
        ProjectStudentService projectStudentService = new ProjectStudentService();
        ProjectStudentModel projectStudentModel = projectStudentService.getStudent(projectid);
        ProjectStudent projectStudent = new ProjectStudent();
        try {
            BeanUtils.copyProperties(projectStudent, projectStudentModel);
            councilModel.setProjectStudent(projectStudent);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        try {
            Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(date);
            councilModel.setDateCounterArgument(date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        councilModel.setStatus("Chưa phân công");
        councilModel.setNumberLecturers(numberLecturers);
        CouncilService councilService = new CouncilService();
        councilService.create(councilModel);
        response.sendRedirect("../council?message=create");
    }
}
