package by.belstu.lab09.task05;

import by.belstu.lab09.task03.classes.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(filterName = "FilterLogin", urlPatterns = {"/MainPage.jsp"},
        initParams = { @WebInitParam(name = "REGISTER_PATH", value = "/Registration.jsp") })
public class FilterLogin implements Filter {
    private String registerPath;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        registerPath = filterConfig.getInitParameter("REGISTER_PATH");
    }
    @Override
    public void doFilter(ServletRequest servletRequest  , ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current_user");
        if (user == null) {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect(request.getContextPath() + registerPath);
        } else
            filterChain.doFilter(servletRequest, servletResponse);
    }
}
