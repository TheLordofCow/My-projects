package DataStructures;

import ADTs.BinaryTreeADT;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * LinkedBinaryTree implements the BinaryTreeADT interface, 
 * but no iterators
 * @author Lewis & Chase (modified by clatulip, ITSC 2214)
 * @param <T> 
 * @version 1.0
 */
public class LinkedBinaryTree<T extends Comparable<T>>
        implements BinaryTreeADT<T> {

    /**
     * The root node of the tree 
    */
    protected BTNode<T> root;
    
    /**
     * The number of nodes in the tree 
    */
    protected int numOfNodes;

    /**
     * default constructor 
    */
    public LinkedBinaryTree() {
        root = null;
        numOfNodes = 0;
    }

    /**
     * Constructor that takes an element
     * @param element 
     */
    public LinkedBinaryTree(T element) {
        root = new BTNode<T>(element);
        numOfNodes = 1;
    }
    
    /**
     * Constructor that takes an element and left 
     * and right trees to be the root
     * @param element the element to be stored at the root
     * @param left the left sub-tree to attach to the root
     * @param right the right sub-tree to attach to the root
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, 
            LinkedBinaryTree<T> right) {
        this(element);
        if (left != null) {
            root.setLeftChild(left.root);
            this.numOfNodes += left.size();
        } 

        if (right != null) {
            root.setRightChild(right.root);
            this.numOfNodes += right.size();
        }
    }
    
    /**
     * Returns the element at the root of this tree
     * @return T the (generic) element at the root
     * @throws EmptyCollectionException 
     */
    @Override
    public T getRootElement() throws EmptyCollectionException {
        if (root != null)
            return (T)(root.getElement());
        else
            return null;
    }
    
    
    /**
     * Returns the root node of this tree
     * @return root node
     */
    private BTNode<T> getRootNode() {
        return root;
    }
   
    /**
     * Determine whether a given element is present in the tree
     * @param targetElement the element to search for
     * @return true if the element is found, false otherwise
     */
    @Override
    public boolean contains(T targetElement) {
        // start searching at the root, by calling private recursive search
        BTNode<T> current = findNode(targetElement, root);
        
        // if, searching from root, we didn't find it, throw exception.
        return (current != null);
    }

    /**
     * Find looks to see if a target element is in the tree, if it is,
     * it returns a reference to that element. If element is not found,
     * an exception is thrown. It is expected that a call to 'contains' has 
     * first verified the presence of the element.
     * @param targetElement element to search for
     * @return Element reference to the element
     * @throws ElementNotFoundException 
     */
    @Override
    public BTNode<T> find(T targetElement) throws ElementNotFoundException {
        // start searching at the root, by calling private recursive search
        BTNode<T> current = findNode(targetElement, root);
        
        // if, searching from root, we didn't find it, throw exception.
        if (current == null)
            throw new ElementNotFoundException("LinkedBinaryTree");
        
        // otherwise, return the element found
        return current;
    }

    /**
     * TODO! 
     * private method that recursively searches through sub-trees 
     * searching for element
     * @param targetElement search target
     * @param next    subtree rooted by next node
     * @return 
     */
    private BTNode<T> findNode(T targetElement, BTNode<T> next) {
        if (next == null)
            return null;
        if (next.getElement().compareTo(targetElement) == 0) 
            return next;
        
        BTNode<T> temp = findNode(targetElement, next.getLeftChild());
        if (temp == null)
            temp = findNode(targetElement, next.getRightChild());
        
        return temp;
    }
    
    /**
     * Gives the depth in the tree of the specified node,
     * if the element is not found, an exception is thrown
     * It is expected that 'contains' has been called first
     * to verify the presence of the node before calling nodeDepth
     * @param targetElement the element we are looking for
     * @return the depth if node is found
     * @throws ElementNotFoundException 
     */
    public int nodeDepth(T targetElement) 
            throws ElementNotFoundException {
        // start searching at the root, by calling private 
        // recursive search
        int depthCount = findNodeDepth(targetElement, root, 0);
        
        // if, searching from root, we didn't find it, throw exception.
        if (depthCount == -1)
            throw new ElementNotFoundException("LinkedBinaryTree");
        
        // otherwise, return the element found
        return depthCount;
        
    }
    
   /**
     * private recursive helper function for calculating node depth
     * @param targetElement element we are looking for
     * @param next sub-tree to search
     * @param depth counter to keep track of levels
     * @return the depth if targetElement occurs in the tree.
     *         or else, -1
     */
    private int findNodeDepth(T targetElement, 
            BTNode<T> next, int depth) {
        int temp = depth;
        if (next == null)
            return -1;
        if (next.getElement().equals(targetElement)) 
            return depth;
        temp  = findNodeDepth(targetElement, 
                next.getLeftChild(), depth + 1);
        
        if (temp == -1)
            temp = findNodeDepth(targetElement, 
                    next.getRightChild(), depth + 1);
        
        return temp;
    }

    /**
     * Returns whether or not the tree is empty
     * @return boolean true if the tree is empty, 
     *      false otherwise
     */
    @Override
    public boolean isEmpty() {
        return (numOfNodes == 0);
    }

    /**
     * Returns the number of nodes in the tree
     * @return the number of nodes in the tree
     */
    @Override
    public int size() {
        return numOfNodes;
    }
    
    /**
     * Count the number of leaf nodes
     * @return the number of leaf nodes
     */
    public int leafCounter() {
        return leafCounter(root);
    }
        
    // TODO 
    /**
     * leafCounter
     * If the parameter node is empty, the tree rooted by the 
     * parameter node is empty, having zero leaf node.
     * If the parameter node has empty left subtree and empty right
     * subtree, the parameter node is the only node in the tree rooted 
     * by the parameter node, and it is the unique leaf node.
     * Or else, the tree or subtree rooted by the parameter node includes
     * more than one node. The number of leaves of such a tree is
     * the addition of the numbers of left subtree and right subtree
     * rooted by the parameter node.
     * Write a recursive method to calculate the number of leaf nodes
     * in a tree rooted by the parameter node.
     * Note: Before writing the code, first analyze the problem
     * and answer the following questions:
     * - What is the recursive property?
     * - What is the base case?
     * - What is the recursive relation?
     * Note: when you design and write your code, please take care of
     * base case first
     * @param node 
     * @return   number of leaf nodes in the tree or subtree rooted by 
     *           given node
     */
    private int leafCounter(BTNode<T> node) {
        int leaves = 0;
        if (node == null) return 0;
        
        if (node.isLeaf()) {
            //this node is a leaf
            System.out.println(node.getElement());
            // TODO 
            return 1;
            
        } 
        else{
            // TODO 
            leaves += this.leafCounter(node.getLeftChild());
            leaves += this.leafCounter(node.getRightChild());
        }
        return leaves;
    }
    
    /**
     * Examine whether it is a binary search tree(BST)
     * @return true: it is a BST
     *         false: it is not a BST
     */
    public boolean isBST() {
        return isBST(this.getRootNode());
    }
    
    /**
     * Examine whether the subtree rooted by the given node
     * is a binary search tree(BST)
     * @param node  the root of a subtree 
     * @return true: it is a BST
     *         false: it is not a BST
     */
    private boolean isBST(BTNode<T> node) {
        if (node == null) 
            return true;
        
        if (node.isLeaf()) 
            return true;

        if ((node.getLeftChild() != null) 
                && (node.getRightChild() != null)) 
            return ((node.getElement().
                    compareTo(node.getLeftChild().getElement()) > 0)
                    && (node.getElement().
                    compareTo(node.getRightChild().getElement()) < 0)
                    && isBST(node.getLeftChild())
                    && isBST(node.getRightChild()));

        if ((node.getLeftChild() != null)) 
            return ((node.getElement().
                    compareTo(node.getLeftChild().getElement()) > 0)
                    && (isBST(node.getLeftChild())));

        if (node.getRightChild() != null) 
            return ((node.getElement().
                    compareTo(node.getRightChild().getElement()) < 0)
                    && isBST(node.getRightChild()));

        return false;
    }
  
    /**
     * Retrieve the represented text of the tree
     * @return a string text
     */
    public String toString() {
        return toString(root);
    }
    
     /**
     * Retrieve the represented text of a tree rooted by the 
     * argument node
     * @param node  the root of a subtree 
     * @return a string text
     */
    public String toString(BTNode<T> node) {
        if (node == null) return "";
        BTNode<T> tmp = node;
        String treeString = tmp.toString();
        if (tmp.getLeftChild() != null) 
            treeString += toString(tmp.getLeftChild());

        if (tmp.getRightChild() != null) 
            treeString += toString(tmp.getRightChild());

        return treeString;
    }
    
    /**
     * In the main function, create a small tree and test methods
     * @param argv 
     */
    public static void main(String [] argv) {

        LinkedBinaryTree<String> treeA = new LinkedBinaryTree<String>("A");
        LinkedBinaryTree<String> treeC = new LinkedBinaryTree<String>("C");
        LinkedBinaryTree<String> treeG = new LinkedBinaryTree<String>("G");

        LinkedBinaryTree<String> treeB = new LinkedBinaryTree<String>("B",
                treeA, treeC);
        LinkedBinaryTree<String> treeF = new LinkedBinaryTree<String>("F",
                null, treeG);
        LinkedBinaryTree<String> treeD = new LinkedBinaryTree<String>("D",
                treeB, treeF);
        
        System.out.println("Leaf nodes: " + treeD.leafCounter());
        System.out.println("Is a binary search tree: "
                + treeD.isBST(treeD.getRootNode()));
    }

}

