package Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@WebFilter(filterName = "WriteLogFilter")
public class WriteLogFilter implements Filter {
    Logger LOGGER;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        LOGGER.info("Current time is: " + LocalDateTime.now());
        LOGGER.info(req.getLocalAddr());
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        LOGGER = Logger.getLogger(WriteLogFilter.class.getName());
    }

}
