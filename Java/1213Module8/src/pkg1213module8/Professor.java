/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1213module8;
import java.util.*;
/**
 * A subclass of Person that store information about a specific professor.
 * @author Jaxson Meisenhelter
 */
public class Professor extends Person{
    private String department;
    private double salary;
    private ArrayList<Student> advisees = new ArrayList<>();

    /**
     * Stores information about a professors name, ID, department, and salary.
     * @param department The professor's teaching field.
     * @param salary The salary the professor is paid.
     * @param firstName The professor's first name.
     * @param lastName The professor's last name.
     * @param id The ID number of the professor.
     */
    public Professor(String department, double salary, String firstName, String lastName, int id) {
        super(firstName, lastName, id);
        this.department = department;
        this.salary = salary;
    }
    /**
     * Returns the department of the professor.
     * @return The professor's teaching field.
     */
    public String getDepartment() {
        return department;
    }
    /**
     * Returns the salary of the professor.
     * @return The salary the professor is paid.
     */
    public double getSalary() {
        return salary;
    }
    /**
     * Returns an Array list of the students that the professor advises.
     * @return The students the professor advises.
     */
    public ArrayList<Student> getAdvisees() {
        return advisees;
    }
    /**
     * Changes the department of the professor.
     * @param department The professor's teaching field.
     */
    public void setDepartment(String department) {
        this.department = department;
    }
    /**
     * Changes the salary of the professor.
     * @param salary The salary the professor is paid.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    /**
     * Adds a student to the advisees Array list.
     * @param Pupil A specific student from the Student class.
     */
    public void addAdvisee(Student Pupil){
        advisees.add(Pupil);
    }
    /**
     * Removes a student from the advisees Array list.
     * @param ID The student's ID.
     * @return returns true if removing was successful, and false if it fails.
     */
    public boolean removeAdvisee(int ID){
       for(int i = 0; i < advisees.size(); i++){
            if(advisees.get(i).getId() == ID){
                advisees.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void display() {
        
        System.out.println("Professor: " + getFirstName() + " " + getLastName() + "ID: " + getId() + ", department: " + department + ", salary: " + salary + ", advisees:{");
        this.adviseeDisplay();
        System.out.println("}");
    }
    
    private void adviseeDisplay(){
        for(int i = 0; i < advisees.size(); i++){
          advisees.get(i).display();
        }
    }
}
