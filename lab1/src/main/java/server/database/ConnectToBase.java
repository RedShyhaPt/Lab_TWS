package server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import javax.sql.DataSource;

public class ConnectToBase {
    private static final String JDBC_URL = "jdbc:sqlserver://DESKTOP-5AEIHSO;databaseName=Gazizulin_sales";

    //static DataSource dataSource;

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(JDBC_URL);
        }
        catch (Exception ex) {
            System.out.println("Exception!");
            ex.printStackTrace();
        }
        return connection;
    }
}
