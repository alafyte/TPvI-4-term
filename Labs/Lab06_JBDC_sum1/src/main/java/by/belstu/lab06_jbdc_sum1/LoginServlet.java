package com.example.task3.servlet;

import com.example.task3.db.UserDB;
import com.example.task3.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final String ERROR_MESSAGE = "error_message";
    private static final String AUTHENTICATION_ERROR_TEXT = "Неверный логин";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");

        if (initializeUserIfExist(login, request)) {
            response.sendRedirect("work");
        } else {
            request.setAttribute(ERROR_MESSAGE, AUTHENTICATION_ERROR_TEXT);
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
    }

    public boolean initializeUserIfExist(String login,HttpServletRequest request) {
        ArrayList<User> users = UserDB.select();
        User user = users
                .stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst().orElse(null);

        boolean userExist = false;
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            userExist = true;
        }
        return userExist;
    }
}
