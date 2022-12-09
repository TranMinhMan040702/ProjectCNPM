package controllers.truongbomon;

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
import java.util.List;

@WebServlet("/truongbomon/council/create")
public class CreateMemberCouncil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id =  Integer.parseInt(request.getParameter("id"));


        CouncilService councilService = new CouncilService();
        CouncilModel councilModel = councilService.get(id);
        String idLecturers = councilModel.getProjectStudent().getProjectLecturers().getUser().getUsername();

        UserService userService = new UserService();
        List<UserModel> lecturersList = userService.getLecturers(idLecturers);


        request.setAttribute("action", "create");
        request.setAttribute("lecturersList", lecturersList);
        request.getRequestDispatcher("../../views/user/truongbomon/manager-council.jsp").forward(request, response);;

    }
}
