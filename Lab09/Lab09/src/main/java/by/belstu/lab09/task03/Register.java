package by.belstu.lab09.task03;

import by.belstu.lab09.task03.classes.DAO;
import by.belstu.lab09.task03.classes.HashPassword;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    private final DAO db = new DAO();

    @Override
    public void init() throws ServletException {
        db.getConnection();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        if (login.length() != 0 && password.length() != 0) {
            ResultSet rs = db.ExecuteQuery("select count(*)[count] from Users where User_Login = '" + login + "'");
            try {
                rs.next();
                if (rs.getInt("count") != 0) {
                    ShowMessage(out, "Пользователь с таким логином уже сущестует", "Registration.jsp");
                }
                else {
                    db.addUser(login, password);
                    ShowMessage(out, "Регистрация прошла успешно!", "LoginPage.jsp");
                    out.close();

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            ShowMessage(out, "Поля не могут быть пустыми", "Registration.jsp");
            out.close();
        }
    }
    private void ShowMessage(PrintWriter out, String message, String location) {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('" + message + "');");
        out.println("window.location.href = '" + location + "';");
        out.println("</script>");
        out.println("</body></html>");
    }
}
