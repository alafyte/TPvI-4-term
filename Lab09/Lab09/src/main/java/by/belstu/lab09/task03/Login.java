package by.belstu.lab09.task03;

import by.belstu.lab09.task03.classes.DAO;
import by.belstu.lab09.task03.classes.HashPassword;
import by.belstu.lab09.task03.classes.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "Login", value = "/Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    private static final DAO db = new DAO();
    @Override
    public void init() throws ServletException {
        db.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isUserFound = false;
        Date currentDate = new Date();
        User user = new User();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        try {
            ResultSet rs = db.checkUsersCount(login, password);
            rs.next();
            if (rs.getInt("count") != 0) {
                ResultSet userSet = db.checkUser(login, password);
                userSet.next();
                user.setLogin(userSet.getString("User_Login"));
                user.setRole(userSet.getString("User_Role"));
                isUserFound = true;
            }
            else {
                user = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        HttpSession session = request.getSession();
        session.setAttribute("current_user", user);
        if (isUserFound) {
            //================================================
            Cookie cookieLogin = new Cookie("login", user.getLogin());
            Cookie cookieRole = new Cookie("role", user.getRole());

            response.addCookie(cookieRole);
            response.addCookie(cookieLogin);
            //=====================================================
            request.setAttribute("name", user.getLogin());
            request.setAttribute("role", user.getRole());
            request.setAttribute("date", currentDate);
            request.getRequestDispatcher("/MainPage.jsp").forward(request, response);
        }
        else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"Неверный логин или пароль\")");
            out.println("window.location.href = 'LoginPage.jsp';");
            out.println("</script>");
        }

        out.println("</body></html>");
        out.close();
    }

}
