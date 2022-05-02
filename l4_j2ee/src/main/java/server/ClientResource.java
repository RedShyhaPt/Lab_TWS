package server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/clients")
@Produces({MediaType.APPLICATION_JSON})
public class ClientResource {
    @Resource(lookup = "ws-ifmo")
    private DataSource dataSource;

    @GET
    public List<Clients> getClients() {
        List<Clients> clients = new DAO(getConnection()).getAllClients();
        return clients;
    }

    @GET
    @Path("byName")
    public List<Clients> getClientsByName(@QueryParam("name") String name) {
        List<Clients> clients = new DAO(getConnection()).getClientsByName(name);
        return clients;
    }

    @GET
    @Path("byCity")
    public List<Clients> getClientsByCity(@QueryParam("city") String city) {
        List<Clients> clients = new DAO(getConnection()).getClientsByCity(city);
        return clients;
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ClientResource.class.getName()).log(Level.SEVERE, null, ex);

        }
        return result;
    }
}
