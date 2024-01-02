/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Exceptions.ElementNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ITSC 2214
 * @versio 1.0
 */
public class LinkedBinaryTreeTest {
    
    /**
     * Default constructor
     */
    public LinkedBinaryTreeTest() {
    }

    /**
     * Test the method of leafCounter()
     */
    @Test
    public void testLeafCounter() {
        LinkedBinaryTree<Integer> tree1 = new LinkedBinaryTree<Integer>();
        assertEquals(tree1.leafCounter(), 0);
        
        tree1 = new LinkedBinaryTree<Integer>(3);
        assertEquals(tree1.leafCounter(), 1);
        
        LinkedBinaryTree<Integer> tree2 = new LinkedBinaryTree<Integer>(10);
        
        LinkedBinaryTree<Integer> tree3 = new LinkedBinaryTree<Integer>(
                5, tree1, tree2);
        assertEquals(tree3.leafCounter(), 2);
        
        LinkedBinaryTree<Integer> tree4 = new LinkedBinaryTree<Integer>(
                5, null, tree2);
        assertEquals(tree4.leafCounter(), 1);
    }
    
    /**
     * Examine the function find() which throws an exception
     * @throws Exception 
     */
    @Test(expected=ElementNotFoundException.class)
    public void testFind1() throws Exception {
        LinkedBinaryTree<String> treeA = new LinkedBinaryTree<String>("A");
        LinkedBinaryTree<String> treeC = new LinkedBinaryTree<String>("C");
        LinkedBinaryTree<String> treeG = new LinkedBinaryTree<String>("G");

        LinkedBinaryTree<String> treeB = new LinkedBinaryTree<String>("B",
                treeA, treeC);
        LinkedBinaryTree<String> treeF = new LinkedBinaryTree<String>("F",
                null, treeG);
        LinkedBinaryTree<String> treeD = new LinkedBinaryTree<String>("D",
                treeB, treeF);
        
        treeD.find("X");
    }
    
    /**
     * Examine the function find() 
     */
    @Test
    public void testFind2() {
        LinkedBinaryTree<String> treeA = new LinkedBinaryTree<String>("A");
        LinkedBinaryTree<String> treeC = new LinkedBinaryTree<String>("C");
        LinkedBinaryTree<String> treeG = new LinkedBinaryTree<String>("G");

        LinkedBinaryTree<String> treeB = new LinkedBinaryTree<String>("B",
                treeA, treeC);
        LinkedBinaryTree<String> treeF = new LinkedBinaryTree<String>("F",
                null, treeG);
        LinkedBinaryTree<String> treeD = new LinkedBinaryTree<String>("D",
                treeB, treeF);
        
        try {
            String names[] = {"A", "B", "C", "D", "F", "G"};
            for (String name: names) {
                System.out.println(name);
                BTNode<String> targetNode = treeD.find(name);
                assertTrue(targetNode.getElement().equalsIgnoreCase(name));
                System.out.println(targetNode.toString());
            }
        } 
        catch (Exception ex) {
            assertFalse(true);
        }

    }
    
    /**
     * Examine the function isBST, whether the tree is a 
     * binary search tree
     */
    @Test
    public void testIsBST() {
        LinkedBinaryTree<String> treeA = new LinkedBinaryTree<String>("A");
        LinkedBinaryTree<String> treeC = new LinkedBinaryTree<String>("C");
        LinkedBinaryTree<String> treeG = new LinkedBinaryTree<String>("G");

        LinkedBinaryTree<String> treeB = new LinkedBinaryTree<String>("B",
                treeA, treeC);
        LinkedBinaryTree<String> treeF = new LinkedBinaryTree<String>("F",
                null, treeG);
        LinkedBinaryTree<String> treeD = new LinkedBinaryTree<String>("D",
                treeB, treeF);
        assertTrue(treeD.isBST());
        assertTrue(treeB.isBST());
        assertTrue(treeF.isBST());
        
        LinkedBinaryTree<String> treeQ = new LinkedBinaryTree<String>("D",
                treeF, treeB);
        assertFalse(treeQ.isBST());
    }
}
