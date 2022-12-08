package controllers.admin;

import service.CouncilService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/council/delete")
public class DeleteCouncil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idProject= Integer.parseInt(request.getParameter("idProject"));
        CouncilService councilService = new CouncilService();
        councilService.delete(id,idProject);
        response.sendRedirect("../council");
    }
}
