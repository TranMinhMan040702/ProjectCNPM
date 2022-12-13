package controllers.truongbomon;

import entity.Council;
import entity.User;
import models.CouncilModel;
import models.MemberCouncilModel;
import models.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import service.CouncilService;
import service.MemBerCouncilService;
import service.UserService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/truongbomon/council/create")
public class CreateMemberCouncil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        String message = request.getParameter("message");
        int id;
        if(request.getParameter("id") != null){
            id =  Integer.parseInt(request.getParameter("id"));
        }
        else
        {
            id =  Integer.parseInt(request.getParameter("idCouncil"));
        }

        CouncilService councilService = new CouncilService();
        CouncilModel councilModel = councilService.get(id);
        String idLecturers = councilModel.getProjectStudent().getProjectLecturers().getUser().getUsername();



        MemBerCouncilService memBerCouncilService = new MemBerCouncilService();
        String action =request.getParameter("action");
        List<MemberCouncilModel> memberCouncilModels;
        memberCouncilModels = memBerCouncilService.getList(id);

        UserService userService = new UserService();
        List<UserModel> lecturersList = userService.getLecturers(idLecturers, userModel.getDepartment());
        if(action != null ){
            String search =request.getParameter("search");
            lecturersList = userService.getListSearch(idLecturers, search, userModel.getDepartment());
        }
        else {
            lecturersList = userService.getLecturers(idLecturers, userModel.getDepartment());
        }

        int number = memBerCouncilService.count(id);

        if(councilModel.getLeader() != null)
        {
            number = number + 1;
        }

        request.setAttribute("message",message);
        request.setAttribute("memberCouncilModels", memberCouncilModels);
        request.setAttribute("number",number);
        request.setAttribute("councilModel", councilModel);
        request.setAttribute("action", "create");
        request.setAttribute("lecturersList", lecturersList);
        request.getRequestDispatcher("../../views/user/truongbomon/manager-council.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
