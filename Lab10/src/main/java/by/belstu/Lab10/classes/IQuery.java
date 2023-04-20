package by.belstu.Lab10.classes;

import java.sql.ResultSet;

public interface IQuery {
    public ResultSet ExecuteQuery(String sqlQuery);
}
