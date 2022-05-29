package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import server.Clients;
import server.error.InvalidClientArgumentException;
import sun.misc.BASE64Decoder;
import sun.security.krb5.Credentials;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;


public class Main {

    private static final String URL = "http://localhost:8080/rest/clients";
    private static final String URL1 = "http://localhost:8080/rest/clients/byName";
    private static final String URL2 = "http://localhost:8080/rest/clients/byCity";

    public static void main(String[] args) throws InvalidClientArgumentException, IOException {

        Client client = Client.create();
        // выводим всех клиентов
        printList(getAllClients(client));
        // создаём нового клиента
        printList(createNewClient(client, 14, "Азат","Москва", "", "df", "Male", basicAuth()));
        // обновляем клиента
        System.out.println(updateClient(client, 19, "Азт","Петербург", "Россия", "azt@mail.ru", "Male", basicAuth()));
        //System.out.println(deleteClient(client,19,basicAuth()));
        // проверяем изменеия
        printList(getAllClients(client));
    }

    private static List<Clients> getAllClients(Client client)
    {
        WebResource webResource = client.resource(URL);
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

    private static List<Clients> createNewClient(Client client, int id,
                                                 String name,
                                                 String city,
                                                 String country,
                                                 String contact,
                                                 String sex,
                                                 String auth) throws InvalidClientArgumentException {
        WebResource webResource = client.resource(URL);
        if (name != null) {
            webResource = webResource.queryParam("name",name);
            webResource = webResource.queryParam("id", String.valueOf(id));
            webResource = webResource.queryParam("city",city);
            webResource = webResource.queryParam("country",country);
            webResource = webResource.queryParam("contact",contact);
            webResource = webResource.queryParam("sex",sex);
            webResource = webResource.queryParam("auth",auth);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new InvalidClientArgumentException("Empty Argument!");
        }
        GenericType<List<Clients>> type = new GenericType<List<Clients>>()
        {};
        return response.getEntity(type);
    }

    private static String updateClient(Client client, int id,
                                                 String name,
                                                 String city,
                                                 String country,
                                                 String contact,
                                                 String sex,
                                                 String auth) throws InvalidClientArgumentException {
        WebResource webResource = client.resource(URL);
        if (name != null) {
            webResource = webResource.queryParam("name",name);
            webResource = webResource.queryParam("id", String.valueOf(id));
            webResource = webResource.queryParam("city",city);
            webResource = webResource.queryParam("country",country);
            webResource = webResource.queryParam("contact",contact);
            webResource = webResource.queryParam("sex",sex);
            webResource = webResource.queryParam("auth",auth);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class);
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new InvalidClientArgumentException("Empty Argument!");
        }

        GenericType<String> type = new GenericType<String>()
        {};
        return response.getEntity(type);
    }

    private static String deleteClient(Client client, int id, String auth) throws InvalidClientArgumentException {
        WebResource webResource = client.resource(URL);
        if (id != 0) {
            webResource = webResource.queryParam("id", String.valueOf(id));
            webResource = webResource.queryParam("auth",auth);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new InvalidClientArgumentException("Empty Argument!");
        }
        else System.out.println("Ok");
        GenericType<String> type = new GenericType<String>()
        {};
        return response.getEntity(type);
    }

    private static List<Clients> getClientsByName(Client client, String name)
    {
        WebResource webResource = client.resource(URL1);
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
        WebResource webResource = client.resource(URL2);
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

    public static String basicAuth() {
        String login = "admn";
        String password = "admin";
        return new String(Base64.getEncoder().encode(new String(login + ":" + password).getBytes()));
    }
}
