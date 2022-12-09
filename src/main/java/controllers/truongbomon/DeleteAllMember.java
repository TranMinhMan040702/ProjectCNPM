package controllers.truongbomon;

import models.CouncilModel;
import service.CouncilService;
import service.MemBerCouncilService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/truongbomon/council/deleteAll")
public class DeleteAllMember extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCouncil = Integer.parseInt(request.getParameter("idCouncil"));
        MemBerCouncilService memBerCouncilService = new MemBerCouncilService();
        memBerCouncilService.deleteAll(idCouncil);


        CouncilService councilService = new CouncilService();

        CouncilModel councilModel = councilService.get(idCouncil);
        councilModel.setStatus("Chưa phân công");
        councilModel.setLeader(null);
        councilService.update(councilModel);
        response.sendRedirect("../council");
    }
}
