package DataStructures;

import ADTs.ListADT;
import ADTs.ListADT;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;
import java.util.Arrays;

/**
 *
 * @author ITCS2214
 * @param <T> 
 * @version 1.0
 */
public class CArrayList<T extends Comparable<T>>
        implements ListADT<T> {
    private static final int DEFAULT_SIZE = 5;
    private T [] list;
    private int length;
    
    /**
     * Default constructor with no arguments.
     */
    public CArrayList() { 
        list = (T[]) new Comparable[DEFAULT_SIZE];
        length = 0;
    }
    
    /**
     * Constructor with initial capacity.
     * @param size initial size
     */
    public CArrayList(int size) {
        //TODO 
        list = (T[]) new Comparable[size];
        this.length = 0;
    }
    
    /**
     * Add the given element in the beginning of the list
     * @param element reference to data element to add
     */
    @Override
    public void addFirst(T element) {
        if (element == null) return;
        if (length == list.length) {
            this.expandCapacity();
        }
        for (int i = length - 1; i >= 0; i--)
            list[i + 1] = list[i];
        list[0] = element;
    }

    /**
     * Add the given element in the end of the list
     * @param element reference to data element to add
     */
    @Override
    public void addLast(T element) {
        if (element == null) return;
        if (size() == list.length)
            expandCapacity();
        list[length++] = element;
    }

    /**
     * Add the element after the given existing element
     * @param existing reference to an existing element
     * @param element reference to data element to add
     */
    @Override
    public void addAfter(T existing, T element) 
            throws ElementNotFoundException, 
            EmptyCollectionException {
        //TODO
        if ((existing == null) || (element == null)) return;
        if (! contains(existing)) 
            throw new ElementNotFoundException(existing.toString());
        if (size() == list.length)
            expandCapacity();        
        //find existing
        int i = 0;
        for (i = 0; i < length; i++)
            if (list[i].compareTo(existing) == 0)
                break;
        //shift over later elements
        for (int j = length - 1; j >= i; i--)
            list[j + 1] = list[j];
        //place given element
    }

    /**
     * Remove the element
     * @param element reference to data element to remove
     * @return element  the element removed from the list
     */
    @Override
    public T remove(T element) 
            throws EmptyCollectionException, 
            ElementNotFoundException {
        //TODO 
        if (isEmpty()) throw new EmptyCollectionException();
        int i = 0;
        while ((i < length) && (list[i].compareTo(element) != 0))
            i++;
        
        if (i == length) 
            throw new ElementNotFoundException(element.toString());
        
        for (int j = i + 1; j < length; j++)
            list[j - 1] = list[j];
        list[length - 1] = null;
        length--;
        return list[i];
    }

    /**
     * Remove the first element
     * @return element  the element removed from the list
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException();
        T element = list[0];
        for (int i = 1; i < this.length; i++)
            list[i - 1] = list[i];
        list[size() - 1] = null;
        this.length--;
        return element;
    }

     /**
     * Remove the last element
     * @return element  the element removed from the list
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException();
        T element = list[size() - 1];
        list[size() - 1] = null;
        this.length--;
        return element;
    }

     /**
     * Retrieve the first element
     * @return element  the first element in the list
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException();
        
        return list[0];
    }

     /**
     * Retrieve the last element
     * @return element  the last element in the list
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) 
            throw new EmptyCollectionException();
        return list[size() - 1];
    }

    /**
     * Examine whether the element exists in the list
     * @param element reference to data element to search for
     * @return boolean  true: element is found
     *                  false: element is not found
     */
    @Override
    public boolean contains(T element) 
            throws EmptyCollectionException {
        if (isEmpty()) 
            throw new EmptyCollectionException();
        
        for (int i = 0; i < size(); i++) {
            if (list[i].compareTo(element) == 0) {
                System.out.print("");
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Retrieve the element at the given index
     * @param index an integer in the range of 0 through size()-1
     * @return element the element at the given index
    */
    @Override
    public T get(int index) throws EmptyCollectionException, 
            InvalidArgumentException {
        if (isEmpty()) throw new EmptyCollectionException();
        if (index < 0 || index >= size()) 
            throw new InvalidArgumentException();
        return list[index];
    }

     /**
     * Change the element at the given index by the given reference 
     * @param index an integer in the range of 0 through size()-1
     * @param element replace the existing element at the index 
     *                with the given reference.
    */
    @Override
    public void set(int index, T element) 
            throws EmptyCollectionException, 
            InvalidArgumentException {
        //Todo
        if (isEmpty()) throw new EmptyCollectionException();
        if (element == null || index < 0 || index >= size()) 
            throw new InvalidArgumentException();
        list[index] = element;
    }

    /**
     * Examine whether the list is empty
     * @retrun boolean true: list is empty
     *                 false: list is not empty
    */
    @Override
    public boolean isEmpty() {
        if (length > 0)
            return false;
        else
            return true;
    }

     /**
     * Retrieve the size of the list
     * @retrun int size
    */
    @Override
    public int size() {
        return length;
    }
    
    /**
     * Expands the capacity of the collection.
     */
    private void expandCapacity() {
        list = Arrays.copyOf(list, length * 2);
        /*
        java.util.Arrays.copyOf() method is in java.util.Arrays class. 
        It copies the specified array, truncating or padding with false 
        (if necessary) so the copy has the specified length.
            Syntax:
            copyOf(int[] original, int newLength) 
                original – original array
                newLength – copy of original array
        */
    }
}
