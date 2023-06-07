package com.example.task22;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import db.UserDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.User;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {



 @Override protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {
         String name = request.getParameter("name");
         String email = request.getParameter("email");
         String phone = request.getParameter("phone");
         User user = new User(name,email,phone);
         UserDB.addUser(user);
         request.setAttribute("users", UserDB.select());
         getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);
     }
     catch(Exception ex) {


     }



 }



}