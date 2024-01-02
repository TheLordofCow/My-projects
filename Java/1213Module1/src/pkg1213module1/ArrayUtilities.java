/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1213module1;
import java.awt.*;

/**
 *
 * @author jcwm2
 */
public class ArrayUtilities {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            System.out.println("Welcome to ITSC1213 ArrayUtilities Program!");
        }
        
        int array[] = {-2,-2,-4,-2,-4,-4,-2,-6,-4,-4,-5,-8,-8,-5};
        System.out.println("The sum is: " + sum(array));
        System.out.println("The largest number is: " + Thicc(array));
        System.out.println("The first odd number is: " + am0ngus(array));
    }
    public static int sum(int[] numbers) {
        int total = 0;
        int fattest = 0;
        
        for(int num : numbers){
            total += num;
            
            if(fattest < num){
                fattest = num;
            }
        }
        
        return total;
    }
    public static int Thicc(int[] numbers) {
        int fattest = numbers[0];
        
        for(int num : numbers){
            
            if(fattest < num){
                fattest = num;
            }
        }
        
        return fattest;
    }
    
    public static int am0ngus(int[] numbers) {
        int sus = 0;
        
        for(int i : numbers){
            if(i%2 == 1 || i%2 == -1){
                
                return i;
            }
        }
        return sus;
    }
}
