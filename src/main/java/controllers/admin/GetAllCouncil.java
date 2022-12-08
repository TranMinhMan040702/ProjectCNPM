package controllers.admin;

import models.CouncilModel;
import models.ProjectLecturersModel;
import service.CouncilService;
import service.ProjectLecturersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/council")
public class GetAllCouncil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CouncilService councilService = new CouncilService();
        ProjectLecturersService projectLecturersService = new ProjectLecturersService();
        List<CouncilModel> councilModelList = councilService.ListCouncil();
        List<ProjectLecturersModel> projectLecturersModels = projectLecturersService.GetAll();
        System.out.println(projectLecturersModels);
        request.setAttribute("projectlecturers", projectLecturersModels);
        request.setAttribute("councilList", councilModelList);
        request.getRequestDispatcher("../views/admin/manager-council.jsp").forward(request, response);;
    }
}
