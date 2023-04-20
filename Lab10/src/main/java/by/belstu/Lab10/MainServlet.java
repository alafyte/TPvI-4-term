package by.belstu.Lab10;

import by.belstu.Lab10.classes.DAO;
import by.belstu.Lab10.classes.UniversityClass;
import by.belstu.Lab10.classes.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "MainServlet", value = "/MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {
    private static final DAO db = new DAO();
    @Override
    public void init() throws ServletException {
        db.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String classId = request.getParameter("id");
        db.ExecuteQuery("delete Timetable where classId = " + classId);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("current_user");
        request.setAttribute("name", user.getLogin());
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String className = request.getParameter("name");
        String classDay = request.getParameter("day");
        String classHours = request.getParameter("hours");
        db.ExecuteQuery("insert into Timetable (ClassName, ClassDay, ClassHours) values ('"
                + className + "', '" + classDay + "', '" + classHours +"')");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("current_user");
        request.setAttribute("name", user.getLogin());
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
