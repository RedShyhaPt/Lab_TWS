package server.database.management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import server.database.ConnectToBase;
import server.database.tables.Customer;

public class CreateTable {

    private final Connection connection;

    public CreateTable() {
        connection = ConnectToBase.getConnection();
    }

    public CreateTable(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    public Customer createCustomer(Customer customer) throws SQLException {
        String query = String.format("insert into customer (custName, contact, city, country, sex) "
                        + "values ('%s', '%s', '%s', '%s', '%s')",
                customer.getCustName(), customer.getContact(), customer.getCity(),
                customer.getCountry(), customer.getSex());

        if (query.contains(";")) {
            throw new SQLException("SQL Injection detected!");
        }

        Statement statement = connection.createStatement();

        statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {

            if (generatedKeys.next()) {
                customer.setCustId((int) generatedKeys.getLong(1));
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

        return customer;
    }
    protected void finalize() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
