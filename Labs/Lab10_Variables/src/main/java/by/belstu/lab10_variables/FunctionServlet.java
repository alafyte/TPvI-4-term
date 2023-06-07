package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Function", urlPatterns = "/Function")
public class FunctionServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("a").isEmpty() || request.getParameter("b").isEmpty() || request.getParameter("c").isEmpty() || request.getParameter("x").isEmpty()) {
            request.setAttribute("message", "Введите все данные");
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        }
        else {
            Integer a = new Integer(request.getParameter("a"));
            Integer b = new Integer(request.getParameter("b"));
            Integer c = new Integer(request.getParameter("c"));
            Integer x = new Integer(request.getParameter("x"));
            getServletContext().setAttribute("y", "a+b*x+c*x*x"+(a+b*x+c*x*x));
            response.sendRedirect("function.jsp");
        }
    }
}
