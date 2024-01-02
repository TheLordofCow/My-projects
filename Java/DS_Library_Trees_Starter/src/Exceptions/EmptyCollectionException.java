package Exceptions;

/**
 * An Empty Collection Exception class
 * Prints out what type of collection is empty
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2016
 * @author clatulip 
 * @version 1.0
 */
public class EmptyCollectionException extends Exception {

     /**
     * Default constructor
     */
    public EmptyCollectionException() {
        super("The collection is empty.");
    }
    
     /**
     * Constructor
     * @param collection text message
     */
    public EmptyCollectionException(String collection) {
        super("The " + collection + " is empty.");
    }
}
