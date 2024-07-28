package com.workshop.service;

import com.workshop.model.Client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ClientService {
    private List<Client> clients;
    private LinkedList<Client> linkedClients;
    private Long nextId = 1L;


    public ClientService(List<Client> clientList) {
        this.clients = clientList;
        this.linkedClients = new LinkedList<>(clientList);
    }



    public List<Client> getClients() {
        return clients;
    }

    public void remove(String name){
        Iterator<Client> iterator = clients.iterator();
        while (iterator.hasNext()) {
            Client client = iterator.next();
            if(client.getName().equals(name)){
                iterator.remove();
                break;
            }

        }
    }

    public void addClients( String name, String email, String phone){
        linkedClients.addLast(new Client(name, email, phone));
    }



    public LinkedList<Client> getLinkedClients(){
        return linkedClients;
    }

    public void addAll(List<Client> clientList2){
        linkedClients.addAll(clientList2);
    }

}
