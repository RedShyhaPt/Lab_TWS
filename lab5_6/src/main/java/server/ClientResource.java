package server;

import server.error.InvalidClientArgumentException;

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

    @POST
    public List<Clients> createNewClient(@QueryParam("id") int id,
                                         @QueryParam("name") String name,
                                         @QueryParam("city") String city,
                                         @QueryParam("country") String country,
                                         @QueryParam("contact") String contact,
                                         @QueryParam("sex") String sex)
            throws InvalidClientArgumentException {
        if ((id < 0) || (id == 0))
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        if (name == null || name.equals(""))
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        if (city == null || city.equals(""))
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        if (contact == null || contact.equals(""))
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;

        Clients client = new Clients(id, name, city, country, contact, sex);
        System.out.println("Add new client with name" + name);
        return new DAO().createNewClient(client);
    }

    @PUT
    public String updateClient(@QueryParam("id") int id,
                               @QueryParam("name") String name,
                               @QueryParam("city") String city,
                               @QueryParam("country") String country,
                               @QueryParam("contact") String contact,
                               @QueryParam("sex") String sex)
            throws InvalidClientArgumentException {
        Clients client = new Clients(id, name, city, country, contact, sex);
        if (getClientsById(id).isEmpty())
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        if (name == null || name.equals(""))
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        if (city == null || city.equals(""))
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        if (contact == null || contact.equals(""))
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        System.out.println("Update client " + name);
        return new DAO().updateClient(client);
    }

    @DELETE
    public String deleteClient(@QueryParam("id") int id) throws InvalidClientArgumentException {
        if ((id < 0) || (id == 0))
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;

        System.out.println("Delete client with id = " + id);
        return new DAO().deleteClient(id);
    }

    @GET
    @Path("byName")
    public List<Clients> getClientsByName(@QueryParam("name") String name)
            throws InvalidClientArgumentException {
        if (name == null || name.trim().isEmpty())
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        List<Clients> clients = new DAO().getClientsByName(name);
        return clients;
    }

    @GET
    @Path("byCity")
    public List<Clients> getClientsByCity(@QueryParam("city") String city)
            throws InvalidClientArgumentException {
        if (city == null || city.trim().isEmpty())
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        List<Clients> clients = new DAO().getClientsByCity(city);
        return clients;
    }

    @GET
    @Path("byId")
    public List<Clients> getClientsById(@QueryParam("id") int id)
            throws InvalidClientArgumentException {
        if (id == 0 || id < 0)
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        List<Clients> clients = new DAO().getClientsById(id);
        return clients;
    }
}
