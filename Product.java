/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meisenhelterjaxsonproject3;

/**
 * An abstract class used to create objects such as DVD, CD, and book.
 * @author Jaxson Meisenhelter
 */
public abstract class Product {
    private int ID;
    private double price;
    private String title;
    private String author;
    private int stock;
    private String type;
    /**
     * Creates an object that stores information about an item, such as price of them item how many are in stock.
     * @param type What type of product the item is.
     * @param ID The ID number of the product.
     * @param price The cost of the item.
     * @param title The item's title.
     * @param author The author of the product.
     * @param stock How many items are in stock.
     */
    public Product(String type, int ID, double price, String title, String author, int stock) {
        this.ID = ID;
        this.price = price;
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.type = type;
    }
    
    /**
     * Returns the ID of the product.
     * @return The ID number of the product.
     */
    public int getID() {
        return ID;
    }
    
    /**
     * Returns the price of the product.
     * @return The cost of the item.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Returns the title of the product.
     * @return The item's title.
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Returns the author of the product.
     * @return The author of the product.
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Returns the stock of the product.
     * @return How many items are in stock.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Returns ID number of the product.
     * @param ID The ID number of the product.
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
    /**
     * Sets the price of the product object.
     * @param price The cost of the item.
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * Sets the title of the product object.
     * @param title The item's title.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Changes the author of the product object.
     * @param author The author of the product.
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    
    /**
     * Sets the stock of the product object.
     * @param stock The number if item's in stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    /**
     * Modifies the number of stock by the number passed in.
     * @param num amount by which the stock is changed.
     */
    public void modifyStock(int num){
        this.stock += num;
    }
    /**
     * The products type (book, DVD, CD)
     * @return What type of product the item is.
     */
    public String getType() {
        return type;
    }
}
