package com.example.task3.servlet;

import com.example.task3.db.UserDB;

import com.example.task3.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.log4j.Logger;

import java.io.IOException;


@WebServlet(name = "WorkServlet", value = "/work")
public class WorkServlet extends HttpServlet {
    private static final String INFO_MESSAGE = "Недостаточно средств";
    Logger  logger = Logger.getLogger(WorkServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String command = request.getParameter("command");
        String quantityStr = request.getParameter("quantity");
        int quantity = 0;
        if (quantityStr != null && quantityStr.length() != 0) {
            quantity = Integer.parseInt(quantityStr);
        }

        if (command != null) {
            switch (command) {
                case "show_balance": {
                    request.setAttribute("balance", user.getSum());
                    break;
                }
                case "PAY": {
                    int newSum = user.getSum() - quantity;
                    if (newSum >= 0) {
                        User newUser = new User(user.getId(), user.getLogin(), newSum);
                        UserDB.update(newUser);
                        request.getSession().setAttribute("user", newUser);

                        logger.info("Покупка на сумму " + quantity);
                    } else {
                        request.setAttribute("info", INFO_MESSAGE);
                    }
                    break;
                }
                case "ADD": {
                    int newSum = user.getSum() + quantity;
                    User newUser = new User(user.getId(), user.getLogin(), newSum);
                    UserDB.update(newUser);
                    request.getSession().setAttribute("user", newUser);

                    logger.info("Пополнение на сумму " + quantity);
                    break;
                }
            }
        }

        request.getRequestDispatcher("/views/work.jsp").forward(request, response);
    }
}
