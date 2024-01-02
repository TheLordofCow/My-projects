package BookClasses;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
 
  public static void main(String[] args) 
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }
  
  public void decreaseBlue(double percent){
      if(percent <= 0.0){
          System.out.println("percent cannot be 0 or negative!");
      }
      else if(percent > 1){
          System.out.println("percent cannot be above 100%!");
      }
      else{
           Pixel[] pixels = this.getPixels();
           Pixel p = null;
           int value = 0;
  
           for (int i = 0; i < pixels.length; i++){
           p = pixels[i];
           value = p.getBlue();
           p.setBlue((int) (value - value * percent));
           }
      }
      
  }
  
  public void decreaseRed(double percent){
      if(percent <= 0.0){
          System.out.println("percent cannot be 0 or negative!");
      }
      else if(percent > 1){
          System.out.println("percent cannot be above 100%!");
      }
      else{
           Pixel[] pixels = this.getPixels();
           Pixel p = null;
           int value = 0;
  
           for (int i = 0; i < pixels.length; i++){
           p = pixels[i];
           value = p.getRed();
           p.setRed((int) (value - value * percent));
           }
      }
  }
  
  public void decreaseGreen(double percent){
      if(percent <= 0.0){
          System.out.println("percent cannot be 0 or negative!");
      }
      else if(percent > 1){
          System.out.println("percent cannot be above 100%!");
      }
      else{
           Pixel[] pixels = this.getPixels();
           Pixel p = null;
           int value = 0;
  
           for (int i = 0; i < pixels.length; i++){
           p = pixels[i];
           value = p.getGreen();
           p.setGreen((int) (value - value * percent));
           }
      }
      
  }
  
  public void modifyGreen(double percent, double maximum){
      if(percent <= 0.0){
          System.out.println("percent cannot be 0 or negative!");
      }
      else if(percent > 2.0){
          System.out.println("percent cannot be double original value!");
      }
      else if(maximum > 1.0 && maximum <= 0.0){
          System.out.println("percent of image shaded is out of bounds!");
      }
      else{
           Pixel[] pixels = this.getPixels();
           Pixel p = null;
           int value = 0;
  
           for (int i = 0; i < pixels.length*maximum; i++){
           p = pixels[i];
           value = p.getGreen();
           p.setGreen((int) (value * percent));
           }
      } 
  }
  
  public void modifyRed(double percent, double minimum, double maximum){
      if(percent <= 0.0){
          System.out.println("percent cannot be 0 or negative!");
      }
      else if(percent > 2.0){
          System.out.println("percent cannot be double original value!");
      }
      else if(maximum > 1.0 && maximum < 0.0 && minimum > 1.0 && minimum < 0.0){
          System.out.println("percent of image shaded is out of bounds!");
      }
      else if(minimum >= maximum){
          System.out.println("minimum cannot be higher than the maximum!");
      }
      else{
           Pixel[] pixels = this.getPixels();
           Pixel p = null;
           int value = 0;
  
           for (int i = (int) (pixels.length*minimum); i < pixels.length*maximum-1; i++){
           p = pixels[i];
           value = p.getRed();
           p.setRed((int) (value * percent));
           }
      } 
  }
  
  public void fade(){
      Pixel[] pixelArray = this.getPixels();
      Pixel pixel = null;
      for (int i = 0; i < pixelArray.length; i++){
          
          pixel = pixelArray[i];
          
          pixel.setRed((int) (pixel.getRed()*.6));
          pixel.setGreen((int) (pixel.getGreen()*0.6));
          pixel.setBlue((int) (pixel.getBlue()*0.6));
      }
  }
  
  public void copyPixelsFromSource(Picture source){
      
      if(this.getWidth() != source.getWidth() || this.getHeight() != source.getHeight()){
          System.out.println("Source image size differs from this image!");
          return;
      }
      
      Pixel[] targetArray = this.getPixels();
      Pixel[] sourceArray = source.getPixels();
      
      int redValue = 0;
      int greenValue = 0;
      int blueValue = 0;
      
      for(int i = 0; i < sourceArray.length; i++){
          Pixel sourcePixel = sourceArray[i];
          Pixel targetPixel = targetArray[i];
          
          redValue = sourcePixel.getRed();
          greenValue = sourcePixel.getGreen();
          blueValue = sourcePixel.getBlue();
          
          targetPixel.setRed(redValue);
          targetPixel.setGreen(greenValue);
          targetPixel.setBlue(blueValue);
      }
  }
      
  public void averageWithSource(Picture source){
      
      if(this.getWidth() != source.getWidth() || this.getHeight() != source.getHeight()){
          System.out.println("Source image size differs from this image!");
          return;
      }
      
      Pixel[] targetArray = this.getPixels();
      Pixel[] sourceArray = source.getPixels();
      
      int redValue = 0;
      int greenValue = 0;
      int blueValue = 0;
      
      for(int i = 0; i < sourceArray.length; i++){
          Pixel sourcePixel = sourceArray[i];
          Pixel targetPixel = targetArray[i];
          
          redValue = sourcePixel.getRed();
          greenValue = sourcePixel.getGreen();
          blueValue = sourcePixel.getBlue();
          
          targetPixel.setRed((redValue + targetPixel.getRed())/2);
          targetPixel.setGreen((greenValue + targetPixel.getGreen())/2);
          targetPixel.setBlue((blueValue + targetPixel.getBlue())/2);
      }    
  }
  /**
     * Method to lighten the colors in the picture
     */
    public void lighten2() {
        Color color = null;
        Pixel pixel = null;
        // loop through the columns (x direction)
        for (int x = 0; x < getWidth(); x++) {
            // loop through the rows (y direction)
            for (int y = 0; y < getHeight(); y++) {
                // get pixel at the x and y location
                pixel = getPixel(x, y);
                // get the current color
                color = pixel.getColor();
                // get a lighter color
                color = color.brighter();
                // set the pixel color to the lighter color
                pixel.setColor(color);
            }
        }
    }

    /**
     * Method to mirror around a vertical line in the middle of the picture
     * based on the width
     */
    public void mirrorVertical() {
        int width = this.getWidth();
        int mirrorPoint = width / 2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        // loop through all the rows
        for (int y = 0; y < getHeight(); y++) {
            // loop from 0 to the middle (mirror point)
            for (int x = 0; x < mirrorPoint; x++) {
                leftPixel = getPixel(x, y);
                rightPixel = getPixel(width - 1 - x, y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Method to mirror around a horizontal line in the middle based on the
     * height. It copies the top mirrored to the bottom
     */
    public void mirrorHorizontal() {
        int height = this.getHeight();
        int mirrorPoint = height / 2;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        // loop through the columns
        for (int x = 0; x < getWidth(); x++) {
            // loop from 0 to just before the mirror point
            for (int y = 0; y < mirrorPoint; y++) {
                topPixel = getPixel(x, y);
                bottomPixel = getPixel(x, height - 1 - y);
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
     * Method to mirror around a horizontal line in the middle based on the
     * height of the picture. It copies the bottom to the top.
     */
    public void mirrorHorizontalBottomToTop() {
        int height = this.getHeight();
        int mirrorPoint = height / 2;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        // loop through the columns
        for (int x = 0; x < getWidth(); x++) {
            // loop from 1 to just before the mirror point
            for (int y = 0; y < mirrorPoint; y++) {
                topPixel = getPixel(x, y);
                bottomPixel = getPixel(x, height - 1 - y);
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }

    /**
     * Method to mirror part of the temple picture around a vertical line at a
     * mirror point
     */
    public void mirrorTemple() {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        // loop through the rows
        for (int y = 27; y < 97; y++) {
            // loop from 1 to just before the mirror point
            for (int x = 13; x < mirrorPoint; x++) {
                leftPixel = getPixel(x, y);
                rightPixel = getPixel(mirrorPoint + (mirrorPoint - x), y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
    public void quatrefoil(){
        this.mirrorVertical();
        this.mirrorHorizontal();
    }
  
    public void verticalShutters(){
        Pixel black;
        for(int i = 0; i < getWidth(); i++){
            if( (i/10)%2 == 0)  {
                for(int j = 0; j < getHeight(); j++){
                    black = getPixel(i, j);
                    black.setColor(Color.black);
                }
            }
        }
    }
    
    public void horizontalShutters(){
        Pixel pixel;
        for(int i = 0; i < getHeight(); i++){
            if( (i/10)%2 == 0)  {
                for(int j = 0; j < getWidth(); j++){
                    pixel = getPixel(j, i);
                    pixel.setColor(Color.black);
                }
            }
            else{
                for(int j = 0; j < getWidth(); j++){
                    pixel = getPixel(j, i);
                    pixel.setColor(pixel.getColor().brighter());
                }
            }       
        }
    }
    
    
    private boolean isSameSize(Picture source){
        if(source.getWidth() == this.getWidth()){
            if(source.getHeight() == this.getHeight()){
                System.out.println("Sucess!");
                return true;
            }
        }
        
        return false;
        
    }
    
    private void copyPixel(Picture srcPic, int srcX, int srcY, Picture dstPic, int dstX, int dstY){
        Pixel srcPixel = null;
        Pixel dstPixel = null;
        
        srcPixel = srcPic.getPixel(srcX, srcY);
        dstPixel = dstPic.getPixel(dstX, dstY);
        
        dstPixel.setColor(srcPixel.getColor());
    }
    
    public void simpleCopyFromSource(Picture source){
        
        if(!this.isSameSize(source)){
            System.out.println("The source and target images are not the same size!");
            return;
        }
        
        for(int x=0; x < this.getWidth(); x++){
            for(int y = 0; y < this.getHeight(); y++){
                copyPixel(source, x, y, this, x, y);
            }
        }
    }
    
    public void addPic(Picture newPic, int xPos, int yPos) {
        //first check preconditions, newPic has to be smaller than "this" in both dimensions
        if (newPic.getWidth() > this.getWidth() || newPic.getHeight() > this.getHeight()) {
            System.out.println("Error! The passed in picture is larger than this picture");
            return;
        }

        int newWidth = newPic.getWidth();
        int newHeight = newPic.getHeight();

        //iterate through each column and row
        for (int x = 0; x < newWidth; x++) {
            for (int y = 0; y < newHeight; y++) {
                //make sure we aren't trying to copy beyond either
                //the left side of "this" image or the bottom of "this" image
                if (((x + xPos) < getWidth()) && ((y + yPos) < getHeight())) {
                    copyPixel(newPic, x, y, this, x, y);
                }
            }
        }
    }//end of addPic()
    
    public void crop(int xPos, int yPos, int width, int height){
        Pixel pixel;
        for(int x=0; x < this.getWidth(); x++){
            for(int y = 0; y < this.getHeight(); y++){
                
                pixel = getPixel(x, y);
                
                if (x >= xPos && y >= yPos && x <= width+x && y <= height+y){
                    //tells the program to not change the color when conditions are met
                } 
                else{
                    pixel.setColor(Color.white);
                }
            }
        }
    }
    
    public void crop(int xPos, int yPos, int width, int height, Picture newPic){
        Pixel pixel;
        
        if(width != newPic.getWidth() || height != newPic.getHeight()){
            return;
        }
        
        for(int x=0; x < this.getWidth(); x++){
            for(int y = 0; y < this.getHeight(); y++){
                
                pixel = getPixel(x, y);
                
                if(x > xPos && y > yPos && x < width && y < height){
                    if (x + xPos < this.getWidth() && y + yPos < this.getHeight()) {
                        copyPixel(this, x, y, newPic, x, y);
                    } 
                }
            }
        }
    }
    
    public void blackOut(int startX, int startY, int endX, int endY){
        Pixel pixel;
        if(startX > getWidth() || startY > getHeight() || endX > getWidth() || endY > getHeight()){
            System.out.print("Error. blackOut() is placed out of bounds!");
        }
        for(int x=0; x < this.getWidth(); x++){
            for(int y = 0; y < this.getHeight(); y++){
                
                pixel = getPixel(x, y);
                
                if(x >= startX && y >= startY && x <= endX && y <= endY){
                    pixel.setColor(Color.black);
                } 
            }
        }
    }
    
    private void blurPixel(int x, int y, int size) {
        // blurs the passed in (x,y) pixel by averaging the colors of the surrounding
        // pixelssize is how far out to go, so if size is 2, wewill blur based on two
        // columns to the left, two to the right, two rows above and two below, in a square
        Pixel tempPixel = null;
        Pixel pixel = null; 

        int sumR = 0;
        int sumG = 0;
        int sumB = 0;
        int divisor = 0;

        // iterate over the size x size pixels in this area to add up the RGBs
        for (int subx = x-size; subx < x+size + 1; subx++) {
            for (int suby = y-size; suby < y+size + 1; suby++) {
                // check if this pixel is in the range of this image
                if (subx > 0 && subx < this.getWidth()
                        && suby > 0 && suby < this.getHeight()) {
                    tempPixel = this.getPixel(subx, suby);
                    sumR += tempPixel.getRed();
                    sumG += tempPixel.getGreen();
                    sumB += tempPixel.getBlue();
                    // incease divisor
                    divisor += 1;
                }
            }
        }
    // done adding up all the colors from surrounding pixels so
    // get this pixel and then set it's color to the average RGBs
    // making sure to divide by the divisor (num colors added in)
    pixel = this.getPixel(x,y);
    pixel.setRed((int)(sumR/divisor));
    pixel.setGreen((int)(sumG/divisor));
    pixel.setBlue((int)(sumB/divisor));
    }
    
    public void blurArea(int startX, int startY, int endX, int endY, int level){
        
       if (startX < 0 || startX > endX || endX > this.getWidth()
                || startY < 0 || startY > endY || endY > this.getHeight()) {
            System.out.println("Error! The passed in coords are invalid");
            return;
        }
        // Check that level isnt 0 or less
        if (level <= 0) {
            System.out.println("Error! The passed in blur level is too low");
            return;
        }
        for(int x=0; x < this.getWidth(); x++){
            for(int y = 0; y < this.getHeight(); y++){
               
                if(x > startX && y > startY && x < endX && y < endY){
                    this.blurPixel(x,y,level);
                } 
            }
        }
    }
    
    public void colorfulEdgeDetection(double amount, double threshold) {
        
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        double topAverage = 0.0;
        double bottomAverage = 0.0;
        int endY = this.getHeight() - 1;
        /* loop through y values from 0 to height - 1
         * (since compare to below pixel) 
         */
        for (int y = 0; y < endY; y++) {
            // loop through the x values from 0 to width
            for (int x = 0; x < this.getWidth(); x++) {
                // get the top and bottom pixels
                topPixel = this.getPixel(x, y);
                bottomPixel = this.getPixel(x, y + 1);
                // get the color averages for the two pixels
                topAverage = topPixel.getAverage();
                bottomAverage = bottomPixel.getAverage();
                /* check if the absolute value of the difference
                 * is less than the amount 
                 */
                if (Math.abs(topAverage - bottomAverage) < amount && topAverage > threshold) {
                    topPixel.setColor(Color.white);
                // else set the color to black
                } 
            }
        }
        
    }
    
   public void deepFry(double amount, double threshold) {
        
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        double topAverage = 0.0;
        double bottomAverage = 0.0;
        int endY = this.getHeight() - 1;
        /* loop through y values from 0 to height - 1
         * (since compare to below pixel) 
         */
        for (int y = 0; y < endY; y++) {
            // loop through the x values from 0 to width
            for (int x = 0; x < this.getWidth(); x++) {
                // get the top and bottom pixels
                topPixel = this.getPixel(x, y);
                bottomPixel = this.getPixel(x, y + 1);
                // get the color averages for the two pixels
                topAverage = topPixel.getAverage();
                bottomAverage = bottomPixel.getAverage();
                /* check if the absolute value of the difference
                 * is less than the amount 
                 */
                if (Math.abs(topAverage - bottomAverage) < amount && topAverage > threshold) {
                   int color = (int) (Math.random()*4);
                   if(color == 0 || color == 1){
                       topPixel.setColor(Color.red);
                   }
                   else if(color == 2){
                       topPixel.setColor(Color.green);
                   }
                   else if(color == 3){
                       topPixel.setColor(Color.blue);
                   }
                   
                } 
                else{
                    
                }
            }
        }
        
        //this.blurArea(0, 0, this.getWidth(), this.getHeight(), 1);
    }
   
   public void segment(int xPos, int yPos, int sWidth){
       //prevents program for crashing
       if(sWidth <= 0){
           System.out.println("Width must be positive!"); return; 
       }
       if(sWidth > getWidth()/2 || sWidth > getHeight()/2){
           System.out.println("Width is too big!"); return; 
       }
       if(xPos + sWidth > getWidth() || yPos + sWidth > getHeight()){
           System.out.println("XPos or Ypos is out of bounds!"); return; 
       }
       Pixel pixel;
       //cycles though the picture, starting at xPos and yPos and ending at sWidth
       for(int x= xPos; x < xPos + sWidth; x++){ 
            for(int y = yPos; y < yPos + sWidth; y++){
                
                pixel = getPixel(x, y);
                //sets the two colors that have the least value to 0
                if(pixel.getRed() > pixel.getBlue() && pixel.getRed() > pixel.getGreen()){
                    pixel.setBlue(0);
                    pixel.setGreen(0);
                }
                else if(pixel.getBlue() > pixel.getRed() && pixel.getBlue() > pixel.getGreen()){
                    pixel.setRed(0);
                    pixel.setGreen(0);
                }
                else{
                    pixel.setBlue(0);
                    pixel.setRed(0);
                }
            }
        }
    }
  
    public void segment(Color bColor, int sWidth, double percent){
       //prevents program for crashing
       if(sWidth <= 0){
           System.out.println("Width must be positive!"); return; 
       }
       if(sWidth > getWidth()/2 || sWidth > getHeight()/2){
           System.out.println("Width is too big!"); return; 
       }
       if(percent < 30 || percent > 90){
           System.out.println("Error! Percent must be between .3 and .9!"); return; 
       }
       
       Pixel pixel;
       //cycles though every pixel in the picture
       for(int x = 0; x < getWidth(); x++){ 
            for(int y = 0; y < getHeight(); y++){
                pixel = getPixel(x, y);
                //color is only affected at the border
                if(x <= sWidth || y <= sWidth || x >= getWidth()-sWidth || y >= getHeight()-sWidth){ 
                    //modifies the RGB border color by the percentage and color entered
                    pixel.setRed((int)(pixel.getRed() + (bColor.getRed() - pixel.getRed())*percent/100)); 
                    pixel.setBlue((int) (pixel.getBlue() + (bColor.getBlue() - pixel.getBlue())*(int)percent/100));
                    pixel.setGreen((int) (pixel.getGreen() + (bColor.getGreen() - pixel.getGreen())*(int)percent/100));
                }
            }
        }
    }

} // this } is the end of class Picture, put all new methods before this
 