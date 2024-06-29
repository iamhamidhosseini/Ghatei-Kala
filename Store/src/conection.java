

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 66490812
 */
public class conection {
    static final String dataBaseURL = "jdbc:derby://localhost:1527/gkala";
    static final String username = "adminadmin";
    static final String password = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dataBaseURL, username, password);
    }
}