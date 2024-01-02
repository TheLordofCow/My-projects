/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop;

/**
 *
 * @author jcwm2
 */
public class Workshop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student Bob = new Student(300, "Bob", "Shepard");
        
        System.out.println(Bob);
        
        Movie SoundOfMusic = new Movie("Sound of Music", "20th Century Studios");
        
        System.out.println(SoundOfMusic);
    }
    
}
