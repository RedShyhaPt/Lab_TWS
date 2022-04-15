package server;

import java.sql.SQLException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
                                                   @WebParam(name = "sex") String sex) {
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
                                      @WebParam(name = "sex") String sex) {
        DAO dao = new DAO();

        Clients client = new Clients(id, name, city, country, contact, sex);
        return dao.createNewClient(client);
    }

    @WebMethod(operationName = "updateClient")
    public String updateClient(@WebParam(name = "id") int id, @WebParam(name = "name") String name,
                               @WebParam(name = "city") String city,
                               @WebParam(name = "country") String country,
                               @WebParam(name = "contact") String contact,
                               @WebParam(name = "sex") String sex) {

        DAO dao = new DAO();
        Clients client = new Clients(id, name, city, country, contact, sex);

        return dao.updateClient(client);
    }

    @WebMethod(operationName = "deleteClient")
    public String deleteClient(@WebParam(name = "id") int id) {
        DAO dao = new DAO();

        return dao.deleteClient(id);
    }
}
