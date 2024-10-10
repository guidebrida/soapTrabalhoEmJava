package org.example;


import jakarta.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        String address = "http://localhost:8081/orders";
        Endpoint.publish(address, new OrderService());
        System.out.println("Published at address : "+address);

    }
}