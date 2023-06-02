package by.belstu.lab_10;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebFilter(filterName = "FilterSecond", urlPatterns = {"/TaskServlet"})
public class FilterSecond implements Filter {
    private static final Logger LOG = Logger.getLogger(FilterSecond.class.getName());
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        int userNum = 0;
        if (!request.getParameter("userNumber").isEmpty()) {
            userNum = Integer.parseInt(request.getParameter("userNumber"));
            LOG.info("Число: " + userNum);
        }
        if (userNum >= 100) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        chain.doFilter(request, response);
    }
}
