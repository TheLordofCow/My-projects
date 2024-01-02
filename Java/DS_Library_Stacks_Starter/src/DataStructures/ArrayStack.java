
package DataStructures;

import ADTs.StackADT;
import Exceptions.EmptyCollectionException;
import java.util.Arrays;
/**
 *
 * @author Qiong
 */
public class ArrayStack<T> implements StackADT<T> {
    
    T stack[];
    int top;
    final static int DEFAULT_CAPACITY = 10;
    
    public ArrayStack(){
        stack = (T [])(new Object[DEFAULT_CAPACITY]);
        top = 0;
    }
    
    public ArrayStack(int capacity){
        stack = (T [])(new Object[capacity]);
        top = 0;
    }
    
    @Override
    public void push(T element) {
        if (top == this.stack.length)
            expandCapacity();
        
        this.stack[top] = element;
        top++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        
        T element = stack[top-1];
        stack[top - 1] = null;
        top--;
        return element;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        
        return stack[top-1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0 ? true : false;
    }

    @Override
    public int size() {
       return top;
    }
    
    private void expandCapacity() { 
        this.stack = Arrays.copyOf(this.stack, this.stack.length * 2); 
    }
    
    public static void main(String argv[]){
        StackADT<String> cities = new ArrayStack<String>();
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
