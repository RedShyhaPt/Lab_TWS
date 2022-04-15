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
        try (Connection connection =  ConnectionUtil.getConnection()){
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
        try (Connection connection =  ConnectionUtil.getConnection()){
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
        try (Connection connection =  ConnectionUtil.getConnection()){
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
        try (Connection connection =  ConnectionUtil.getConnection()){
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
        try (Connection connection =  ConnectionUtil.getConnection()){
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
        try (Connection connection =  ConnectionUtil.getConnection()){
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
        try (Connection connection =  ConnectionUtil.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Customer_dim where country_name=\'" + country + "\' and sex = \'" + sex + "\'");
            clients = converter(rs);
        }catch (SQLException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE,null, e);
            System.out.println("Error with SQL!");
        }
        return clients;
    }

    //Lab 2 starts here
    public List<Clients> createNewClient(Clients client) {
        List<Clients> clients = new ArrayList<>();
        try (Connection connection =  ConnectionUtil.getConnection()){
            String query = String.format("insert Customer_dim (customer_id,customer_name, city_name, country_name, contact, sex) "
                    + "values ('%d','%s', '%s', '%s', '%s', '%s')", client.getId(),client.getName(), client.getCity(),
                    client.getCountry(), client.getContact(),client.getSex());

            System.out.println("Creating...");
            Statement st = connection.createStatement();
            st.executeUpdate(query);
            System.out.println("Created!");

            clients.add(client);
            getAllClients();
            st.close();
        }catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return clients;
    }

    public String updateClient(Clients client) {
        String query = String.format("update Customer_dim set customer_name='%s', city_name='%s'," +
                        " country_name='%s', contact='%s', sex='%s' where customer_id = %d",
                client.getName(), client.getCity(), client.getCountry(),
                client.getContact(), client.getSex(), client.getId());
        try(Connection connection =  ConnectionUtil.getConnection()) {
            Statement st = connection.createStatement();
            System.out.println("Updating...");
            st.executeUpdate(query);
            System.out.println("Complete!");
            getAllClients();
            st.close();
        }catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return "Client updated!";
    }

    public String deleteClient(int id) {
        String query = String.format("Delete from Customer_dim where customer_id = %d",id);
        try (Connection connection =  ConnectionUtil.getConnection()){
            Statement st = connection.createStatement();
            System.out.println("Deleting...");
            st.executeUpdate(query);
            System.out.println("Complete!");
            getAllClients();
            st.close();
        }catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return "Client deleted!";
    }
}
