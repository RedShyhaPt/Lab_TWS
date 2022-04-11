package client;

import client.client_generated.Clients;
import client.client_generated.ClientService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class Main {
    public static void main(String[] args) throws MalformedURLException {
        //URL url = new URL("http://localhost:8080/ClientService?wsdl");
        URL url = new URL("http://desktop-5aeihso:8080/l1_j2ee-17839880486531206586.0-SNAPSHOT/ClientService?wsdl");
        ClientService personService = new ClientService(url);

        System.out.println("    All clients in DB   ");
        List<Clients> clients = personService.getClientWebServicePort().getAllClients();
        print(clients);
        System.out.println();

        System.out.println("    Clients by name   ");
        clients = personService.getClientWebServicePort().getClientsByName("Азат");
        print(clients);
        System.out.println();

        System.out.println("    Clients by city   ");
        clients = personService.getClientWebServicePort().getClientsByCity("Брисбен");
        print(clients);
        System.out.println();

        System.out.println("    Clients by contact   ");
        clients = personService.getClientWebServicePort().getClientsByContact("minami228@gmail.com");
        print(clients);
        System.out.println();

        System.out.println("    Clients by country & sex   ");
        clients = personService.getClientWebServicePort().getClientsByCountryAndSex("Россия","Male");
        print(clients);
        System.out.println();
    }

    public static void print (List<Clients> clients){
        for (Clients client : clients) {
            System.out.println("Client " + client.getName() + ", " + client.getSex() + " from " +
                    client.getCity() + ", " + client.getCountry() + " with @mail: " + client.getContact());
        }
        System.out.println("Total clients: " + clients.size());
    }
}
