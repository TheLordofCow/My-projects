package DataStructures;


import Exceptions.EmptyCollectionException;
import ADTs.StackADT;
import java.util.Arrays;

/**
 * An array-based StackADT.
 * ArrayCircularQueue which implement QueueADT
 * Use an array as the stack container, and use the
 * variable size to represent the total number of elements in the queue. 
 * In the array, new data element will always be stored in the end of queue, 
 * which is represented in the index of (front + size) % array length.
 * 
 * @author ITSC 2214
 * @version 1.0
 * @param <E> 
 */
public class ArrayStack<E> implements StackADT<E> {
    /** Default capacity in this QueueADT. */
    private final static int DEFAULT_CAPACITY = 10;
    
    /** Array of items in this StackADT. */
    private E[] data;

    /** Number of items currently in this StackADT. */
    private int top;

    /** The StackADT is initialized to be empty. */
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        //TODO Instantiate the array-based data collection
        // with the default capacity constant, DEFAULT_CAPACITY
        data = (E [])(new Object[DEFAULT_CAPACITY]);
        top = 0;
    }

    /**
     * Insert an element on the top of the stack
     * @param target input element
     */
    @Override
    public void push(E target) {
        if (isFull()) {
            expandCapacity();
        }
        this.data[top] = target;
        top++;
        //TODO Add targer to the top of the stack (data array)
    }

    /** Double the length of data. */
    @SuppressWarnings("unchecked")
    protected void expandCapacity() {
        E[] newData = (E[])(new Object[data.length * 2]); // Warning
        for (int i = 0; i < data.length; i++)
            newData[i] = data[i];

        data = newData;
    }
    
    /**
     * Remove out of the top of the stack
     * @return the removed element
     * @throws EmptyCollectionException 
     */
    @Override
    public E pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        
        E element = data[top-1];
        data[top - 1] = null;
        top--;
        return element;
        //TODO Remove and return the top item on the stack 
        //(data array)
    }
    
    /**
     * Retrieve the element on the top of the stack
     * @return the element on the top of the stack
     * @throws EmptyCollectionException 
     */    
    @Override
    public E peek() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException();
        
        return data[top-1];
        //TODO Retrieve element at the end of the stack 
        //(index of the data array: top -1) 
        //Do not modify the Stack.
    }

     /**
     * Examine whether the stack is empty
     * @return true: if the stack is empty
     *         false: if the stack is not empty
     */
    @Override
    public boolean isEmpty() {
        //TODO Evaluate whether the stack is empty     
        return top == 0 ? true : false;
    }

     /**
     * Examine whether the stack array is full
     * @return Return true if data is full, 
     *         or else false
     */
    protected boolean isFull() {
        //TODO Evaluate whether the queue is full
        if(top == data.length-1){
            return true;
        }
        return false;
    }
    
     /**
     * Retrieve the size
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        //TODO return the size of the stack, identified by 
        //the variable top
        return top;
    }
}

