/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ITCS 2214 Q
 */
public class WarTest {
    
    public WarTest() {
    }

    @Test
    public void testWar() 
            throws FileNotFoundException, IOException {
        // Creating a File object that represents the 
        //disk file. 
        PrintStream f1 = new PrintStream(
                new File("warLinkedList.txt")); 
        // Assign o to output stream 
        System.setOut(f1); 
        System.out.println("Welcome to War.");
        WarByLinkedLists game1 = new WarByLinkedLists(false);
        game1.play();
        f1.close();
        
        // Creating a File object that represents the disk file. 
        PrintStream f2 = new PrintStream(new File("warArray.txt")); 
        // Assign o to output stream 
        System.setOut(f2); 
        System.out.println("Welcome to War.");
        WarByArrays game2 = new WarByArrays(false);
        game2.play();
        f2.close();
        
        //compare these two files --> should be the same
        BufferedReader reader1 = new BufferedReader(
                new FileReader("warLinkedList.txt"));
        BufferedReader reader2 = new BufferedReader(
                new FileReader("warLinkedList.txt"));
        
        boolean areEqual = true;
        int lineNum = 1;
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        while (line1 != null || line2 != null) {
            if (line1 == null || line2 == null) {
                    areEqual = false;
                    break;
            }
            else if (! line1.equalsIgnoreCase(line2)) {
                    areEqual = false;
                    break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNum++;
        }
        assertTrue(areEqual);
    }
    
}
