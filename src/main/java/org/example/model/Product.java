package org.example.model;

public class Product {
    private int id;
    private String productName;
    private Integer quantidade;

    public Product() {
    }

    public Product(int id, String productName, Integer quantidade) {
        this.id = id;
        this.productName = productName;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
