package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import server.Clients;

import java.util.List;
import javax.ws.rs.core.MediaType;


public class Main {

    /*private static final String URL = "http://localhost:8080/rest/clients";
    private static final String URL1 = "http://localhost:8080/rest/clients/byName";
    private static final String URL2 = "http://localhost:8080/rest/clients/byCity";*/

    private static final String URLfish =
            "http://DESKTOP-5AEIHSO:8080/l4_j2ee-17140180939954671110.0-SNAPSHOT/rest/clients";
    private static final String URLfish1 =
            "http://DESKTOP-5AEIHSO:8080/l4_j2ee-17140180939954671110.0-SNAPSHOT/rest/clients/byName";
    private static final String URLfish2 =
            "http://DESKTOP-5AEIHSO:8080/l4_j2ee-17140180939954671110.0-SNAPSHOT/rest/clients/byCity";

    public static void main(String[] args) {

        Client client = Client.create();
        // выводим всех клиентов
        printList(getAllClients(client));
        // выводим всех клиентов по имени
        printList(getClientsByName(client, "Азат"));
        // выводим всех клиентов по городу
        printList(getClientsByCity(client, "Москва"));
    }

    private static List<Clients> getAllClients(Client client)
    {
        WebResource webResource = client.resource(URLfish);
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<Clients>> type = new GenericType<List<Clients>>()
        {};
        return response.getEntity(type);
    }

    private static List<Clients> getClientsByName(Client client, String name)
    {
        WebResource webResource = client.resource(URLfish1);
        if (name != null) {
            webResource = webResource.queryParam("name", name);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<Clients>> type = new GenericType<List<Clients>>()
        {};
        return response.getEntity(type);
    }

    private static List<Clients> getClientsByCity(Client client, String city)
    {
        WebResource webResource = client.resource(URLfish2);
        if (city != null) {
            webResource = webResource.queryParam("city", city);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<Clients>> type = new GenericType<List<Clients>>()
        {};
        return response.getEntity(type);
    }

    private static void printList(List<Clients> clients) {
        for (Clients client : clients) {
            System.out.println(client);
        }
        System.out.println();
        System.out.println();
    }
}
