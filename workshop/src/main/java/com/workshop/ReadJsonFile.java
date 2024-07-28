package com.workshop;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.workshop.model.Client;

public class ReadJsonFile {

        public String fileName;

        public ReadJsonFile(String file){
            this.fileName = file;
        }
        public  List<Client> readFile(){
            InputStream is = App.class.getResourceAsStream(fileName);

            if (is == null) {
                throw new NullPointerException("Cannot find resources file" + fileName);
            }

            JSONTokener tokener = new JSONTokener(is);
            JSONArray clients = new JSONArray(tokener);

            List<Client> clientList = new ArrayList<>();

            for (int i = 0; i < clients.length(); i++) {
                JSONObject client = clients.getJSONObject(i);
                Client cl1 = new Client(client.getString("name"), client.getString("email"), client.getString("phone"));
                clientList.add(cl1);
            }
            return clientList;
        }


}
