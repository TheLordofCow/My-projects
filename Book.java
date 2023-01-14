/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meisenhelterjaxsonproject3;

/**
 *
 * @author jcwm2
 */
public class Book extends Product{
    public Book(String type, int ID, String title, String author, int stock, double price) {
        super(type, ID, price, title, author, stock);
    }
}
