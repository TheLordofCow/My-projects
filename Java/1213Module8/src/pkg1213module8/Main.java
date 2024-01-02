/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1213module8;
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

        //System.out.println(mario.display());
        
        //mario.dropCourse("ur mom");
        //System.out.println(mario.display());
        
        Professor Josh = new Professor("Walmart", 6900, "Josh", "Smith", 6969);
        
        Josh.addAdvisee(mario);
           
        contactList.add(Josh);
        
        for(Person person : contactList){
            person.display();
        }
        /*
        for(Person person : contactList){
            if(matchId(person, 6969) == true){
                person.display();
            }           
        }
        */
        Student s1 = new Student("Steve", "Rodgers", 420, "Shield fighting", 4.7, 20);
        /*
        Person p4 = new Person();
        if(p4 instanceof Student){
            System.out.println(((Student)p4).getGPA());
        }*/
        
        Professor Castro = new Professor("CS", 0, "Castro", "Martini", 420);
        contactList.add(Castro);
        
        for(Person person : contactList){
            if(matchId(person, 6969) == true){
                person.display();
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
        
        System.out.println(s1.compareTo(mario));
        
        Student may = new Student("May", "Jully", 54, "walstreet", 3.5, 2);
        
        ArrayList<Student> students = new ArrayList();
        students.add(s1);
        students.add(mario);
        students.add(may);
        
        Collections.sort(students);
        
        for(Student s : students){
            System.out.println(s.getGPA());
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
