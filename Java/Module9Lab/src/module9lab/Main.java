/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module9lab;
import java.io.*;
import java.util.*;

/**
 *
 * @author jcwm2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BookChapter GameThrones = BookChapterReadWrite.loadBookChapterFromFile("gt1.txt");
        System.out.println(GameThrones.toString());
         
        BookChapter Slaughter = BookChapterReadWrite.loadBookChapterFromFile("s1.txt");
        System.out.println(Slaughter.toString());
        
        BookChapterReadWrite.writeBookChapterToFile(GameThrones,"game1");
        BookChapterReadWrite.writeBookChapterToFile(Slaughter,"slaughter");
        
    }
    
}
