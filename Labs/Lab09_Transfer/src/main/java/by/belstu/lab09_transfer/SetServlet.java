package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;

@WebServlet(name = "SetServlet", urlPatterns = "/set")
public class SetServlet extends javax.servlet.http.HttpServlet {


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //для отправки на jsp
        //        request.setAttribute("str", "Test");
        //        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);

        //в другой сервлет
        HttpSession session = request.getSession();
        session.setAttribute("str", "Test");
    }
}
