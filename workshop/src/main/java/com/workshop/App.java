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
        InputStream is = App.class.getResourceAsStream(fileName);

        if (is == null) {
            throw new NullPointerException("Cannot find resources file" + fileName);
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONArray clients = new JSONArray(tokener);

        List<Client> clientList = new ArrayList<>();

        for (int i = 0; i < clients.length(); i++) {
            JSONObject client = clients.getJSONObject(i);
            System.out.println("Name: " + client.getString("name"));
            System.out.println("Email: " + client.getString("email"));
            System.out.println("Phone: " + client.getString("phone"));

            Client cl1 = new Client(  client.getString("name"), client.getString("email"), client.getString("phone"));
            clientList.add(cl1);
            System.out.println();
        }
        System.out.println("===========LIST===========");
        //clientList.remove(0);
        //clientList.remove(2);
        clientList.set(0, new Client("fileName", "fileName", "fileName"));

        for (Client client : clientList) {
            System.out.println(client);
        }


        ClientService clientService = new ClientService(clientList);

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
