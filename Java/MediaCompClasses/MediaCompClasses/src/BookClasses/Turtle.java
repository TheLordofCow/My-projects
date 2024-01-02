package BookClasses;
import java.util.*;
import java.awt.*;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherits from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Turtle extends SimpleTurtle
{
  ////////////////// constructors ///////////////////////
  
  /** Constructor that takes the x and y and a picture to
   * draw on
   * @param x the starting x position
   * @param y the starting y position
   * @param picture the picture to draw on
   */
  public Turtle (int x, int y, Picture picture) 
  {
    // let the parent constructor handle it
    super(x,y,picture);
  }
  
  /** Constructor that takes the x and y and a model
   * display to draw it on
   * @param x the starting x position
   * @param y the starting y position
   * @param modelDisplayer the thing that displays the model
   */
  public Turtle (int x, int y, 
                 ModelDisplay modelDisplayer) 
  {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
  }
  
  /** Constructor that takes the model display
   * @param modelDisplay the thing that displays the model
   */
  public Turtle (ModelDisplay modelDisplay) 
  {
    // let the parent constructor handle it
    super(modelDisplay);
  }
  
  /**
   * Constructor that takes a picture to draw on
   * @param p the picture to draw on
   */
  public Turtle (Picture p)
  {
    
    super(p);
    
  }  
  
  /////////////////// methods ///////////////////////


  public static void main(String[] args)
  {
    World earth = new World();
    Turtle t1 = new Turtle(earth);
    t1.forward();
}
  
public void drawHexagon(int length) {   
    System.out.println("Hexagon request recieved");  
    if(length <= 0){
          System.out.println("length cannot be negative!");
    }
    else{
    this.forward(length);        
    this.turn(60);        
    this.forward(length);        
    this.turn(60);        
    this.forward(length);        
    this.turn(60);        
    this.forward(length);        
    this.turn(60);        
    this.forward(length);
    this.turn(60);        
    this.forward(length);        
    this.turn(60); 
      
    System.out.println("Creating hexagon");
    System.out.println("Hexagon Complete!");
    }
}

  public void drawT() { 
    this.forward(100); 
    this.turnLeft(); 
    this.penUp(); 
    this.forward(40); 
    this.turn(180); 
    this.penDown(); 
    this.forward(80); 
    this.hide();
      
  }
  
 public int getDistance2() {
     double trig = Math.sqrt(Math.pow(this.getXPos(), 2)+ Math.pow(this.getYPos(),2));
     return (int) trig;
     
 }
 
 public boolean isTurtleClose(Turtle firstTurtle, Turtle otherTurtle, int threshold){
     int xFirst = firstTurtle.getXPos();
     int yFirst = firstTurtle.getYPos();
     boolean close = false;
     int xOther = otherTurtle.getXPos();
     int yOther = otherTurtle.getYPos();
     double dist = Math.sqrt(Math.pow(xFirst - xOther, 2)+Math.pow(yFirst - yOther, 2));
     if(dist <= threshold){
        close = true;
     }
     else if(dist > threshold){
        close = false;
     }
     return close;
 }
 
 public static String helpGetters(){
     String help = ("Common getters: isPenDown(), getPenColor(), getXPos(), getYPos()");
     return help;
 }
 
 public static String helpSetters(){
     String help = ("Common setters: setPenColor(Color.c), setPenDown(boolean b), setHeading(int direction)");
     return help;
 }
 
 public static String helpDrawing(){
     String help = ("forward(int dist), backward(int dist), turnLeft(), turnRight(), turn(int degrees), moveTo(int x, int y)");
     return help;
 }
 
 public static void help(){
     String a = helpGetters();
     String b = helpSetters();
     String c = helpDrawing();
     System.out.println(a);
     System.out.println(b);
     System.out.println(c);
 }
 
 //start of project 1 part B
 public void drawCastleC(){
    //Building the left wall
    this.penDown();
    this.forward(200);
    this.turnRight();
    this.forward(50);
    this.turnRight();
    this.forward(50);
    this.turnLeft();
    this.forward(100);
    //building the spire
    this.turnLeft();
    this.forward(70);
    this.turn(20);
    this.forward(80);
    this.turn(140);
    this.forward(80);
    this.turn(20);
    this.forward(70);
    //building the right wall
    this.turnLeft();
    this.forward(100);
    this.turnLeft();
    this.forward(50);
    this.turnRight();
    this.forward(50);
    this.turnRight();
    this.forward(200);
    //building the floor
    this.turnRight();
    this.forward(353); //pixel perfect return to original position 
    this.turnRight();
    this.penUp();
 }
 
 //start of project 1 part C
 public void drawCastleWindow(Color color, int size){
     size = size*15;
     this.setPenColor(color);
     this.penDown();
     this.forward(size);
     this.turnRight();
     this.forward(size);
     this.turnRight();
     this.forward(size);
     this.turnRight();
     this.forward(size);
     this.turnRight();
     
 }
 
 
} // this } is the end of class Turtle, put all new methods before this
