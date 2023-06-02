package by.belstu.lab_10;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "TaskServlet", value = "/TaskServlet")
public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>");
        pw.println("<p>");
        pw.println("Протокол: "+ request.getProtocol() + "<br/>");
        pw.println("IP-адреса клиента, от имени которого пришел запрос: " + request.getRemoteAddr() + "<br/>");
        pw.println("Имя клиента: " + request.getRemoteHost() + " " + request.getRemoteUser() + "<br/>");
        pw.println("Метод доступа: " + request.getMethod() + "<br/>");
        pw.println("URL: "+ request.getRequestURL() + "<br/>");
        pw.println("Заголовок: <br/>");
        Enumeration< String > e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = request.getHeader(name);
            pw.println(name + " = " + value + "<br/>");
        }
        pw.println("</p>");
        pw.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
