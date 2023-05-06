package by.belstu.Lab10;

import by.belstu.Lab10.classes.DAO;
import by.belstu.Lab10.classes.HashPassword;
import by.belstu.Lab10.classes.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    private static final DAO db = new DAO();
    private static final User user = new User();
    @Override
    public void init() throws ServletException {
        db.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isUserFound = false;
        Date currentDate = new Date();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Object pass = HashPassword.getHash(password);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        HttpSession session = request.getSession();

        if (login.isEmpty() || password.isEmpty()) {
            request.setAttribute("ErrorMessage", "Поля не могут быть пустыми!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        ResultSet rs = db.ExecuteQuery("select count(*)[count] from Users where User_Login = '" + login + "' and User_Password = '" + pass + "'");
        try {
            rs.next();
            if (rs.getInt("count") != 0) {
                ResultSet userSet = db.ExecuteQuery("select User_Role from Users where User_Login = '" + login + "' and User_Password = '" + pass + "'");
                userSet.next();
                user.setLogin(login);
                user.setRole(userSet.getString("User_Role"));
                isUserFound = true;
            }
            else {
                request.setAttribute("ErrorMessage", "Пользователя не существует");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (isUserFound) {
            request.setAttribute("name", user.getLogin());
            request.setAttribute("role", user.getRole());
            request.setAttribute("date", currentDate);
            session.setAttribute("current_user", user);
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        }
        else {
            request.setAttribute("ErrorMessage", "Неверный логин или пароль");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        out.println("</body></html>");
        out.close();
    }
}