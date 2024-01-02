/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1213module8;

/**
 * Creates objects that stores information about a person's name and id.
 * @author Jaxson Meisenhelter
 */
abstract public class Person {
    private String firstName;
    private String lastName;
    private int id;
    /**
     * Default Person constructor.
     */
    public Person() {
    }
    /**
     * Stores information about someone name and id.
     * @param firstName The person's first name.
     * @param lastName The person's last name.
     * @param id The ID number of the person.
     */
    public Person(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
    /**
     * Returns what's in the firstName variable in a specific Person object.
     * @return The person's first name.
     */
    public String getFirstName() {
        return firstName;
    }
     /**
     * Returns what's in the lastName variable in a specific Person object.
     * @return The person's last name.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Returns what's stored in the id variable in a specific Person object.
     * @return The ID number of the person.
     */
    public int getId() {
        return id;
    }
    /**
     * Displays what is stored in the variables from the specified Person object.
     */
    public abstract void display();
}
