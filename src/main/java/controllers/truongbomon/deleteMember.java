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

@WebServlet("/truongbomon/council/delete")
public class deleteMember extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idCouncil = Integer.parseInt(request.getParameter("idCouncil"));
        if(request.getParameter("leader").equals("yes")){
            CouncilService councilService = new CouncilService();
            CouncilModel councilModel = councilService.get(idCouncil);
            councilModel.setLeader(null);
            councilService.update(councilModel);
        }
        else {
            int id = Integer.parseInt(request.getParameter("id"));
            MemBerCouncilService memBerCouncilService = new MemBerCouncilService();
            memBerCouncilService.delete(id);
        }
        response.sendRedirect("../council/create?id=" + idCouncil);
    }
}
