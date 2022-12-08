package controllers.admin;

import models.CouncilModel;
import models.UserModel;
import service.CouncilService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/admin/council/update")
public class UpdateCouncil extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        CouncilService councilService = new CouncilService();
        List<CouncilModel> councilModelList = councilService.ListCouncil();
        int id = Integer.parseInt(request.getParameter("id"));
        CouncilModel councilModel = councilService.get(id);
        String date1;
        date1 = new SimpleDateFormat("yyyy-MM-dd").format(councilModel.getDateCounterArgument());
        request.setAttribute("date",date1);
        request.setAttribute("council", councilModel);
        request.setAttribute("action", "update");
        request.setAttribute("councilList", councilModelList);
        request.getRequestDispatcher("/views/admin/manager-council.jsp").forward(request, response);
    }
}
