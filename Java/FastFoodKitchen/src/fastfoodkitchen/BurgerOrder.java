/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodkitchen;

/**
 *
 * @author Jaxson
 */
public class BurgerOrder {
    private int numHamburgers = 0;
    private int numCheeseburgers = 0;
    private int numVeggieburgers = 0;
    private int numSodas = 0;
    private boolean orderToGo = false;
    private int orderNum = 1;
    
   
    public BurgerOrder(int hBurgers, int cBurgers, int vBurgers, int sodas, boolean toGo, int orderNumber){
        numHamburgers = hBurgers;
        numCheeseburgers = cBurgers;
        numVeggieburgers = vBurgers;
        numSodas = sodas;
        orderToGo = toGo;
        orderNum = orderNumber;
    }
    
    public int getHumburgers(){
        return numHamburgers;
    }
    
    public int getCheeseburgers(){
        return numCheeseburgers;
    }
    
    public int getVeggieburgers(){
        return numVeggieburgers;
    }
    
    public int getSodas(){
        return numSodas;
    }
    
    public boolean isOrderToGo(){
        return orderToGo;
    }

    public int getOrderNum() {
        return orderNum;
    }
     
    public void setHamburgers(int hBurgers){
        numHamburgers = hBurgers;
    }
     
    public void setCheeseburgers(int cBurgers){
        numCheeseburgers = cBurgers;
    }
    
    public void setVeggieburgers(int vBurgers){
        numVeggieburgers = vBurgers;
    }
    
    public void setSodas(int sodas){
        numSodas = sodas;
    }

    @Override
    public String toString() {
        return "BurgerOrder{" + "numHamburgers=" + numHamburgers + ", numCheeseburgers=" + numCheeseburgers + ", numVeggieburgers=" + numVeggieburgers + ", numSodas=" + numSodas + ", orderToGo=" + orderToGo + ", orderNum=" + orderNum + '}';
    }
    
    
    
}
