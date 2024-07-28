package com.workshop.view;

import java.util.ArrayList;
import java.util.List;

import com.workshop.model.Client;


public class ClientGeneric<T extends Client> {
    private  List<T> client;

    public ClientGeneric(){
        client = new ArrayList<>();
    }


    public void add(T t){
        client.add(t);
    }

    public T get(int index){ return client.get(index); }

}
