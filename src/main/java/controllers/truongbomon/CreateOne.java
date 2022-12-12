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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/truongbomon/council/create/one")
public class CreateOne extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idCouncil = Integer.parseInt(request.getParameter("idCouncil"));

        CouncilService councilService = new CouncilService();
        CouncilModel councilModel = councilService.get(idCouncil);
        String username = request.getParameter("username");
        UserService userService = new UserService();
        UserModel userModel = userService.getUser(username);
        MemberCouncilModel memberCouncilModel = new MemberCouncilModel();

        Council council = new Council();
        try {
            BeanUtils.copyProperties(council, councilModel);
            memberCouncilModel.setCouncil(council);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        User user = new User();
        try {
            BeanUtils.copyProperties(user, userModel);
            memberCouncilModel.setUser(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        MemBerCouncilService memBerCouncilService = new MemBerCouncilService();
        String check = "false";
        if(councilModel.getLeader() != null)
        {
            check = councilModel.getLeader().getUsername();
        }
        System.out.println(check);
        if(memBerCouncilService.check(idCouncil,username) > 0 || username.equals(check)){
            response.sendRedirect("../create?idCouncil="+idCouncil+"&message=danger");
        }
        else {
            memBerCouncilService.create(memberCouncilModel);
            response.sendRedirect("../create?idCouncil="+idCouncil+"&message=success");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCouncil = Integer.parseInt(request.getParameter("idCouncil"));
        System.out.println(idCouncil);
        CouncilService councilService = new CouncilService();
        CouncilModel councilModel = councilService.get(idCouncil);
        String username = request.getParameter("username");
        UserService userService = new UserService();
        UserModel userModel = userService.getUser(username);
        User user = new User();
        try {
            BeanUtils.copyProperties(user, userModel);
            councilModel.setLeader(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        MemBerCouncilService memBerCouncilService = new MemBerCouncilService();
        if(memBerCouncilService.check(idCouncil,username) > 0 ){
            response.sendRedirect("../create?idCouncil="+idCouncil+"&message=danger");
        }
        else {
            councilService.update(councilModel);
            response.sendRedirect("../create?idCouncil="+idCouncil+"&message=success");
        }
    }

}
