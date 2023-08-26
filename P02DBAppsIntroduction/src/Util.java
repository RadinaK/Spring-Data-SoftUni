import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

enum Util {
    ;
    static Connection getSQLConnection() throws SQLException {
        final Properties properties = new Properties();
        properties.setProperty(Constant.USER_KEY, Constant.USER_VALUE);
        properties.setProperty(Constant.PASSWORD_KEY, Constant.PASSWORD_VALUE);

        return DriverManager.getConnection(Constant.JDBC_URL, properties);
    }
}
