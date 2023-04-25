package by.belstu.lab13.services;

import by.belstu.lab13.Models.User;
import by.belstu.lab13.Exceptions.RepositoryException;
import by.belstu.lab13.Exceptions.ServiceException;
import by.belstu.lab13.Repository.RepositoryCreator;
import by.belstu.lab13.Repository.SQLHelper;
import by.belstu.lab13.Repository.UserRepository;
import by.belstu.lab13.Repository.paramspecification.UserByLogin;
import by.belstu.lab13.Repository.paramspecification.UserByLoginPassword;

import java.util.Optional;

public class UserService {
    public Optional<User> login(String login, byte[] password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            UserByLoginPassword params = new UserByLoginPassword(login, password);
            return userRepository.queryForSingleResult(SQLHelper.SQL_GET_USER, params);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public Integer save(User user) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            UserByLogin param = new UserByLogin(user.getLogin());
            if (!userRepository.queryForSingleResult(SQLHelper.SQL_CHECK_LOGIN, param).isPresent()) {
                return userRepository.save(user);
            } else {
                return 0;
            }
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

}
