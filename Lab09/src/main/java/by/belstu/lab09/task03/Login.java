package by.belstu.lab09.task03;

import by.belstu.lab09.task03.classes.DAO;
import by.belstu.lab09.task03.classes.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "Login", value = "/Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    private static final DAO db = new DAO();
    private static final User user = new User();
    @Override
    public void init() throws ServletException {
        db.getConnection();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isUserFound = false;
        Date currentDate = new Date();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        ResultSet rs = db.ExecuteQuery("select count(*)[count] from Users where User_Login = '" + login + "' and User_Password = '" + password + "'");
        try {
            rs.next();
            if (rs.getInt("count") != 0) {
                ResultSet userSet = db.ExecuteQuery("select User_Role from Users where User_Login = '" + login + "' and User_Password = '" + password + "'");
                userSet.next();
                user.setLogin(login);
                user.setRole(userSet.getString("User_Role"));
                isUserFound = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("name", user.getLogin());
        request.setAttribute("role", user.getRole());
        request.setAttribute("date", currentDate);


        //================================================

        HttpSession session = request.getSession();

        Cookie cookieLogin = new Cookie("login", user.getLogin());
        Cookie cookieRole = new Cookie("role", user.getRole());

        response.addCookie(cookieRole);
        response.addCookie(cookieLogin);
        session.setAttribute("current_user", user);
        //=====================================================
        if (isUserFound)
            request.getRequestDispatcher("/MainPage.jsp").forward(request, response);
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
