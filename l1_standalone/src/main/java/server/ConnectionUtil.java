package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtil {
    private static final String JDBC_URL = "jdbc:sqlserver://DESKTOP-5AEIHSO:1433;databaseName=Gazizulin_sales;integratedSecurity=true;encrypt=false; trustServerCertificate=true";
    private static final String JDBC_USER = "ifmo-ws";
    private static final String JDBC_PASSWORD = "ifmo-ws";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception!");
            ex.printStackTrace();
        }
        return connection;
    }
}
