package DataStructures;


import Exceptions.EmptyCollectionException;
import ADTs.StackADT;

/**
 * Linked list implementation of Stacks. 
 * 
 * @author ITSC 2214
 * @version 1.0
 * @param <T> 
 */
public class LinkedStack<T> implements StackADT<T> {
    /* top: the top of the stack */
    private SinglyLinkedNode<T> top;
    
    /* size: the number of elements in the stack */
    private int size;
    
    /**
     * Constructor
     */
    public LinkedStack() {
        //TODO Instantiate the linked list-based data 
        //collection
        top = null;
        size = 0;

    }
    
    /**
     * Insert an element on the top of the stack
     * @param target input element
     */
    @Override
    public void push(T target) {
        //TODO Add targer to the top of the stack 
        //(represented by the top reference node)
      
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode(target);
        
        if(top == null){
            top = newNode;
            size = 1;
        }
        else{
            newNode.setNext(top);
            top = newNode;
            size++;
        }


    }

    /**
     * Remove out of the top of the stack
     * @return the removed element
     * @throws EmptyCollectionException 
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(
                    "Pop off empty stack");
        }        
        //TODO Remove and return the top item on the stack
        //Corresponding to retrieve the top node and reset 
        //the top reference to the reference of its next node
        SinglyLinkedNode<T> oldTop = top;
        top = top.getNext();
        size--;
        oldTop.setNext(null);
        return oldTop.getElement();
    }
    
    /**
     * Retrieve the element on the top of the stack
     * @return the element on the top of the stack
     * @throws EmptyCollectionException 
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(
                    "Peep on the top of empty stack");
        }

        //TODO Return the top item on this stack, but do 
        //not modify the stack.
        //Corresponding to return the element in the node 
        //referred by the reference top
        return top.getElement();

    }
    
     /**
     * Examine whether the stack is empty
     * @return true: if the stack is empty
     *         false: if the stack is not empty
     */
    @Override
    public boolean isEmpty() {
        //TODO Evaluate whether the stack is empty
        if (size == 0) {
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
        //TODO return the size of the stack 
        return size;
    }
}

