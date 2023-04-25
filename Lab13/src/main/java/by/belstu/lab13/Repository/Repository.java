package by.belstu.lab13.Repository;

import by.belstu.lab13.Exceptions.RepositoryException;
import by.belstu.lab13.Repository.paramspecification.Parameter;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> query(String sqlString, Parameter parameter) throws RepositoryException;
    Optional<T> queryForSingleResult(String sqlString, Parameter parameter) throws RepositoryException;
    List<T> findAll() throws RepositoryException;
    Integer save(T object) throws RepositoryException;

}
