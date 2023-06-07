package com.example.sumtable;

import java.io.*;
import java.util.ArrayList;

import db.Mytable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Table;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    int CommonSum=0;
    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter printWriter = response.getWriter();
        int year = Integer.parseInt(request.getParameter("year"));
        int sum = Integer.parseInt(request.getParameter("sum"));
        ArrayList<Table> tab=Mytable.select(year, sum);
        request.setAttribute("tables", Mytable.select(year, sum));
        getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);
        /*for (Table t : tab) {
           // CommonSum+=t.getSum();
        }*/

/*if (CommonSum>=0) {
        request.setAttribute("info",CommonSum);
        getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);


    }
else {
    getServletContext().getRequestDispatcher("/newPage.jsp").forward(request, response);


}*/
    }

    public void destroy() {
    }
}