package Exceptions;

/**
 * An Invalid Argument Exception class
 * Prints out what argument is invalid
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2016
 * @author clatulip
 * @version 1.0
 */
public class InvalidArgumentException extends Exception {

     /**
     * Default constructor
     */
    public InvalidArgumentException() {
        super("The collection is empty.");
    }
    
     /**
     * Constructor
     * @param collection text message
     */
    public InvalidArgumentException(String collection) {
        super("The " + collection + " is empty.");
    }
    
}
