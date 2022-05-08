package client;

import client.client_generated.ClientService;
import client.client_generated.ClientServiceFault;
import client.client_generated.Clients;
import client.client_generated.IllegalArgumentException;
import server.error.ThrottlingException;

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
        int countOfExecution = 1;

        try {
            System.out.println("    Create client   ");
            clients = clientService.getClientWebServicePort().createNewClient(17, "sdf", "Казань", "Россия", "Нет", "Male", countOfExecution);
            print(clients);
            chekedClients(clientService);
            System.out.println();
            countOfExecution +=1;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("    Create client   ");
            clients = clientService.getClientWebServicePort().createNewClient(18, "sdf", "Казань", "Россия", "Нет", "Male", countOfExecution);
            print(clients);
            chekedClients(clientService);
            System.out.println();
            countOfExecution +=1;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        /*try {
            System.out.println("    Update client   ");
            String clientUpdate = clientService.getClientWebServicePort().updateClient(14, "Вячеслав", "Новгород", "Россия",
                    "slaven@mail.com", "Male");
            System.out.println(clientUpdate);
            chekedClients(clientService);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }


        try {
            System.out.println("    Delete client   ");
            String deleting = clientService.getClientWebServicePort().deleteClient(16);
            System.out.println(deleting);
            chekedClients(clientService);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            System.out.println("    Clients by country & sex   ");
            clients = clientService.getClientWebServicePort().getClientsByCountryAndSex("Россия", "Male");
            print(clients);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }*/


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
