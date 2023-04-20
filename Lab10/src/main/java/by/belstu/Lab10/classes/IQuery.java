package by.belstu.Lab10.DAO;

import java.sql.ResultSet;

public interface IQuery {
    public ResultSet ExecuteQuery(String sqlQuery);
}
