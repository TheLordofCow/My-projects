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
public class Student {
    private int ID;
    private String fName;
    private String lName;
    
    public Student(int id, String firstN, String lastN){
        ID = id;
        fName = firstN;
        lName = lastN;
    }

    public int getID() {
        return ID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setfirstName(String fName) {
        this.fName = fName;
    }

    public void setlastName(String lName) {
        this.lName = lName;
    }
    
    

    @Override
    public String toString() {
        return "Student{" + "ID: " + ID + ", first name: " + fName + ", last name: " + lName + '}';
    }
    
   
}
