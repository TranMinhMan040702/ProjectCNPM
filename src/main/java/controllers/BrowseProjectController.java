package controllers;

import models.ProjectStudentModel;
import service.BrowseProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/truongbomon/browse_project"})
public class BrowseProjectController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProjectStudentModel projectStudentModel = new ProjectStudentModel();

        try {
            projectStudentModel.setStatus(req.getParameter("status"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("projectStudentModel", projectStudentModel);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BrowseProjectService browseProjectService = new BrowseProjectService();
        browseProjectService.update(req, resp);
        resp.sendRedirect("./truongbomon/browseproject");
    }
}