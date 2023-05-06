package Builder;

import by.belstu.lab13.Builder.UserBuilder;
import by.belstu.lab13.Exceptions.RepositoryException;
import by.belstu.lab13.Models.User;
import by.belstu.lab13.Repository.dbconstants.UserTableConstants;
import by.belstu.lab13.util.HashPassword;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserBuilderTest {

    private static final String LOGIN = "admin";
    private static final byte [] PASSWORD = HashPassword.getHash("admin");

    private static User EXPECTED_USER = null;

    @BeforeAll
    public static void initExpectedUser(){
        EXPECTED_USER = new User(
                LOGIN,
                PASSWORD
        );
    }

    @Test
    public void shouldBuildAndReturnUserWithParameters() throws SQLException, RepositoryException {
        // Arrange
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getString(UserTableConstants.LOGIN.getFieldName())).thenReturn(LOGIN);
        when(resultSet.getBytes(UserTableConstants.PASSWORD.getFieldName())).thenReturn(PASSWORD);

        // Act
        UserBuilder userBuilder = new UserBuilder();
        User actualUser = userBuilder.build(resultSet);

        //Assert
        assertEquals(EXPECTED_USER, actualUser);
    }
}
