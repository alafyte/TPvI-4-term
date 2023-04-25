package by.belstu.lab13.Command;

import by.belstu.lab13.Exceptions.IncorrectDataException;
import by.belstu.lab13.Exceptions.ServiceException;
import by.belstu.lab13.util.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request,
                                 HttpServletResponse response) throws ServiceException,
            IncorrectDataException {
        System.out.println("LOGIN_PAGE");
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);

    }
}
