package com.example.task9_Cookie_GroupCourse.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final String INVALID_DATA = "Неверные данные";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (getCookie(request, "course") != null) {
            if (    getCookie(request, "course").getValue().equals(request.getParameter("course")) &&
                    getCookie(request, "group").getValue().equals(request.getParameter("group")) &&
                    getCookie(request, "specialty").getValue().equals(request.getParameter("specialty"))) {
                getServletContext().getRequestDispatcher("/views/home.jsp").forward(request, response);
            } else {
                request.setAttribute("info", INVALID_DATA);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } else {
            response.addCookie(new Cookie("course", request.getParameter("course")));
            response.addCookie(new Cookie("group", request.getParameter("group")));
            response.addCookie(new Cookie("specialty", request.getParameter("specialty")));

            getServletContext().getRequestDispatcher("/views/home.jsp").forward(request, response);
        }
    }

    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
