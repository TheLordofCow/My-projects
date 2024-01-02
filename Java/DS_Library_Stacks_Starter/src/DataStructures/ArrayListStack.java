/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import ADTs.StackADT;
import Exceptions.EmptyCollectionException;
import java.util.ArrayList;

/**
 *
 * @author Qiong
 */
public class ArrayListStack<T> implements StackADT<T> {
    ArrayList<T> stack;
    
    public ArrayListStack(){
        stack  = new ArrayList<T>();
    }
    
    @Override
    public void push(T element) {
        this.stack.add(element);
    }

    @Override
    public T pop() throws EmptyCollectionException {
        return this.stack.remove(this.stack.size() - 1);
    }

    @Override
    public T peek() throws EmptyCollectionException {
        return this.stack.get(this.stack.size()-1);
    }

    @Override
    public boolean isEmpty() {
        return this.stack.size() == 0 ? true : false;
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
