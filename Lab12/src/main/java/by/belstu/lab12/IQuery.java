package by.belstu.lab12;

import java.sql.ResultSet;

public interface IQuery {
    public ResultSet ExecuteQuery(String sqlQuery);
}
