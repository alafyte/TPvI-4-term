package by.belstu.lab13.Repository;

import by.belstu.lab13.Builder.UnivClassBuilder;
import by.belstu.lab13.Models.UniversityClass;
import by.belstu.lab13.Exceptions.RepositoryException;
import by.belstu.lab13.Repository.dbconstants.UnivClassTableConstants;
import by.belstu.lab13.Repository.paramspecification.Parameter;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UnivClassRepository extends AbstractRepository<UniversityClass> {
    public UnivClassRepository(Connection connection){
        super(connection);
    }
    @Override
    protected String getTableName() {
        return SQLHelper.TIMETABLE_TABLE;
    }
    @Override
    public List<UniversityClass> query(String sqlString, Parameter paramater) throws RepositoryException {
        List<UniversityClass> classes = executeQuery(sqlString,new UnivClassBuilder(), paramater.getParameters());
        return classes;
    }
    @Override
    public Optional<UniversityClass> queryForSingleResult(String sqlString, Parameter parameter) throws RepositoryException {
        List<UniversityClass> person = query(sqlString, parameter);
        return person.size() == 1 ?
                Optional.of(person.get(0)) :
                Optional.empty();
    }
    public Map<String, Object> getFields(UniversityClass uClass) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(UnivClassTableConstants.NAME.getFieldName(), uClass.getClassName());
        fields.put(UnivClassTableConstants.DAY.getFieldName(), uClass.getClassDay());
        fields.put(UnivClassTableConstants.HOURS.getFieldName(), uClass.getClassHours());
        return fields;
    }

}