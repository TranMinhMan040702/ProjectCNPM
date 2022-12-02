package service;

import dao.BrowseProjectDAO;
import dao.IBrowseProjectDAO;
import entity.ProjectStudent;
import models.ProjectStudentModel;
import models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BrowseProjectService implements IBrowseProjectService {
    IBrowseProjectDAO browseProjectDAO = new BrowseProjectDAO();

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ProjectStudent projectStudent = new ProjectStudent();
        int id = Integer.parseInt(request.getParameter("id"));
        ProjectStudentModel projectStudentModel = browseProjectDAO.get(id); // Lấy được cái model thông qua id

        projectStudentModel.setStatus(request.getParameter("status"));

        projectStudent.setStatus(projectStudentModel.getStatus());

        browseProjectDAO.update(projectStudent);
        response.sendRedirect("../browse_project");
    }
    public List<ProjectStudentModel> getAllProjectStudentModels(){return browseProjectDAO.getAll();}
}