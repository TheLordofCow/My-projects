/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1213module8;
import java.util.*;
import java.lang.*;

/**
 * A subclass of Person that store information about a specific student.
 * @author Jaxson Meisenhelter
 */
public class Student extends Person implements Comparable<Student>{
    private String major;
    private double GPA;
    private double balance;
    private int credits;
    private boolean trasfer;
    private ArrayList<String> enrolledCourses = new ArrayList<String>();

    /**
     * Stores information about a student's name, id, major, GPA, and credits.
     * @param firstName The student's first name.
     * @param lastName The student's last name.
     * @param id The ID number of the student.
     * @param major The student's major.
     * @param GPA The student's grade point average.
     * @param credits The number of credits a student has.
     */
    public Student(String firstName, String lastName, int id, String major, double GPA, int credits) {
        super(firstName, lastName, id);
        this.major = major;
        this.GPA = GPA;
        this.credits = credits;
    }    
    /**
     * Returns the student's major.
     * @return The student's major.
     */
    public String getMajor() {
        return major;
    }
    /**
     * Returns the student's GPA.
     * @return The student's grade point average.
     */
    public double getGPA() {
        return GPA;
    }
    /**
     * Returns how much a student needs to pay for loans.
     * @return the current loan balance of the student.
     */
    public double getBalance() {
        return balance;
    }
    /**
     * Returns the number of credits the student has.
     * @return The number of course credits a student has.
     */
    public int getCredits() {
        return credits;
    }
    /**
     * Returns whether or not a student is a transfer student.
     * @return Returns true if the student is a transfer or false if not.
     */
    public boolean isTrasfer() {
        return trasfer;
    }
    /**
     * Returns an array list of courses that the student is currently enrolled in.
     * @return The course a student is enrolled in.
     */
    public ArrayList<String> getEnrolledCourses() {
        return enrolledCourses;
    }
    /**
     * Changes the major of the student.
     * @param major The student's current major.
     */
    public void setMajor(String major) {
        this.major = major;
    }
    /**
     * Changes the GPA of a student.
     * @param GPA The student's grade point average.
     */
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    /**
     * Changes the loan balance of the student to the specified amount.
     * @param balance the current loan balance of the student.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    /**
     * Changes the total credits the student has.
     * @param credits The number of course credits a student has.
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }
    /**
     * Changes whether or not a student is a transfer student.
     * @param trasfer Returns true if the student is a transfer or false if not.
     */
    public void setTrasfer(boolean trasfer) {
        this.trasfer = trasfer;
    }
    /**
     * Removes an enrolled course from the enrolledCourses array list.
     * @param course The class being removed.
     * @return returns true if removing was successful, and false if it fails.
     */
    public boolean dropCourse(String course){   //fix this later
        for(int i = 0; i < enrolledCourses.size(); i++){
            if(enrolledCourses.get(i).equals(course)){
                enrolledCourses.remove(i);
                return true;
            }
        }
        return false;
    }
    /**
     * Adds a course to the enrolledCourses Array list.
     * @param course The class being added.
     */
    public void addCourse(String course){    //fix this later
        enrolledCourses.add(course);
    }

    @Override
    public void display() {

        System.out.println("Student: " + getFirstName() + " " + getLastName() + "ID: " + getId() + ", major: " + major + ", GPA: " + GPA + ", balance: " + balance + ", credits: " + credits + ", trasfer: " + trasfer + ", enrolledCourses: " + enrolledCourses + '}');
        
    }
    
    @Override
    public int compareTo(Student o) {
        double oGPA = o.GPA;
        double sGPA = this.GPA;
        
        System.out.println("Students GPA: " + sGPA + " and " + oGPA); 
        
        if(oGPA == sGPA){
            return 0;
        }
        else if(sGPA <= oGPA){
            return -1;
        }
        else{
            return 1;
        }
        
        
    }
    
}
