package by.belstu.lab13.Builder;

import by.belstu.lab13.Models.UniversityClass;
import by.belstu.lab13.Exceptions.RepositoryException;
import by.belstu.lab13.Repository.dbconstants.UnivClassTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnivClassBuilder  implements Builder <UniversityClass>{
    @Override
    public UniversityClass build(ResultSet resultSet) throws RepositoryException {
        try {
            int id = resultSet.getInt(UnivClassTableConstants.ID.getFieldName());
            String name = resultSet.getString(UnivClassTableConstants.NAME.getFieldName());
            String days = resultSet.getString(UnivClassTableConstants.DAY.getFieldName());
            String hours = resultSet.getString(UnivClassTableConstants.HOURS.getFieldName());
            return new UniversityClass(id, name, days, hours);
        } catch (SQLException exception) {
            throw new RepositoryException(exception.getMessage(), exception);
        }
    }

}
