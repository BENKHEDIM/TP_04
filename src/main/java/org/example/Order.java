package org.example;

public class Order {
    private int id;
    private String produit;
    private int quantite;


    public int getId() {
        return id;
    }

    public Order(int id, String produit, int quantite) {
        this.id = id;
        this.produit = produit;
        this.quantite = quantite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }



}