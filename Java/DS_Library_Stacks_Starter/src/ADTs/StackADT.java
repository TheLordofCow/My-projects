package ADTs;

import Exceptions.EmptyCollectionException;


/**
 * An interface for a Stack
 * Specific stack implementations will implement this interface
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2016
 * @author clatulip
 */
public interface StackADT<T> extends CollectionADT {
    
    /**
     * Adds the specified element to the top of the stack
     * @param element element to be pushed onto the stack
     */
    public void push(T element);
    
    /**
     * Removes and returns the element that is on top of the stack
     * @return the element removed from the stack
     * @throws EmptyCollectionException 
     */
    public T pop() throws EmptyCollectionException;
    
    /**
     * Returns (without removing) the element that is on top of the stack
     * @return the element on top of the stack
     * @throws EmptyCollectionException 
     */
    public T peek()throws EmptyCollectionException;
    
}
