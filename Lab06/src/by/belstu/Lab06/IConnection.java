package by.belstu.Lab06;

import java.util.ArrayList;

public interface IConnection {
    public ArrayList<String> getProperties();
    public Boolean getConnection();
    public void closeConnection();
}
