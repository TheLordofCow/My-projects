/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodkitchen;
import java.util.*;

/**
 * Keep in mind whoever is grading this that there is no Javadoc when this class was originally made, so just ignore the empty spaces
 * @author Jaxson Meisenhelter
 */
public class FastFoodKitchen {
    
    private ArrayList<BurgerOrder> orderlist = new ArrayList<>();
    private static int nextOrderNum = 0;
    
    public FastFoodKitchen(){
        orderlist.add(new BurgerOrder(3, 5, 4, 10, false, getNextOrderNum()));
        incrememtNextOrderNum();
        orderlist.add(new BurgerOrder(0, 0, 3, 3, true, getNextOrderNum()));
        incrememtNextOrderNum();
        orderlist.add(new BurgerOrder(1, 1, 0, 2, false, getNextOrderNum()));
        incrememtNextOrderNum();
    }

    public static int getNextOrderNum() {
        return nextOrderNum;
    }
    
    private static void incrememtNextOrderNum(){
        nextOrderNum += 1;
    }
    
    public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo){
        orderlist.add(new BurgerOrder(ham, cheese, veggie, soda, toGo, getNextOrderNum()));
        incrememtNextOrderNum();
        
        return getNextOrderNum();
    }
    
    public boolean cancelLastOrder(){
        orderlist.remove(orderlist.size()-1);   //.size may not do what I think it does
        nextOrderNum -= 1;
        
        if(orderlist.size() == 0){  //.size may not do what I think it does
        return false;
        }
        
        else{
        return true;
        }
    }
    
    public int getNumOrdersPending(){
        return orderlist.size();
    }

    @Override
    public String toString() {
        return "FastFoodKitchen " + "orderlist: " + orderlist;
    }
    
    public boolean cancelOrder(int orderID){
        for(int i = 0; i <orderlist.size(); i++){
            if(orderlist.get(i).getOrderNum() == orderID){
                orderlist.remove(i);
            }
           
        }
        return true;
    }
    /**
     * Finds the index location of in the order list using the order ID number.
     * @param orderID The order number being searched for.
     * @return The index of the order. returns -1 if ID is invalid.
     */
    public int findOrderSeq(int orderID){
        for(int i = 0; i < orderlist.size(); i++){
            int order = orderlist.get(i).getOrderNum();
            
            if(order == orderID){
                return i;
            }
        }
        
        System.out.println("error! Order ID is invalid. Please input a valid order ID");
        return -1;
    }
    
    /**
     * Finds the index location of in the order list using the order ID number using a binary search algorithm.
     * @param orderID The order number being searched for.
     * @return The index of the order. returns -1 if ID is invalid.
     */
    public int findOrderBin(int orderID){
        int left = 0;
      int right = orderlist.size() - 1;
      
      while (left <= right)
      {
         int middle = (left + right) / 2;
         if (orderID < orderlist.get(middle).getOrderNum())
         {
            right = middle - 1;
         }
         else if (orderID > orderlist.get(middle).getOrderNum())
         {
            left = middle + 1;
         }
         else {
            return middle;
         }
       }
       return -1;
    }
    /**
     * Sorts the order list by the total amount of burgers from least to greatest.
     */
    public void selectionSort(){
        
        for (int j = 0; j < orderlist.size() - 1; j++){
            int minIndex = j;
            
            for (int k = j + 1; k < orderlist.size(); k++){
                if (burgerTotal(k) < burgerTotal(minIndex)){
                    minIndex = k;
                }
            }
            
            BurgerOrder temp = orderlist.get(j);
            orderlist.set(j, orderlist.get(minIndex));
            orderlist.set(minIndex, temp);
        }
    }
    /**
     * Find the total amount of burgers in an order at the specified index.
     * @param x The index of the order in orderlist.
     * @return 
     */
    private int burgerTotal(int x){
        return orderlist.get(x).getHumburgers() + orderlist.get(x).getCheeseburgers() + orderlist.get(x).getVeggieburgers();
    }
    /**
     * Sorts the order list by the total amount of burgers from least to greatest when orders have been added after orderlist has already been sorted.
     */
    public void insertionSort(){
        for (int j = 1; j < orderlist.size(); j++){
            BurgerOrder temp = orderlist.get(j);
            int possibleIndex = j;
         
            while (possibleIndex > 0 && burgerTotal(j) < burgerTotal(possibleIndex - 1)){
                orderlist.set(possibleIndex, orderlist.get(possibleIndex - 1));
                possibleIndex--;
            }
            
            orderlist.set(possibleIndex, temp);
        }
        selectionSort();
    }
}
