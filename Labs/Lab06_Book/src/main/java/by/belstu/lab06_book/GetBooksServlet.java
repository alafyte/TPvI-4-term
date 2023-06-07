package com.example.task1.servlet;

import com.example.task1.db.BookDB;
import com.example.task1.model.Book;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetBooksServlet", value = "/books")
public class GetBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageStr = request.getParameter("page");
        String dbSize = request.getParameter("dbSize");


        if (dbSize == null){
            request.setAttribute("dbSize", BookDB.getDbSize());
            dbSize= BookDB.getDbSize() + "";
        }


        int pageInt;
        if(pageStr != null) {
            pageInt = Integer.parseInt(pageStr);
        } else {
            pageInt = 0;
        }

        if (pageInt *2 + 2 >= Integer.parseInt(dbSize)){
            request.setAttribute("IsNextAvailable",false);
        }
        else {
            request.setAttribute("IsNextAvailable",true);
        }


        ArrayList<Book> books = BookDB.select(pageInt);
        if(books.size() == 0) {
            pageInt = 1;
            books = BookDB.select(pageInt);
        }
        request.setAttribute("books", books);
        request.setAttribute("nextPage", pageInt + 1);

        getServletContext().getRequestDispatcher("/views/books.jsp").forward(request, response);
    }
}
