/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author ITSC 2214
 * @param <T> 
 * @version 1.0
 */
public class BTNode<T extends Comparable<T>> {
    
    private T element;
    private BTNode<T> leftChild;
    private BTNode<T> rightChild;


    /** 
     * Creates a node containing element
     * @param elem element to be stored
     */
    public BTNode(T elem) {
        leftChild = null;
        rightChild = null;
        element = elem;
    }
    
    /**
     * Creates a new node, with element and sub-trees
     * @param elem element
     * @param left a LinkedBinaryTree (or null)
     * @param right a LinkedBinaryTree (or null)
     */
    public BTNode(T elem, LinkedBinaryTree<T> left, 
            LinkedBinaryTree<T> right) {
        element = elem;
        if (left == null) {
            leftChild = null;
        } 
        else {
            leftChild = left.root;
        }
        
        if (right == null) {
            rightChild = null;
        } 
        else {
            rightChild = right.root;
        }
    }
    
    /**
     * Change the left child node reference
     * @param leftChild given reference to left child node
     */
    public void setLeftChild(BTNode<T> leftChild) {
        this.leftChild = leftChild;
    }
    
    /**
     * Gets the left sub-tree
     * @return BTNode<T> left sub-tree (could be null)
     */
    public BTNode<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Gets the right sub-tree
     * @return BTNode<T> right sub-tree (could be null)
     */
    public BTNode<T> getRightChild() {
        return rightChild;
    }

    /**
     * Sets the rightChild to point at the passed in tree
     * @param rightChild a BTNode (could be null)
     */
    public void setRightChild(BTNode<T> rightChild) {
        this.rightChild = rightChild;
    }
    
    /**
     * Returns the element stored in this node
     * @return element stored in the node
     */
    public T getElement() {
        return element;
    }
    
    /**
     * Change the element value
     * @param elem input element value
     */
    public void setElement(T elem) {
        element = elem;
    }

    /**
     * TODO 
     * Examine whether this binary tree node is empty
     * @return true : it is a leaf
     *         false: it is not a leaf
     */
    public boolean isLeaf() {
        //TODO
        if(this.getLeftChild() == null && this.getRightChild() == null){
            return true;
        }
        return false;
    }
        
    /**
     * Return the represented string
     * @return string  text
     */
    @Override
    public String toString() {
        if ((this.getLeftChild() != null)
                && (this.getRightChild() != null))
            return "TreeNode{" + "element=" + element
                    + "\n leftChild=" + leftChild.getElement()
                    + "\n rightChild=" + rightChild.getElement()
                    + "}\n";
    
        if (this.getLeftChild() != null)
            return "TreeNode{" + "element=" + element
                    + "\n leftChild=" + leftChild.getElement()
                    + "\n rightChild=null" + "}\n";
        else
            if (this.getRightChild() != null)
                return "TreeNode{" + "element=" + element
                    + "\n leftChild=null" + "\n rightChild="
                    + rightChild.getElement() + "}\n";
            else
                return "LeafNode{" + "element=" + element
                    + "}\n ";
    }
}
