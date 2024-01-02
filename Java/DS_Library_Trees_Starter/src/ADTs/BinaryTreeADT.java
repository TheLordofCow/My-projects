package ADTs;

import DataStructures.BTNode;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;


/**
 * An interface for a Binary Tree
 * Specific binary tree implementations will implement this interface
 * This interface leaves out iterators
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2016
 * @author clatulip
 * @param <T> 
 * @version 1.0
 */
public interface BinaryTreeADT<T extends Comparable<T>>
        extends TreeADT<T> {
    
    /**
     * Returns a reference to the element, if it is found in this binary tree.
     * Throws an exception if element is not found
     * 
     * @param targetElement the element being sought in the tree
     * @return a reference to the specified element
     */
    public BTNode<T> find(T targetElement) throws ElementNotFoundException;
}
