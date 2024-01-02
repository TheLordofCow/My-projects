/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import ADTs.StackADT;
import Exceptions.EmptyCollectionException;

/**
 *
 * @author Qiong
 */
public class LinkedStack<T> implements StackADT<T> {

    int count;
    SinglyLinkedNode<T> top;
    
    public LinkedStack(){
        top = null;
        count = 0;
    }
    
    public LinkedStack(T data){
        top = new SinglyLinkedNode(data);
        count = 1;
    }
    
    @Override
    public void push(T element) {
        // TODO implete the push method
        // The push method will insert a node with holds the given input into the top of the stack
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode(element);
        
        if(top == null){
            top = newNode;
            count = 1;
        }
        else{
            newNode.setNext(top);
            top = newNode;
            count++;
        }
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (this.isEmpty()) 
            throw new EmptyCollectionException();
        
        SinglyLinkedNode<T> node = top;
        top = top.getNext();
        count--;
        node.setNext(null);
        return node.getElement();
    }

    @Override
    public T peek() throws EmptyCollectionException {
        //TODO: Implement this method
        //This should look like pop, except we aren't changing the stack at all. Just returning the element.        
        if (top == null)
            throw new EmptyCollectionException("Peek at empty list");
        
        return top.getElement();
    }

    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        if (top != null) {
            return "LinkedListStack{" + "count=" + count + ", top=" + top.getElement() + '}';
        } else {
            return "LinkedListStack{" + "count=" + count + '}';
        }
    }
    
    public static void main(String argv[]){
        StackADT<String> cities = new LinkedStack<String>();
        try{
            cities.push("Tokyo");
            cities.push("Atlanta");
            cities.pop();
            cities.pop();
            cities.push("Miami");
            cities.pop();
            cities.push("Charlotte");
            System.out.println("Charlotte".equalsIgnoreCase(cities.peek()));
            System.out.println(1 == cities.size());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
