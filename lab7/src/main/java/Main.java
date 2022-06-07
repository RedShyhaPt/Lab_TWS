import juddi.Browser;
import juddi.Publisher;

import java.util.Scanner;
// set JAVA_OPTS=-Djavax.xml.accessExternalDTD=all
public class Main {
    private static final String URL = "http://localhost:8084/ClientService?wsdl";

    public static void main(String[] args) {
        // Регистрация сервиса
        System.out.println("Publish new service");
        String businessName = "Shopper";
        String serviceName = "ClientServices";
        System.out.println("Business " + businessName + ", service " + serviceName + " will be created");
// Регестрируем в Juddi
        Publisher publisher = new Publisher();
        publisher.publish(businessName, serviceName, URL);
        System.out.println("--------------------------------\n\n");
        /*
        // Показать все сервисы
        System.out.println("Search service");
        Browser browser = new Browser();
        browser.ViewAll();
        System.out.println("--------------------------------\n\n");
// Поиск сервиса по имени
        System.out.println("Find service by name");
        String name = "Client_Service";
        Browser searchService = new Browser();
        searchService.findServiceByName(name);
        System.out.println("--------------------------------\n\n");

*/


    }
}