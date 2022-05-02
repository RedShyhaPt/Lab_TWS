package server;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/clients")
@Produces({MediaType.APPLICATION_JSON})
public class ClientResource {

    @GET()
    public List<Clients> getClients() {
        List<Clients> clients = new DAO().getAllClients();
        return clients;
    }

    @GET
    @Path("byName")
    public List<Clients> getClientsByName(@QueryParam("name") String name) {
        List<Clients> clients = new DAO().getClientsByName(name);
        return clients;
    }

    @GET
    @Path("byCity")
    public List<Clients> getClientsByCity(@QueryParam("city") String city) {
        List<Clients> clients = new DAO().getClientsByCity(city);
        return clients;
    }
}
