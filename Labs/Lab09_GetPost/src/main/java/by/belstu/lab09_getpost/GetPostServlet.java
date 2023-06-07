package com.example.task7.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

@WebServlet(name = "GetPostServlet", value = "/getpost")
public class GetPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCookies(request, response);

        request.setAttribute("time", new Date().toString());
        request.setAttribute("protocol", request.getProtocol());
        request.setAttribute("headerr", request.getHeader("User-Agent"));
        request.setAttribute("method", request.getMethod());
        getServletContext().getRequestDispatcher("/views/get.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCookies(request, response);

        StringBuilder headers = new StringBuilder();
        for(String header : response.getHeaderNames()) {
            headers.append(header + ": " + response.getHeader(header) + "<br/>");
        }
        request.setAttribute("headers", headers.toString());
        getServletContext().getRequestDispatcher("/views/post.jsp").forward(request, response);
    }

    private void setCookies(HttpServletRequest request, HttpServletResponse response) {
        response.addCookie(new Cookie("time", new Date().toString()));
        response.addCookie(new Cookie("method", request.getMethod()));
    }
}
