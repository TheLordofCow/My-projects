/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import BookClasses.*;
/**
 *
 * @author ealkawas
 */
public class PCheckpoint3TesterB {
    public static void main(String[] args) {
        Picture pic = new Picture(FileChooser.pickAFile());
                
        //Part B test examples
        
        //Expected Output: Error: Border Width should not be negative -20
        //pic.segment(Color.blue, -20, 48.1);

        //Expected Output:
        //Error: percentage should be between 30% and 90% method will exit without applying the color
        //pic.segment(Color.blue, 20, 98.1);

        //Expected Output:
        //Error: Border Width should be less than image height or width
        //pic.segment(Color.blue, 250, 48.1);

        //Try following method call with this picture file: kid-in-frame.jpg
        pic.segment(Color.blue, 20, 48.1);
        //pic.show();
        
        //Try following method call with this picture file: Animals.jpg
        //pic.segment(Color.green, 90, 83.5);
        pic.show();
    }
}
