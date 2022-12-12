package controllers.truongbomon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/truongbomon/council/search")
public class SearchMemberCouncil extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String search = request.getParameter("search");
        System.out.println(search);
        response.sendRedirect("../council/create?id="+id+"&action=search&search=" +search);
    }
}
