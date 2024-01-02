/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meisenhelterjaxsonproject3;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author Jaxson Meisenhelter
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        String response = "";
        String name = "";
        int num = -1;        
        Store Johns = new Store();
        float premiumPrice = (float) Johns.getPremiumPrice();
        float revenue = 0;
        //test if productlist is working
        /*ArrayList<Product> prodlist = Johns.getProductlist();
        System.out.println(prodlist.size());*/
        
        System.out.println("Hello and welcome to " + Johns.getStoreName() + "! What is the reason for your visit?\n");
        
        while(num != 0){
            num = -1;
            int memNum = -1;
            double Pay = 0;    
            boolean good = false;
            Scanner scan = new Scanner(System.in);
            
            System.out.println("1: Make a purchace.");
            System.out.println("2: Become a new memeber.");
            System.out.println("3: Become a premium memeber.");
            System.out.println("4: Pay your premium member fee.");
            System.out.println("5: View member information (admin only).");
            System.out.println("0: Exit.");
            while (num == -1 || num > 6){
                try{
                    num = scan.nextInt();
                }
                catch(Exception e){
                    System.out.println("Invalid number! Please input a integer from 0-5.");
                    scan.next();
                }
            }
            switch(num){
            case 1:
                              
                PurchaceFrame startGUI = new PurchaceFrame(Johns);
                startGUI.setVisible(true);
                revenue += Johns.getRevenue();
                break;
            case 2:
                
                System.out.println("What is your name?");
                name = scan.next();
                memNum = Johns.findName(name);
            
                if(memNum >= 0){
                    System.out.println("I'm sorry, but it appears someone already is using that name. Our system is case sensitive, so you can add your name without the first letter capitalized most of the time.");
                    break;
                }
                
                System.out.println("Would you like to become a premium member as well? It will cost $19.99 a month. (yes/no)");
                //'good' restarts the while loop below if a yes or no is not entered
                good = false;
                while(good == false){
                    response = scan.next();
                
                    if("Yes".equals(response) || "yes".equals(response)){
                        System.out.println("Would you like to pay using a card? (yes/no)");
                        revenue += premiumPrice;
                        response = scan.next();
                
                        if("Yes".equals(response) || "yes".equals(response)){
                            Johns.addPremMember(name, premiumPrice, true, false);
                            good = true;
                        }
                        else if("No".equals(response) || "no".equals(response)){
                            Johns.addPremMember(name, premiumPrice, false, false);
                            good = true;
                        }
                        else{
                            System.out.println("Invalid response! Please type yes or no.");
                        }
                    }
                    else if("No".equals(response) || "no".equals(response)){
                        Johns.addMember(name, 0);
                        good = true;
                    }
                    else{
                        System.out.println("Invalid response! Please type yes or no.");
                    }
                }
                
                System.out.println("Great! you are now a proud member of " + Johns.getStoreName() + "!");
                break; 
            case 3:         
                
                System.out.println("What is your name?");
                name = scan.next();
                memNum = Johns.findName(name);
            
                if(memNum >= 0){
                    if(Johns.isPremium(name) == true){
                        System.out.println("Sorry! It appears you are already a premium member.");
                        break;
                    }
                    else if(Johns.isPremium(name) == false){
                        System.out.println("The cost of becoming a premium member is $" + premiumPrice + " a month.");
                        revenue += premiumPrice;
                        
                        System.out.println("Would you like to pay using a card? (yes/no)");
                        response = scan.next();
                
                        if("Yes".equals(response) || "yes".equals(response)){
                            Johns.addPremium(memNum, true);
                        }
                        else if("No".equals(response) || "no".equals(response)){
                            Johns.addPremium(memNum, false);
                        }
                        else{
                            System.out.println("Invalid response! Please type yes or no.");
                        }
                    }
                }
                else if(memNum < 0){
                    System.out.println("It appears you are not a member yet. I can set that up right away! The cost of becoming a premium member is $19.99 per month.");
                    System.out.println("Would you like to pay using a card? (yes/no)");
                    revenue += premiumPrice;
                    response = scan.next();
                
                    if("Yes".equals(response) || "yes".equals(response)){
                        Johns.addPremMember(name, premiumPrice, true, false);
                    }
                    else if("No".equals(response) || "no".equals(response)){
                        Johns.addPremMember(name, premiumPrice, false, false);
                    }
                    else{
                        System.out.println("Invalid response! Please type yes or no.");
                    }
                }
                
                System.out.println("congratulations on becoming a premium member of " + Johns.getStoreName() + "!");
                break;
            case 4:
                System.out.println("What is your name?");
                name = scan.next();
                memNum = Johns.findName(name);
                
                if(memNum >= 0 && Johns.isPremium(name) == true){
                    System.out.println("Alright! That will be $" + premiumPrice + ".");
                    Johns.addSpent(memNum, premiumPrice);
                    Johns.changePremiumDue(memNum, false);
                    revenue += premiumPrice;
                }
                else{
                    System.out.println("Sorry, but there is no premium account under that name.");
                }
                break;
            case 5:
                System.out.println("Please enter the admin passcode: ");
                
                try{
                    num = scan.nextInt();               
                }
                catch(Exception e){
                    scan.next();
                }
                
                boolean code = Johns.passCodeCheck(num);
                
                if(code == true){
                    System.out.println(Johns);
                    System.out.println("type 'log' to post end of day log. type anything else to close this tab.");
                    response = scan.next();
                    if(response.equals("log")){
                        Johns.endLog();
                        revenue = (float) Math.round((revenue) * 100) / 100;
                        System.out.println(Johns.getStoreName() + " made $" + revenue + " today.");
                        
                    }
                }
                else{
                    System.out.println("I'm sorry, but this passcode is incorrect.");
                }
                 
                break;
            case 0:
                break;
            }
            
            
            System.out.println();
        }
        
        System.out.println("Thank you for shopping at " + Johns.getStoreName() + "!");
    }
    
}
