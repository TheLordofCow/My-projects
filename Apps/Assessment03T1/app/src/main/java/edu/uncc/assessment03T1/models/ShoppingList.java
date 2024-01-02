package edu.uncc.assessment03T1.models;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingList implements Serializable {
    String name;
    ArrayList<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
