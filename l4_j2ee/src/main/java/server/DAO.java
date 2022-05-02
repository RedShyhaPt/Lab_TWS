package server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    private final Connection connection;
    public DAO(Connection connection) {
        this.connection = connection;
    }

    public List<Clients> converter (ResultSet rs) {
        List<Clients> clients = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String name = rs.getString("customer_name");
                String city = rs.getString("city_name");
                String country = rs.getString("country_name");
                String contact = rs.getString("contact");
                String sex = rs.getString("sex");

                Clients client = new Clients(id,name,city,country,contact,sex);
                clients.add(client);
            }
        } catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println("Error in DB!");
        }
        return clients;
    }

    public List<Clients> getAllClients() {
        List<Clients> clients = new ArrayList<>();
        try (Connection connection =  this.connection){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Customer_dim");
            clients = converter(rs);
        }catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println("Error with SQL!");
        }
        return clients;
    }

    public List<Clients> getClientsByName(String name) {
        List<Clients> clients = new ArrayList<>();
        try (Connection connection =  this.connection){
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Customer_dim where customer_name = \'" + name + "\'");
            clients = converter(rs);
        }catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println("Error with SQL!");
        }
        return clients;
    }

    public List<Clients> getClientsByCity(String city) {
        List<Clients> clients = new ArrayList<>();
        try (Connection connection =  this.connection){
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Customer_dim where city_name = \'" + city + "\'");
            clients = converter(rs);
        }catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println("Error with SQL!");
        }
        return clients;
    }

    public List<Clients> getClientsByContact(String contact) {
        List<Clients> clients = new ArrayList<>();
        try (Connection connection =  this.connection){
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Customer_dim where contact = \'" + contact + "\'");
            clients = converter(rs);
        }catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println("Error with SQL!");
        }
        return clients;
    }

    public List<Clients> getClientsById(int id) {
        List<Clients> clients = new ArrayList<>();
        try (Connection connection =  this.connection){
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Customer_dim where customer_id=" + id);
            clients = converter(rs);
        }catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println("Error with SQL!");
        }
        return clients;
    }

    public List<Clients> getClientsByNameAndCity(String name, String city) {
        List<Clients> clients = new ArrayList<>();
        try (Connection connection =  this.connection){
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Customer_dim where customer_name = \'" + name + "\' and city_name = \'" + city + "\'");
            clients = converter(rs);
        }catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println("Error with SQL!");
        }
        return clients;
    }

    public List<Clients> getClientsByCountryAndSex(String country, String sex) {
        List<Clients> clients = new ArrayList<>();
        try (Connection connection =  this.connection) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Customer_dim where country_name=\'" + country + "\' and sex = \'" + sex + "\'");
            clients = converter(rs);
        }catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println("Error with SQL!");
        }
        return clients;
    }

}

