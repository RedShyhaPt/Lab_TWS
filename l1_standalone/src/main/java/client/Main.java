package client;

import client.client_generated.Clients;
import client.client_generated.ClientService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/ClientService?wsdl");
        ClientService personService = new ClientService(url);
        List<Clients> clients =
                personService.getClientWebServicePort().getAllClients();
        for (Clients client : clients) {
            System.out.println("name: " + client.getName() +
                    ", contact: " + client.getContact() + ", city: " +
                    client.getCity());
        }
        System.out.println("Total clients: " + clients.size());
    }
}
