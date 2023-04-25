package Builder;

import by.belstu.lab13.Builder.UnivClassBuilder;
import by.belstu.lab13.Exceptions.RepositoryException;
import by.belstu.lab13.Models.UniversityClass;
import by.belstu.lab13.Repository.dbconstants.UnivClassTableConstants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnivClassBuilderTest {
    private static final Integer ID = 1;
    private static final String NAME = "Базы данных";
    private static final String DAY = "Четверг";
    private static final String HOURS = "18:05-19:25";

    private static UniversityClass EXPECTED_CLASS = null;

    @BeforeAll
    public static void initExpectedClass() {
        EXPECTED_CLASS = new UniversityClass(
                ID,
                NAME,
                DAY,
                HOURS
        );
    }

    @Test
    public void shouldBuildAndReturnUserWithParameters() throws SQLException, RepositoryException {
        //Arrange
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt(UnivClassTableConstants.ID.getFieldName())).thenReturn(ID);
        when(resultSet.getString(UnivClassTableConstants.NAME.getFieldName())).thenReturn(NAME);
        when(resultSet.getString(UnivClassTableConstants.DAY.getFieldName())).thenReturn(DAY);
        when(resultSet.getString(UnivClassTableConstants.HOURS.getFieldName())).thenReturn(HOURS);

        //Act
        UnivClassBuilder classBuilder = new UnivClassBuilder();
        UniversityClass actualClass = classBuilder.build(resultSet);

        //Assert
        assertEquals(EXPECTED_CLASS, actualClass);
    }
}


