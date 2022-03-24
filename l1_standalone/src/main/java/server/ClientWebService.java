package server;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "ClientService")
public class ClientWebService {

    @WebMethod(operationName = "getClient")
    public List<Clients> getClients() {
        DAO dao = new DAO();
        return dao.getClients();
    }
}
