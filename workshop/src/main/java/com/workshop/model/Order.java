package com.workshop.model;

public class Order {
    private boolean readiness = false;
    private Client client;
    private String material;

    public Order (Client client, boolean ready, int material) {
        this.client = client;
        this.readiness = ready;
        this.material = Material.selectMaterial(material);
    }


    @Override
    public String toString() {
        String ready = "not ready";
        if (readiness) ready = "ready";
        return "Order\t{ " + client + "\n" + "material: " + material + "\t Readiness: " + ready;
    }

}
