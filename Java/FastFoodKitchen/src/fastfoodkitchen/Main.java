/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastfoodkitchen;

import java.util.Scanner;

/**
 *
 * @author jcwm2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 0;
        /*BurgerOrder order1 = new BurgerOrder(3, 5, 4, 10, false, 1);
        BurgerOrder order2 = new BurgerOrder(0, 0, 3, 3, true, 2);
        BurgerOrder order3 = new BurgerOrder(1, 1, 0, 2, false, 3);
        
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);
        
        order1.setSodas(12);
        
        System.out.println(order1); */
    
        /* FastFoodKitchen kitchen = new FastFoodKitchen();
        Scanner sc = new Scanner(System.in);
        
        while(num != 5){
        // see what the user wants to do
        System.out.println("Please select from the following menu of options, by typing a number:");
        System.out.println("\t 1. Order food");
        System.out.println("\t 2. Cancel last order");
        System.out.println("\t 3. Show number of orders currently pending.");
        System.out.println("\t 4. Canel order using the order number");
        System.out.println("\t 5. Exit");

        num = sc.nextInt();
        switch (num) {
        case 1:
            System.out.println("How many hamburgers do you want?");
            int ham = sc.nextInt();
            System.out.println("How many cheeseburgers do you want?");
            int cheese = sc.nextInt();
            System.out.println("How many veggieburgers do you want?");
            int veggie = sc.nextInt();
            System.out.println("How many sodas do you want?");
            int sodas = sc.nextInt();
            System.out.println("Is your order to go? (Y/N)");
            char letter = sc.next().charAt(0);
            boolean TOGO = false;
            if (letter == 'Y' || letter == 'y') {
                TOGO = true;
            }
            int orderNum = kitchen.addOrder(ham, cheese, veggie, sodas, TOGO);
            System.out.println("Thank-you. Your order number is " + orderNum);
            System.out.println();
            break;
        case 2:   
            boolean ready = kitchen.cancelLastOrder();
            if (ready) {
                System.out.println("Thank you. The last order has been canceled");
            } else {
                System.out.println("Sorry. There are no orders to cancel.");
            }
            System.out.println();
            break;
        case 3:
            System.out.println("There are " + kitchen.getNumOrdersPending() + " pending orders");
            break;
        case 4:
            System.out.println("What is the order number?");
            int orderID = sc.nextInt();
            boolean cancelled = kitchen.cancelOrder(orderID);
            
            if(cancelled == true){
                System.out.println("Your order has been successfully cancelled");
            }
            else{
                System.out.println("Sorry, we can’t find your order number in the system");
            }
            break;
        case 5:
            break;
        default:
            System.out.println("Sorry, but you need to enter a 1, 2, 3 or a 4");
        }
    }*/
        FastFoodKitchen kitchen = new FastFoodKitchen(); 
        kitchen.addOrder(3,5,3,6,false);
        kitchen.addOrder(2,3,1,2,true);
        kitchen.addOrder(2,1,3,1,true);
        kitchen.addOrder(4,3,3,2,true);
        kitchen.addOrder(3,2,2,2,false);
        kitchen.cancelOrder(2);
        kitchen.cancelOrder(4);
        int orderNum = kitchen.findOrderSeq(5);
        orderNum = orderNum +1; 
        System.out.println("Your order number 5 is in position " + orderNum + " in line");
        
        
       kitchen.addOrder(3,2,6,3,false);
       kitchen.addOrder(2,4,1,3,false);
       kitchen.addOrder(3,4,2,4,true);
       kitchen.addOrder(4,6,3,2,false);
       kitchen.cancelOrder(8);
       kitchen.cancelOrder(3);
       orderNum = kitchen.findOrderBin(11);
       orderNum = orderNum +1; 
       System.out.println("Your order number 11 is in position " + orderNum + " in line");
       
       kitchen.selectionSort();
       System.out.println("\nSelection Sort");
       System.out.println(kitchen);
       
       kitchen.addOrder(1,1,0,2,true);
       kitchen.addOrder(5,7,2,3,false);
       kitchen.addOrder(5,4,2,3,false);
       kitchen.addOrder(2,2,2,2,true);
       kitchen.insertionSort();
       System.out.println("\nInsertion Sort");
       System.out.println(kitchen);
    }
}
