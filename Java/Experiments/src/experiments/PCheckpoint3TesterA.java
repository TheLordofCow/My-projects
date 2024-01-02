/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BookClasses.*;
import java.awt.*;
/**
 *
 * @author ealkawas
 */
public class PCheckpoint3TesterA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Picture pic = new Picture(FileChooser.pickAFile());
        //Part A test examples
        
        //Expected output: Error: inner square width should not be negative -200
        //pic.segment(40,50,-200);
        
        //Expected output: Error! inner square width must be less than half the width and height.
        //pic.segment(40,50,260);
        
        //Expected output: Error! inner square top left should be within the picture limits
        //pic.segment(480,50,200);

        //The following method call will produce the below result with this picture file: Flowers.jpeg
        pic.segment(150,250,200);
        pic.show();
    }
    
}
