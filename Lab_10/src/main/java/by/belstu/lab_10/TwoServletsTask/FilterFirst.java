package by.belstu.lab_10;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import org.apache.log4j.Logger;

import java.io.IOException;

@WebFilter(filterName = "FilterFirst", urlPatterns = {"/TaskServlet"})
public class FilterFirst implements Filter {
    private static final Logger LOG = Logger.getLogger(FilterFirst.class.getName());
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
        if (userNum <= 10) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        chain.doFilter(request, response);
    }
}
