package com.example.task9_Cookie_GroupCourse.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ClearCookiesServlet", value = "/clearcookies")
public class ClearCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie clearCookie1 = new Cookie("course", "");
        Cookie clearCookie2 = new Cookie("group", "");
        Cookie clearCookie3 = new Cookie("specialty", "");
        clearCookie1.setMaxAge(0);
        clearCookie2.setMaxAge(0);
        clearCookie3.setMaxAge(0);

        response.addCookie(clearCookie1);
        response.addCookie(clearCookie2);
        response.addCookie(clearCookie3);

        request.setAttribute("info", "Куки очищены");
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
