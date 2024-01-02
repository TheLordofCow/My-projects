/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Exceptions.EmptyCollectionException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ITSC 2214 Q
 */
public class LinkedStackTest {
    
    public LinkedStackTest() {
    }

    /**
     * Test of pop method, of class LinkedStack
     * @throws Exception 
     */
    
    /**
     * Test of pop method, of class LinkedStack.
     */
    @Test
    public void testPop() throws Exception {
        LinkedStack<String> instance = new LinkedStack<>();
        assertTrue(instance.size() == 0);
        assertTrue(instance.isEmpty());
        
        String name1 = new String("Deez");
        instance.push(name1);
        String name2 = new String("Nuts");
        instance.push(name2);
        assertEquals(instance.size(), 2);   
        assertFalse(instance.isEmpty());
        
        try{
            String another = instance.pop();
            assertEquals(instance.size(), 1);
            assertTrue(name2.equals(another));
            assertFalse(instance.peek().equals(name2));
            instance.pop();
            assertTrue(instance.isEmpty());
        } catch (Exception ex){
            assertFalse(true);
        }
    }

    /**
     * Test of push method, of class LinkedStack.
     */
    @Test
    public void testPush() {
        LinkedStack<String> instance = new LinkedStack<>();
        assertTrue(instance.size() == 0);
        assertTrue(instance.isEmpty());
        
        String name1 = "deez";
        instance.push(name1);
        assertTrue(instance.size() == 1);
        
        String name2 = "nuts";
        instance.push(name2);
        assertTrue(instance.size() == 2);
        try{
            assertTrue(name2.equals(instance.peek()));
        } catch (Exception ex) {
            fail("Not expected exception");
        }
        
    }

    /**
     * Test of peek method, of class LinkedStack.
     */
    @Test
    public void testPeek() throws Exception {
        LinkedStack<String> instance = new LinkedStack<>();
        assertTrue(instance.size() == 0);
        assertTrue(instance.isEmpty());
        
        try{
            instance.peek();
            fail("exception expected");
        }                 
        catch (Exception ex) {
            assertTrue(ex instanceof EmptyCollectionException);
        }
        
        String name1 = "deez";
        instance.push(name1);
        
        try{
            String cheese = instance.peek();
            assertTrue(instance.size() == 1);
            //test if cheese is the top of the stack
            assertTrue(cheese.equals(instance.peek()));
        }
        catch (Exception ex) {
            fail("Not expected exception");
        }  
    }

    /**
     * Test of isEmpty method, of class LinkedStack.
     */
    @Test
    public void testIsEmpty() {
        LinkedStack instance = new LinkedStack();
        assertTrue(instance.isEmpty());
        String name = "Ellen";
        instance.push(name);
        assertFalse(instance.isEmpty());
    }

    /**
     * Test of size method, of class LinkedStack.
     */
    @Test
    public void testSize() {
        LinkedStack instance = new LinkedStack();
        assertTrue(instance.size() == 0);
        
        String name = "Ellen";
        instance.push(name);
        assertTrue(instance.size() == 1);
    }

    /**
     * Test of toString method, of class LinkedStack.
     */
    @Test
    public void testToString() {
        LinkedStack instance = new LinkedStack();
        String name = "Ellen";
        instance.push(name);
        String text = "LinkedListStack{count=1, top=" + name + '}';
        System.out.println(instance.toString());
        assertTrue(text.equals(instance.toString()));
    }
}
