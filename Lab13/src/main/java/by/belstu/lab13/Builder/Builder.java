package by.belstu.lab13.Builder;

import by.belstu.lab13.Exceptions.RepositoryException;

import java.sql.ResultSet;

public interface Builder <T> {
    T build(ResultSet resultSet) throws RepositoryException;

}
