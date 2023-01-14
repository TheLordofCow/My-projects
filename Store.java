/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meisenhelterjaxsonproject3;

import java.io.*;
import java.util.*;

/**
 * Creates a class that holds information about a store, such as inventory amount, cost, and the store name as well as an array list of members (used with Member class).
 * @author Jaxson Meisenhelter
 */
public class Store {
    private double revenue = 0.0;
    private String storeName;
    private double premiumPrice = 19.99;
    private ArrayList<Member> memberlist = new ArrayList<>();
    private ArrayList<Product> productlist = new ArrayList<>();
    
    /**
    * Default store parameters.
     * @throws java.io.FileNotFoundException
    */
    public Store() throws FileNotFoundException {       
        storeName = "Johns";
        
        memberlist.
        memberlist.add(new PremiumMember("Tails", 60, true, false));
        memberlist.add(new PremiumMember("Knuckles", 40, false, true));
        
        loadInv();
    }
    /**
     * Loads a .csv or appropriate .txt file and adds the item types into productlist, assigning them to objects based on type.
     * @throws FileNotFoundException 
     */
    public void loadInv() throws FileNotFoundException{
    try{
        File f = new File("ProductInventory.csv");             
        Scanner scan = new Scanner(f);
        scan.useDelimiter(",|\\n");
        char charTemp = 'a';
        String invTemp;
        for(int i = 0; i < 6; i++){
            scan.next();    //first 6 elements have no use other than when manually looking at the file
            //System.out.println(scan.next());
        }
        for(int i = 0; i < f.length(); i++){                               
            try{
                invTemp = scan.next();
                //System.out.println(invTemp);
                charTemp = invTemp.charAt(0);   
                /*despite invTemp appearing to be a normal word, there are invisible characters that prevent using 
                "book".equals(invTemp) as it will always return false, so a char of the first character is nessecary*/

                if(charTemp == ('b')){
                    productlist.add(new Book("book", Integer.parseInt(scan.next()), scan.next(), scan.next(), Integer.parseInt(scan.next()), Double.parseDouble(scan.next())));                                 
                }     
                else if(charTemp == ('d')){
                    productlist.add(new DVD("DVD", Integer.parseInt(scan.next()), scan.next(), scan.next(), Integer.parseInt(scan.next()), Double.parseDouble(scan.next())));
                }
                else if(charTemp == ('c')){
                    productlist.add(new CD("CD", Integer.parseInt(scan.next()), scan.next(), scan.next(), Integer.parseInt(scan.next()), Double.parseDouble(scan.next())));
                }
                else{
                    System.out.println("An error has occurred! Please check if the .csv file entered is set up properly.");
                }
            }
            catch(StringIndexOutOfBoundsException | NoSuchElementException e){
                    //ends the for loop because it is diffuct to find the number of elements before running though all of them.
            }
        }
    }
    catch(Exception e){
        System.out.println("Incorrect inventory file used. Please add the correct file.");
        System.exit(0);
    }
    }
    /**
     * Adds a member to the Member array list.
     * @param name Name of the member.
     * @param spent Amount the member has spent.
     */
    public void addMember(String name, float spent) {
        memberlist.add(new Member(name, spent));
    }
    /**
     * Adds a Premium Member object the the productlist Array list
     * @param name Name of the member.
     * @param spent Amount the member has spent.
     * @param card Whether or not a premium member wishes to pay by card.
     * @param premiumDue Whether or not a premium member has to pay the premium member fee.
     */
     public void addPremMember(String name, float spent, boolean card, boolean premiumDue) {
        memberlist.add(new PremiumMember(name, spent, card, premiumDue));
    }
    
    /**
     * Returns the name of the store.
     * @return The name of the store.
     */
    public String getStoreName() {
        return storeName;
    }

    public double getRevenue() {
        return revenue;
    }
    
    /**
     * Returns the monthly premium cost.
     * @return Stores whether or not a premium member needs to pay their monthly fee. Regular members are always false.
     */
    public double getPremiumPrice() {
        return premiumPrice;
    }
    
    /**
     * Sets the name of the store (does NOT change store object name).
     * @param storeName The name of the store.
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return storeName + ", storeName: " + storeName + ", premiumPrice: " + premiumPrice + ", memberlist: " + memberlist;
    }
    /**
     * Finds the index location of a Member object in memberlist using the name of the member.
     * @param name The name of the member.
     * @return The index location of the member. Returns -1 if there is no index location from the name given.
     */
    public int findName(String name){
        for(int i = 0; i < memberlist.size(); i++){ 
            if(memberlist.get(i).getName().equals(name)){
                return i;
            }     
        }
        
        return -1;
    }
    /**
     * Returns whether or not a member is a premium member.
     * @param name The name of the member.
     * @return Returns true if the member is a premium member, returns false if name is invalid or if the member is a regular member.
     */
    public Boolean isPremium(String name){
      for(int i = 0; i < memberlist.size(); i++){
            if(memberlist.get(i).getName().equals(name)){
                if(memberlist.get(i) instanceof PremiumMember){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
      
        return false;
    }
    /**
     * Returns whether or not the passcode entered is correct.
     * @param num The number to be compared to the correct passcode.
     * @return Returns true if num is the same as the correct passcode, returns false for everything else.
     */
    public boolean passCodeCheck(int num){
        if(num == 42069){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Removes stock from the product object and increases the total revenue.
     * @param title the title of the product.
     * @return Returns the cost of buying the product. Returns 0 if there are none of that product in stock.
     */
    public void buyItem(String title){
        int ID = this.getID(title);
        if(productlist.get(ID).getStock() < 0){
            System.out.println("I'm sorry, but we are sold out of those books. Please enter another title you would like to buy");
            return;
        }
        else{
        productlist.get(ID).modifyStock(-1);
        }
        revenue += productlist.get(ID).getPrice();
    }
    
    public double buyItem(int index){
        if(productlist.get(index).getStock() < 0){
            System.out.println("I'm sorry, but we are sold out of those books. Please enter another title you would like to buy");
            return 0;
        }
        else{
        productlist.get(index).modifyStock(-1);
        }
        revenue += productlist.get(index).getPrice();
        return productlist.get(index).getPrice();
    }
    
    /**
     * Increases the amount a member has spent at the index provided in the memberlist array list.
     * @param memNum The index location of the member in the memberlist array list.
     * @param spent Amount to be added to a member current amount spent.
     */
    public void addSpent(int memNum, float spent){
        this.memberlist.get(memNum).increaseSpent(spent);
    }
    /**
     * Changes whether or not a premium member needs to pay their monthly fee at the index location provided in the memberlist array list.
     * @param memNum The index location of the member in the memberlist array list.
     * @param due The boolean value premiumDue is changed to.
     */
    public void changePremiumDue(int memNum, boolean due){
        if(this.memberlist.get(memNum) instanceof PremiumMember){
            ((PremiumMember) this.memberlist.get(memNum)).setPremiumDue(due);
        }
    }
    /**
     * Sets a premium member payment method to true at the index provided in the memberlist array list.
     * @param memNum The index location of the member in the memberlist array list.
     */
    public void addCard(int memNum){
        if(this.memberlist.get(memNum) instanceof PremiumMember){
            ((PremiumMember) this.memberlist.get(memNum)).setCard(true);
        }
    }
    /**
     * Returns the productlist Arraylist.
     * @return A list of product objects.
     */
    public ArrayList getProductlist(){
        return productlist;
    }
    /**
     * Returns the product ID of the object in productlist using the title of the book/CD/DVD.
     * @param title Name of the product passed in.
     * @return 
     */
    public int getID(String title){
        for(int i = 0; i < productlist.size(); i++){
            if(title.equals(productlist.get(i).getTitle())){
                return i;
            }
        }
        return -1;
    }
    /**
     * Creates a PremiumMember object from existing information stored in a Member object and removes the Member object from the memberlist, note: this will change the index location of members with a larger index location then the one entered.
     * @param memNum The index location of a member in memberlist.
     * @param card Stores whether or not a premium member needs to pay their monthly fee.
     */
    public void addPremium(int memNum, boolean card){
        memberlist.add(new PremiumMember(memberlist.get(memNum).getName(), memberlist.get(memNum).getSpent() + (float) premiumPrice, card, false));
        memberlist.remove(memNum);
    }
    
    /**
     * Displays the inventory provided by the inventory .csv file.
     */
    public void displayInv(){
        for(int i = 0; i < productlist.size(); i++){
            System.out.println("title: " + productlist.get(i).getTitle() + ",    type: " + productlist.get(i).getType() + ",    Author: " +  productlist.get(i).getAuthor() + ",    Price: $" + productlist.get(i).getPrice());
        }
    }
    
    /**
     * Creates a new Inventory .csv list that shows what items have been removed or added to the inventory.
     * @throws FileNotFoundException 
     */
    public void endLog() throws FileNotFoundException{
        FileOutputStream fi = new FileOutputStream("newInventory.csv");
        PrintWriter p = new PrintWriter(fi);
        File file = new File("ProductInventory.csv");
        Scanner scan = new Scanner(file);
        scan.useDelimiter(",|\\n");
        int j = 0;
        
        try{
            String[] str1 = new String[]{scan.next() + ",",scan.next() + ",",scan.next() + ",",scan.next() + ",",scan.next() + ",",scan.next()};
            for(int i = 0; i < 6; i++){
                    p.print(str1[i]);
                    p.flush();
            }
            
            while(scan.hasNext()){
                String a = scan.next();
                String b = scan.next();
                String c = scan.next();
                String d = scan.next();
                String e = scan.next();
                String f = scan.next();
                
                String[] str2 = new String[]{a + ",",b + ",",c + ",",d + ",",productlist.get(j).getStock() + ",",f};
                
                for(int i = 0; i < 6; i++){
                    p.flush();
                    p.print(str2[i]);
                    p.flush();
                }
                j++;
            }
            p.close();
        }
        catch(NoSuchElementException e){
            System.out.println("error!");
        }
    }
}
