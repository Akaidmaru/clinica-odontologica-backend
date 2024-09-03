package finalproject.com.Clinica_Odontologica.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {

    static final Logger logger = LoggerFactory.getLogger(H2Connection.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:./clinica.database";
    private final static String DB_USER = "sa";
    private final static String DB_PASS = "sa";
    public static  Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DB_JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static void createTables(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/clinica.database;INIT=RUNSCRIPT FROM './clinica.database'", "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
