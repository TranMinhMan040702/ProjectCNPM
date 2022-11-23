package filter;

import models.LoginModel;
import utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String url = req.getRequestURL().toString();
        if (url.contains("admin")) {
            checkAuthor(request, response, chain, "admin");
        } else if (url.contains("sinhvien")) {
            checkAuthor(request, response, chain, "sinhvien");
        } else if (url.contains("giangvien")){
            checkAuthor(request, response, chain, "giangvien");
        } else if (url.contains("truongbomon")) {
            checkAuthor(request, response, chain, "truongbomon");
        }
    }

    protected void checkAuthor(ServletRequest request, ServletResponse response, FilterChain chain, String role) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        LoginModel model = (LoginModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
        if (model != null) {
            if (model.getRole().equals(role)) {
                chain.doFilter(request,response);
            } else {
                // no permission
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            // request login
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
