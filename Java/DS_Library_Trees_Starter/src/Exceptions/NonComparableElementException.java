
package Exceptions;

/**
 * Exception class for when trying to compare collection elements that
 * haven't implemented Comparable (and don't have a compareTo(..) method)
 * @author clatulip
 * @version 1.0
 */
public class NonComparableElementException extends Exception {

     /**
     * Default constructor
     */
    public NonComparableElementException() {
        super();
    }

    /**
     * Constructor
     * @param collection text message
     */
    public NonComparableElementException(String collection) {
        super("The element passed in to " + collection
                + " does not implement Comparable.");
    }
    
}
