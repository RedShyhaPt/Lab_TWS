package client;

import client.client_generated.*;
import client.client_generated.ThrottlingException;
import client.client_generated.IllegalArgumentException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/ClientService?wsdl");
        //URL url = new URL("http://desktop-5aeihso:8080/l1_j2ee-17839880486531206586.0-SNAPSHOT/ClientService?wsdl");
        ClientService clientService = new ClientService(url);
        List<Clients> clients;
        chekedClients(clientService);
        int countOfExecution = 1;

        /*try {
            System.out.println("    Create client   ");
            clients = clientService.getClientWebServicePort().createNewClient(
                    21, "rt", "Казань",
                    "Россия",
                    "Нет",
                    "Male", countOfExecution,
                    basicAuth());
            print(clients);
            chekedClients(clientService);
            System.out.println();
            countOfExecution +=1;
        } catch (IllegalArgumentException | ThrottlingException e) {
            System.out.println("Error: " + e.getMessage());
        }*/

        /*try {
            System.out.println("    Create client   ");
            clients = clientService.getClientWebServicePort().createNewClient(23, "sdf", "Казань", "Россия", "Нет", "Male", 2);
            print(clients);
            chekedClients(clientService);
            System.out.println();
            countOfExecution +=1;
        } catch (IllegalArgumentException | ThrottlingException e) {
            System.out.println("Error: " + e.getMessage());
        }*/

        /*try {
            System.out.println("    Update client   ");
            String clientUpdate = clientService.getClientWebServicePort().updateClient(14, "Вячеслав", "Новгород", "Россия",
                    "slaven@mail.com", "Male",basicAuth());
            System.out.println(clientUpdate);
            chekedClients(clientService);
            System.out.println();
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

        try {
            System.out.println("    Delete client   ");
            String deleting = clientService.getClientWebServicePort().deleteClient(
                    20,basicAuth());
            System.out.println("Authorize success!");
            System.out.println(deleting);
            chekedClients(clientService);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

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

    public static String basicAuth() {
        String login = "wsifmo";
        String password = "wsifmo";
        return new String(Base64.getEncoder().encode(new String(login + ":" + password).getBytes()));
    }
}
