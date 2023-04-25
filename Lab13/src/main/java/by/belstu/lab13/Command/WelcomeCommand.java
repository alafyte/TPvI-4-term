package by.belstu.lab13.Command;

import by.belstu.lab13.Exceptions.IncorrectDataException;
import by.belstu.lab13.Exceptions.ServiceException;
import by.belstu.lab13.Models.UniversityClass;
import by.belstu.lab13.services.UniversityClassService;
import by.belstu.lab13.util.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class WelcomeCommand implements Command{
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException {
        UniversityClassService classService = new UniversityClassService();
        List<UniversityClass> classes = classService.findAll();
        if (!classes.isEmpty()) {
            request.setAttribute("classes", classes);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }

}
