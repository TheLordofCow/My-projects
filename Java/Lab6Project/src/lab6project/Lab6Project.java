/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6project;
import java.io.*;
import java.util.*;

/**
 *
 * @author jcwm2
 */
public class Lab6Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println(addUserInput());
        //System.out.println(divideUserInput());
        System.out.println(divideFromFile());
    }
    
    public static int addUserInput(){
        int sum = 0;
        boolean tryAgain = true;
        
        while(tryAgain == true){
            try{
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter the first number.");
                sum = scan.nextInt();
                tryAgain = false;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input! Please only enter integers.\n");
            }
        }
        
        tryAgain = true;
        
        while(tryAgain == true){
            try{
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter the second number.");
                sum += scan.nextInt();
                tryAgain = false;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input! Please only enter integers.\n");
            }
        }
        return sum;
    }
    
    public static int divideUserInput(){
        int int1 = -1;
        int int2 = -1;
        boolean tryAgain = true;
        
        while(tryAgain == true){
            try{
                Scanner scan = new Scanner(System.in);
                
                System.out.println("Enter the first number.");
                int1 = scan.nextInt();
                tryAgain = false;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input! Please only enter integers.\n");
            }
        }
        
        tryAgain = true;
        
        while(tryAgain == true){
            try{
                Scanner scan = new Scanner(System.in);
                
                System.out.println("Enter the second number.");
                int2 = scan.nextInt();
                tryAgain = false;
                return int1/int2;
                
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input! Please only enter integers.\n");
            }
            catch(ArithmeticException e){
                System.out.println("Error! You cannot divide by 0.\n");
                tryAgain = true;
            }
        }

        return -1;
    }
    
    public static double divideFromFile(){
        double d1 = -1;
        double d2 = -1;
        boolean tryAgain = true;

        while(tryAgain == true){
            try{
                System.out.println("Please input a file name.");
                Scanner keyboard = new Scanner(System.in);
                File f = new File(keyboard.next());
                Scanner scan = new Scanner(f);
                scan.useDelimiter(",");
                
                d1 = scan.nextDouble();
                d2 = scan.nextDouble();
                tryAgain = false;
                return d1/d2;
            }
            catch(InputMismatchException e){
                System.out.println("The file did not contain valid data.\n");
            }
            catch(ArithmeticException e){
                System.out.println("Error! You cannot divide by 0.\n");
                tryAgain = true;
            }
            catch(FileNotFoundException e){
                System.out.println("Invalid file! please input a correct file");
            }
        }

        return -1;
    }
}
