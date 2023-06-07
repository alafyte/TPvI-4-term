package Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "CheckTextFilter")
public class CheckTextFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        if(phone == null || phone.isEmpty() || email == null || email.isEmpty()) {
            req.setAttribute("message", "Введите все данные");
            req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
