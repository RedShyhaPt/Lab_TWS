package server.database.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import javax.sql.DataSource;
import server.database.ConnectToBase;
import server.database.tables.Customer;

public class ReadWriteTable {
    private final Connection connection;

    public ReadWriteTable() {
        connection = ConnectToBase.getConnection();
    }

    public ReadWriteTable(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }
}
