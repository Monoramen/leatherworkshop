package com.workshop;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;



import com.workshop.model.Client;
import com.workshop.model.Order;
import com.workshop.service.ClientService;
import com.workshop.view.DisplayCollection;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {


        String fileName = "/clients.json";
        List<Client> clientList = new ReadJsonFile(fileName).readFile();
        System.out.println();
        System.out.println("++++".repeat(5) + " First file ");

        for (Client client : clientList) {
            System.out.println(client);
        }
        System.out.println();

        String fileName2 = "/clients2.json";
        List<Client> clientList2 = new ReadJsonFile(fileName2).readFile();

        System.out.println("++++".repeat(5) + " Second file ");

        for (Client client : clientList2) {
            System.out.println(client);
        }
        System.out.println();

        System.out.println("++++".repeat(5) + " First + Second Lists ");

        ClientService clientService = new ClientService(clientList);
        clientService.addAll(clientList2);


        for (Client client : clientService.getLinkedClients()) {
            System.out.println(client);
        }
        System.out.println();

        System.out.println("===========LIST===========");


        for (Client client : clientList) {
            System.out.println(client);
        }
        System.out.println();




        System.out.println("===========Remove from clientList index 4 several time===========");
        clientList.remove(4);
        clientList.remove(4);
        clientList.remove(4);
        clientList.remove(4);
        for (Client client : clientList) {
            System.out.println(client);
        }
        System.out.println();



        System.out.println("===========clientService remove by name (field)===========");
        String name = "Hank Lopez";
        clientService.remove(name);

        for (Client client : clientService.getClients()) {
            System.out.println(client);
        }
        System.out.println();


        clientService.addClients("Audubis Musthacha", "german@exmaple.com", "+623429872345");


        System.out.println("===========getLinkedClients===========");

        for (Client client : clientService.getLinkedClients()) {
            System.out.println(client);
        }

        System.out.println();


        System.out.println("===========Class Order ===========");

        Client cl1 = new Client( "Olivay Gara", "gara@exmaple.com", "+6239925" );

        Order ord1 = new Order(cl1, true, 1);

        System.out.println(ord1);
        System.out.println();

        System.out.println("===========Generics ===========");

        DisplayCollection<Client>  gener = new DisplayCollection<>();
        gener.add(cl1);
        gener.add(new Client("Мавроди", "mavrody@maio.ru", "+232355411524"));

        System.out.print(gener.get(0));
        System.out.print(gener.get(1));

    }
}
