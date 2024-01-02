/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7inheritnce;
import java.util.*;

/**
 * 
 * @author Jaxson Meisenhelter
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Person> contactList = new ArrayList<>();
        Student mario = new Student("Mario", "Bowsette" , 69 , "Depresso", 3.6, 0);
        
        mario.addCourse("ur mom");
        contactList.add(mario);
        /*
        //System.out.println(mario.display());
        
        //mario.dropCourse("ur mom");
        //System.out.println(mario.display());
        
        Professor Josh = new Professor("Walmart", 6900, "Josh", "Smith", 6969);
        //System.out.println(Josh.display());
        
        Josh.addAdvisee(mario);
        
        //System.out.println(Josh.display());
        
        
        
        contactList.add(Josh);
        
        Person p = new Person();
        contactList.add(p);
        
        for(Person person : contactList){
            System.out.println(person.display());
        }
        
        for(Person person : contactList){
            if(matchId(person, 6969) == true){
                System.out.println(person.display());
            }           
        }
        
        Person p3 = new Student("Steve", "Rodgers", 420, "Shield fighting", 4.7, 20);
        System.out.println(((Student)p3).getGPA());
        
        Person p4 = new Person();
        if(p4 instanceof Student){
            System.out.println(((Student)p4).getGPA());
        }*/
        
        Professor Castro = new Professor("CS", 0, "Castro", "Martini", 420);
        contactList.add(Castro);
        
        for(Person person : contactList){
            if(matchId(person, 6969) == true){
                System.out.println(person.display());
            }           
        }
        
        for(Person prof: contactList){
            if(prof instanceof Professor){
                matchDept(((Professor)prof), "CS");
            }
        }
        
        for(Person stud: contactList){
            if(stud instanceof Student){
                goodGPA(((Student)stud), 3.5);
            }
        }
    }   
    
    public static boolean matchId(Person per, int id){
        if(per.getId() == id){
            return true;
        }
        return false;
    }    
    
    public static void matchDept(Professor prof, String Dept){    
        if(prof.getDepartment().equals(Dept)){
            System.out.println(prof.getFirstName() + " " + prof.getLastName() + "\n");
        }
    }   
    
    public static void goodGPA(Student stud, double GPA){    
        if(stud.getGPA() >= GPA){
            System.out.println(stud.getFirstName() + " " + stud.getLastName() + "\n");
        }
    }
}
