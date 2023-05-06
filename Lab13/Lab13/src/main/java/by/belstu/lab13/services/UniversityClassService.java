package by.belstu.lab13.services;

import by.belstu.lab13.Models.UniversityClass;
import by.belstu.lab13.Exceptions.RepositoryException;
import by.belstu.lab13.Exceptions.ServiceException;
import by.belstu.lab13.Repository.RepositoryCreator;
import by.belstu.lab13.Repository.UnivClassRepository;

import java.util.List;

public class UniversityClassService {
    public List<UniversityClass> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UnivClassRepository uniClassRepository = repositoryCreator.getClassRepository();
            return uniClassRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public void save(UniversityClass uniClass) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UnivClassRepository uniClassRepository = repositoryCreator.getClassRepository();
            uniClassRepository.save(uniClass);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}
