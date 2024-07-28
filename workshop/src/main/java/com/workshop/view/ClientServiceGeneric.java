package com.workshop.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.workshop.model.Client;


public class ClientServiceGeneric<T> {

    private List<T> clients;
    private LinkedList<T> linkedClients;
    private Long nextId = 1L;


    public ClientServiceGeneric(List<T> t){
        this.clients =  t;
        this.linkedClients = new LinkedList<>(clients);
    }

    public List<T> getClients() {
        return clients;
    }

    public LinkedList<T> getLinkedClients(){
        return linkedClients;
    }

    public void addAll(List<T> clientList2) {
        linkedClients.addAll(clientList2);
    }


        public void remove(String name) {
        Iterator<T> iterator = clients.iterator();
        while (iterator.hasNext()) {
            T client = iterator.next();
            if (client instanceof Client && ((Client) client).getName().equals(name)) {
                iterator.remove();
                break;
            }
        }
    }
}
