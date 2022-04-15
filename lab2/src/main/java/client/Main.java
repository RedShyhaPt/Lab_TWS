package client;

import client.client_generated.Clients;
import client.client_generated.ClientService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/ClientService?wsdl");
        //URL url = new URL("http://desktop-5aeihso:8080/l1_j2ee-17839880486531206586.0-SNAPSHOT/ClientService?wsdl");
        ClientService clientService = new ClientService(url);
        List<Clients> clients;
        chekedClients(clientService);

        System.out.println("    Create client   ");
        clients = clientService.getClientWebServicePort().createNewClient(14,"Рустам", "Казань",
                "Россия", "Нет", "Male");
        chekedClients(clientService);
        System.out.println();

        System.out.println("    Update client   ");
        String clientUpdate = clientService.getClientWebServicePort().updateClient(14,"Вячеслав", "Новгород", "Россия",
                "slaven@mail.com", "Male");
        System.out.println(clientUpdate);
        chekedClients(clientService);
        System.out.println();

        /*System.out.println("    Delete client   ");
        String deleting = clientService.getClientWebServicePort().deleteClient(14);
        System.out.println(deleting);
        chekedClients(clientService);*/

    }

    public static void print (List<Clients> clients){
        for (Clients client : clients) {
            System.out.println("Client " + client.getName() + ", " + client.getSex() + " from " +
                    client.getCity() + ", " + client.getCountry() + " with @mail: " + client.getContact());
        }
        System.out.println("Total clients: " + clients.size());
    }


    public static void chekedClients (ClientService clientService) {
        System.out.println("    All clients in DB   ");
        List<Clients> clients = clientService.getClientWebServicePort().getAllClients();
        print(clients);
        System.out.println();
    }
}