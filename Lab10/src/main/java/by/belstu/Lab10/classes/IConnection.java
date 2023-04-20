package by.belstu.Lab10.DAO;

import java.util.ArrayList;

public interface IConnection {
    public ArrayList<String> getProperties();
    public Boolean getConnection();
    public void closeConnection();
}
