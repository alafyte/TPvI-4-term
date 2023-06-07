package com.example.students;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/login")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    private static final String INVALID_DATA = "Неверные данные";
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        String course = request.getParameter("course");
        String number = request.getParameter("number");
        if (course.equals("") || number.equals("") || !course.matches("^[1-4]{1}$") || !number.matches("^[1-9]$")) {
            request.getRequestDispatcher("/Error.jsp").forward(request, response);
        }
        else {
            switch (course) {
                case "1":
                    request.setAttribute("year", "2025");
                    break;
                case "2":
                    request.setAttribute("year", "2024");
                    break;
                case "3":
                    request.setAttribute("year", "2023");
                    break;
                case "4":
                    request.setAttribute("year", "2022");
                    break;
            }
            ;

            switch (number) {
                case "1":
                case "2":
                case "3":
                    request.setAttribute("specialty", "ISiT");
                    break;
                case "4":
                case "5":
                case "6":
                    request.setAttribute("specialty", "POiT");
                    break;
                case "7":
                case "8":
                    request.setAttribute("specialty", "POIBMS");
                    break;
                case "9":

                    request.setAttribute("specialty", "DEIVI");
                    break;
            }
            //request.setAttribute("", );

            request.getRequestDispatcher("/Student.jsp").forward(request, response);
        }
    }

   // public void destroy() {
    }
