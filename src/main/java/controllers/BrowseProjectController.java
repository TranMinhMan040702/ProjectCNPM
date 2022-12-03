package controllers;

import models.ProjectStudentModel;
import service.BrowseProjectService;
import service.ProjectStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = {"/truongbomon/browseproject"})
public class BrowseProjectController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProjectStudentModel projectStudentModel = new ProjectStudentModel();
        ProjectStudentService projectStudentService = new ProjectStudentService();


        int id = Integer.parseInt(req.getParameter("id"));

        projectStudentModel = projectStudentService.getStudent(id);

        req.setAttribute("projectStudentModel", projectStudentModel);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BrowseProjectService browseProjectService = new BrowseProjectService();
        browseProjectService.update(req, resp);
        resp.sendRedirect("../truongbomon/browse-project");
    }
}