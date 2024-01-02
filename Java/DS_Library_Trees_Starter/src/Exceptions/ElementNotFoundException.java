package Exceptions;


/**
 * Exception handler for when an element isn't in a collection
 * @author clatulip (modified by ITSC 2214)
 * @version 1.0
 */
public class ElementNotFoundException extends Exception {
    /**
     * Default constructor
     */
    public ElementNotFoundException() {
        super();
    }
    
    /**
     * Constructor
     * @param el text message
     */
    public ElementNotFoundException(String el) {
        super("The element " + el + "was not found in the collection.");
    }
    
}
