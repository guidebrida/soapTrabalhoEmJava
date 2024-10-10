package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private List<Product> products = new ArrayList<>();
    private String endereco;
    private String status;

    public Order() {

    }

    public Order(int id, List<Product> products, String endereco, String status) {
        this.id = id;
        this.products = products;
        this.endereco = endereco;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
