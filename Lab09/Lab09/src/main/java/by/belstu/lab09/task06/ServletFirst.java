package by.belstu.lab09.task06;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

public class ServletFirst extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Name","UserGet");
        request.getRequestDispatcher("ServletSecond").forward(request, response);
        //response.sendRedirect("ServletSecond");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Name","UserPost");
        request.getRequestDispatcher("ServletSecond").forward(request, response);
    }
}
