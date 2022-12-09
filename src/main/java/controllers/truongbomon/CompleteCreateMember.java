package controllers.truongbomon;

import models.CouncilModel;
import service.CouncilService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/truongbomon/council/create/complete")
public class CompleteCreateMember extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idCouncil"));
        CouncilService councilService = new CouncilService();

        CouncilModel councilModel = councilService.get(id);
        councilModel.setStatus("Đã được phân công");
        councilService.update(councilModel);
        response.sendRedirect("../../council");
    }
}
