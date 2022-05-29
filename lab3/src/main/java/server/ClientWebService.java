package server;

import server.error.ClientServiceFault;
import server.error.IllegalArgumentException;
import server.error.ThrottlingException;
import server.error.ThrottlingFault;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(serviceName = "ClientService")
public class ClientWebService {
    public ClientWebService() {}

    @WebMethod(operationName = "getAllClients")
    public List<Clients> getAllClients() {
        DAO dao = new DAO();
        return dao.getAllClients();
    }

    @WebMethod(operationName = "getClientsByName")
    public List<Clients> getClientByName(@WebParam(name = "name") String name) {
        DAO dao = new DAO();
        return dao.getClientsByName(name);
    }

    @WebMethod(operationName = "getClientsByCity")
    public List<Clients> getClientsByCity(@WebParam(name = "city") String city) {
        DAO dao = new DAO();
        return dao.getClientsByCity(city);
    }

    @WebMethod(operationName = "getClientsByContact")
    public List<Clients> getClientsByContact(@WebParam(name = "contact") String contact) {
        DAO dao = new DAO();
        return dao.getClientsByContact(contact);
    }

    @WebMethod(operationName = "getClientsById")
    public List<Clients> getClientsById(@WebParam(name = "id") int id) {
        DAO dao = new DAO();
        return dao.getClientsById(id);
    }

    @WebMethod(operationName = "getClientsByNameAndCity")
    public List<Clients> getClientsByNameAndCity(@WebParam(name = "name") String name,
                                                                          @WebParam(name = "city") String city) {
        DAO dao = new DAO();
        return dao.getClientsByNameAndCity(name,city);
    }

    @WebMethod(operationName = "getClientsByCountryAndSex")
    public List<Clients> getClientsByCountryAndSex(@WebParam(name = "country") String country,
                                                   @WebParam(name = "sex") String sex) throws IllegalArgumentException {
        if ( country== null || country.equals("")) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Enter country!",fault);
        }

        if (sex == null || sex.equals("")) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Enter sex!",fault);
        }

        DAO dao = new DAO();
        return dao.getClientsByCountryAndSex(country,sex);
    }


    // lab2 CRUD: create, update & delete
    @WebMethod(operationName = "createNewClient")
    public List<Clients> createNewClient(@WebParam(name = "id") int id,
                                      @WebParam(name = "name") String name,
                                      @WebParam(name = "city") String city,
                                      @WebParam(name = "country") String country,
                                      @WebParam(name = "contact") String contact,
                                      @WebParam(name = "sex") String sex,
                                      @WebParam(name = "count") int count,
                                      @WebParam(name = "auth") String auth) throws IllegalArgumentException, ThrottlingException {
        if (!isAuthenticated(auth)) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Invalid login or password!",fault);
        }

        if ((id < 0) || (id == 0)) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Empty or negative id isn't allowed!",fault);
        }

        if (name == null || name.equals("")) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Please enter argument name!",fault);
        }

        if (city == null || city.equals("")) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Please enter argument city!",fault);
        }

        if (contact == null || contact.equals("")) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Please enter argument contact!",fault);
        }

        if (count > 1) {
            ThrottlingFault fault = new ThrottlingFault();
            throw new ThrottlingException("Not allowed create client more then 1 time for 1 query!",fault);
        }

        DAO dao = new DAO();
        Clients client = new Clients(id, name, city, country, contact, sex);
        return dao.createNewClient(client);
    }

    @WebMethod(operationName = "updateClient")
    public String updateClient(@WebParam(name = "id") int id, @WebParam(name = "name") String name,
                               @WebParam(name = "city") String city,
                               @WebParam(name = "country") String country,
                               @WebParam(name = "contact") String contact,
                               @WebParam(name = "sex") String sex,
                               @WebParam(name = "auth") String auth) throws IllegalArgumentException{
        Clients client = new Clients(id, name, city, country, contact, sex);

        if (!isAuthenticated(auth)) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Invalid login or password!",fault);
        }

        if (getClientsById(id).isEmpty()){
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Id empty, please enter it!", fault);
        }
        if (client.getName() == null || client.getName().equals("")) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Please enter argument name!", fault);
        }

        if (client.getCity() == null || client.getCity().equals("")) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Please enter argument city!",fault);
        }

        if (client.getContact() == null || client.getContact().equals("")) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Please enter argument contact!",fault);
        }

        DAO dao = new DAO();
        return dao.updateClient(client);
    }

    @WebMethod(operationName = "deleteClient")
    public String deleteClient(@WebParam(name = "id") int id,
                               @WebParam(name = "auth") String auth) throws IllegalArgumentException {
        if (!isAuthenticated(auth)) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Invalid login or password!",fault);
        }

        if ((id < 0) || (id == 0)) {
            ClientServiceFault fault = new ClientServiceFault();
            throw new IllegalArgumentException("Empty or negative id isn't allowed!",fault);
        }

        DAO dao = new DAO();
        return dao.deleteClient(id);
    }

    private boolean isAuthenticated(String auth) {
        String decode = "";
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(auth);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        assert bytes != null;
        decode = new String(bytes);
        System.out.println(decode);

        String [] details = decode.split(":");
        String login = details[0];
        String password = details[1];
        return Objects.equals(login, "admin") && Objects.equals(password, "admin");
    }
}
