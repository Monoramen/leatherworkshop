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
        System.out.println("++++".repeat(5) + " First file \n");

        for (Client client : clientList) {
            System.out.println(client);
        }
        System.out.println();

        String fileName2 = "/clients2.json";
        List<Client> clientList2 = new ReadJsonFile(fileName2).readFile();

        System.out.println("++++".repeat(5) + " Second file \n");

        for (Client client : clientList2) {
            System.out.println(client);
        }
        System.out.println();

        System.out.println("++++".repeat(5) + " First + Second Lists  \n");

        ClientService clientService = new ClientService(clientList);
        clientService.addAll(clientList2);


        for (Client client : clientService.getLinkedClients()) {
            System.out.println(client);
        }
        System.out.println("===========LIST===========");


        for (Client client : clientList) {
            System.out.println(client);
        }




        System.out.println("===========Last index of===========");
        clientList.remove(4);
        for (Client client : clientList) {
            System.out.println(client);
        }
        System.out.println("===========clientService===========");
        String name = "Hank Lopez";
        clientService.remove(name);

        for (Client client : clientService.getClients()) {
            System.out.println(client);
        }

        clientService.addClients("Audubis Musthacha", "german@exmaple.com", "+623429872345");



        for (Client client : clientService.getLinkedClients()) {
            System.out.println(client.getEmail());
        }

        //System.out.println(clientService.get(0));
        Client cl1 = new Client( "Olivay Gara", "gara@exmaple.com", "+6239925" );

        Order ord1 = new Order(cl1, true, 1);

        System.out.println(ord1);


    }
}
