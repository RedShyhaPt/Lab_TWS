package server;

import server.error.InvalidClientArgumentException;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
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
                                         @QueryParam("sex") String sex,
                                         @QueryParam("auth") String auth)
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
        if (isAuthenticated(auth)) {
            System.out.println("Add new client with name" + name);
            return new DAO().createNewClient(client);
        }
        else return null;
    }

    @PUT
    public String updateClient(@QueryParam("id") int id,
                               @QueryParam("name") String name,
                               @QueryParam("city") String city,
                               @QueryParam("country") String country,
                               @QueryParam("contact") String contact,
                               @QueryParam("sex") String sex,
                               @QueryParam("auth") String auth)
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

        if (isAuthenticated(auth)) {
            System.out.println("Update client " + name);
            return ("Authentication success!\n" + new DAO().updateClient(client));
        }
        else return "Authentication failed!";


    }

    @DELETE
    public String deleteClient(@QueryParam("id") int id,
                               @QueryParam("auth") String auth) throws InvalidClientArgumentException {
        if ((id < 0) || (id == 0)) throw InvalidClientArgumentException.DEFAULT_INSTANCE;

        if (isAuthenticated(auth)) {
            System.out.println("Delete client with id = " + id);
            return ("Authentication success!\n"+new DAO().deleteClient(id));
        }
        else return "Authentication failed!";
    }

    @GET
    @Path("byName")
    public List<Clients> getClientsByName(@QueryParam("name") String name)
            throws InvalidClientArgumentException {
        if (name == null || name.trim().isEmpty())
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        return new DAO().getClientsByName(name);
    }

    @GET
    @Path("byCity")
    public List<Clients> getClientsByCity(@QueryParam("city") String city)
            throws InvalidClientArgumentException {
        if (city == null || city.trim().isEmpty())
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        return new DAO().getClientsByCity(city);
    }

    @GET
    @Path("byId")
    public List<Clients> getClientsById(@QueryParam("id") int id)
            throws InvalidClientArgumentException {
        if (id == 0 || id < 0)
            throw InvalidClientArgumentException.DEFAULT_INSTANCE;
        return new DAO().getClientsById(id);
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
