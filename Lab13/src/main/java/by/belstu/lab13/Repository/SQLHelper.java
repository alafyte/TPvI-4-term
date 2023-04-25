package by.belstu.lab13.Repository;

import by.belstu.lab13.Repository.dbconstants.UnivClassTableConstants;
import by.belstu.lab13.Repository.dbconstants.UserTableConstants;

import java.util.Map;

public class SQLHelper {
    public static final String ID = "id";
    private static final String INSERT_QUERY = "INSERT INTO ";
    private static final String VALUES = "VALUES";
    private static final String WHERE = "WHERE ";
    private static final String SELECT = "SELECT";
    public static final String USER_TABLE = "Users";
    public static final String TIMETABLE_TABLE = "Timetable";
    public final static String SQL_GET_PERSONS = "select * from " + USER_TABLE;
    public final static String SQL_INSERT_PERSON = "INSERT INTO " + TIMETABLE_TABLE + "(" + UnivClassTableConstants.NAME +
            "," + UnivClassTableConstants.DAY + "," + UnivClassTableConstants.HOURS + ") VALUES (? , ?, ?)";
    public final static String SQL_GET_USER = "SELECT " + UserTableConstants.ID.getFieldName() + ", " +
            UserTableConstants.LOGIN.getFieldName() + ", " +
            UserTableConstants.PASSWORD.getFieldName() + " from " + USER_TABLE + " WHERE " +
            UserTableConstants.LOGIN.getFieldName() + " =? and " +
            UserTableConstants.PASSWORD.getFieldName() + " =?";
    public final static String SQL_CHECK_LOGIN = "SELECT " + UserTableConstants.ID.getFieldName() + ", "
            + UserTableConstants.LOGIN.getFieldName()+ ", " +
            UserTableConstants.PASSWORD.getFieldName() + " FROM " +
            USER_TABLE + " WHERE " + UserTableConstants.LOGIN.getFieldName() + " = ?";
    public final static String SQL_INSERT_USER = "INSERT INTO " + USER_TABLE + "(" +
            UserTableConstants.LOGIN.getFieldName() + " ," +
            UserTableConstants.PASSWORD.getFieldName() + ") VALUES (? , ?, 'user')";
    public static String makeInsertQuery(Map<String, Object> fields, String table) {
        StringBuilder sql = new StringBuilder(INSERT_QUERY + " " + table + " ");
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            String column = entry.getKey();
            if (column.equals(ID)) {
                continue;
            }
            columns.append(column).append(", ");
            values.append("?, ");
        }
        values.deleteCharAt(values.lastIndexOf(","));
        columns.deleteCharAt(columns.lastIndexOf(","));
        values.append(")");
        columns.append(")");
        return  " " + sql + " " + columns + " " + VALUES + " " + values + ";";
    }
}
