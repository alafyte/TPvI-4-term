package com.example.task3.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LoginRequiredFilter", urlPatterns = "/work")
public class LoginRequiredFilter implements Filter {
    private static final String ERROR_MESSAGE = "error_message";
    private static final String ERROR_TEXT = "Нет авторизации для переходу на данную страницу";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getSession().getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute(ERROR_MESSAGE, ERROR_TEXT);
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
    }
}
