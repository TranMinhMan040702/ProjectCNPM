package controllers.admin;

import models.CouncilModel;
import models.ProjectLecturersModel;
import models.ProjectStudentModel;
import service.CouncilService;
import service.ProjectLecturersService;
import service.ProjectStudentService;

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
        request.setCharacterEncoding("UTF-8");
        CouncilService councilService = new CouncilService();
        ProjectStudentService projectStudentService = new ProjectStudentService();
        List<CouncilModel> councilModelList = councilService.ListCouncil();
        List<ProjectStudentModel> projectLecturersModels = projectStudentService.GetListByStatusArgument("No", "Đã được duyệt");
        //System.out.println(projectLecturersModels);
        request.setAttribute("action", "create");
        request.setAttribute("project", projectLecturersModels);
        request.setAttribute("councilList", councilModelList);
        request.getRequestDispatcher("../views/admin/manager-council.jsp").forward(request, response);;
    }
}
