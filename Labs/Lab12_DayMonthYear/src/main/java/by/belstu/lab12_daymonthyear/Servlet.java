import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Получаем данные, которые ты ввёл в поля
        String day = request.getParameter("txbDay");
        String month = request.getParameter("txbMonth");
        String year = request.getParameter("txbYear");

        //Проверяем корректнось введёных данных (день, месяц, год)
        if(Integer.parseInt(day) >= 0 && Integer.parseInt(day) <= 31 ){
            if(Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12){
                if(Integer.parseInt(year) >= 1900){
                    request.setAttribute("day", day);
                    request.setAttribute("month", month);
                    request.setAttribute("year", year);
                }
                else{
                    request.setAttribute("year", "Year error");
                }
            }
            else{
                request.setAttribute("month", "Month error");
            }
        }
        else{
            request.setAttribute("day", "Day error");
        }

        //Переходим на my.jsp, где вызываются 3 пользовательских тега
        //для каждого тега свой класс, которые расположены в папке Tags
        getServletContext().getRequestDispatcher("/my.jsp").forward(request, response);
    }
}
