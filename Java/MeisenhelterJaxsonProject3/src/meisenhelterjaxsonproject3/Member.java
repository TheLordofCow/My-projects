/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meisenhelterjaxsonproject3;

/**
 * Creates a class that holds information about a member of a store object.
 * @author Jaxson Meisenhelter
 */
public class Member {  
    private float spent = 0;  
    private String name;
    /**
     * Creates a member object that store information about a member.
     * @param name Name of the member.
     * @param spent Amount the member has spent.
     */
    public Member(String name, float spent) {
        this.spent = spent;
        this.name = name;
    }
    
    /**
     * Returns the total amount a member has spent.
     * @return Amount the member has spent.
     */
    public float getSpent() {
        return spent;
    }    
    
    /**
     * Returns the name of the member (NOT the name of the member object)
     * @return Name of the member.
     */
    public String getName() {
        return name;
    }    
    
    /**
     * Sets the total amount a member has spent.
     * @param spent Amount the member has spent.
     */
    public void setSpent(float spent) {
        this.spent = spent;
    }
    
    /**
     * Sets the name of the member (NOT the name of the member object)
     * @param name Name of the member.
     */
    public void setName(String name) {
        this.name = name;
    }
    

    @Override
    public String toString() {
        return "\n name: " + name + ", spent: " + spent;
    }
    /**
     * Increases the total amount a member has spent.
     * @param spent Amount the member has spent.
     */
    public void increaseSpent(float spent){
        this.spent += spent;
    }
    
}
