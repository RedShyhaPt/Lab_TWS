package j2ee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;


@WebService(targetNamespace = "http://server/", serviceName = "ClientService")
public class ClientWebService {
    public ClientWebService() {}

    @Resource(lookup = "ws-ifmo")
    private DataSource dataSource;

    @WebMethod(operationName = "getAllClients")
    public List<Clients> getAllClients() {
        DAO dao = new DAO(getConnection());
        return dao.getAllClients();
    }

    @WebMethod(operationName = "getClientsByName")
    public List<Clients> getClientByName(@WebParam(name = "name") String name) {
        DAO dao = new DAO(getConnection());
        return dao.getClientsByName(name);
    }

    @WebMethod(operationName = "getClientsByCity")
    public List<Clients> getClientsByCity(@WebParam(name = "city") String city) {
        DAO dao = new DAO(getConnection());
        return dao.getClientsByCity(city);
    }

    @WebMethod(operationName = "getClientsByContact")
    public List<Clients> getClientsByContact(@WebParam(name = "contact") String contact) {
        DAO dao = new DAO(getConnection());
        return dao.getClientsByContact(contact);
    }

    @WebMethod(operationName = "getClientsById")
    public List<Clients> getClientsById(@WebParam(name = "id") int id) {
        DAO dao = new DAO(getConnection());
        return dao.getClientsById(id);
    }

    @WebMethod(operationName = "getClientsByNameAndCity")
    public List<Clients> getClientsByNameAndCity(@WebParam(name = "name") String name,
                                                 @WebParam(name = "city") String city) {
        DAO dao = new DAO(getConnection());
        return dao.getClientsByNameAndCity(name,city);
    }

    @WebMethod(operationName = "getClientsByCountryAndSex")
    public List<Clients> getClientsByCountryAndSex(@WebParam(name = "country") String country,
                                                   @WebParam(name = "sex") String sex) {
        DAO dao = new DAO(getConnection());
        return dao.getClientsByCountryAndSex(country,sex);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException e) {
            Logger.getLogger(ClientWebService.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }
}

