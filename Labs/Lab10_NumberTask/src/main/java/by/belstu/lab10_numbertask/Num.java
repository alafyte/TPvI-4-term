package by.belstu.lab10_numbertask;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "num", value = "/nums")
public class Num extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {

        int max=100;
        int min =0;
        int x = (int) ((Math.random()*((max-min)+1))+min);
        HttpSession session = request.getSession();
        session.setAttribute("oldcount", 0);
        session.setAttribute("count", min);
        session.setAttribute("number", x);
        request.getRequestDispatcher("/num.jsp").forward(request, response);

    }
}
