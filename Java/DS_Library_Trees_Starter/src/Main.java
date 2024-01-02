
import DataStructures.LinkedBinaryTree;

/**
 * Mentoring tree - build a small mentoring tree and test methods
 * @author ITSC 2214
 * @version 1.0
 */
public class Main {
    /**
     * Default constructor
     */
    public Main() {
        super();
    }
    /**
     * Create a small mentoring tree
     * @return a binary mentoring tree
     */
    public LinkedBinaryTree<String> createMentoringTree() {
        LinkedBinaryTree<String> redey = 
                new LinkedBinaryTree<String>("Redey");
        LinkedBinaryTree<String> young = 
                new LinkedBinaryTree<String>("Young");
        LinkedBinaryTree<String> goodwill = 
                new LinkedBinaryTree<String>("G. Will");
        
        LinkedBinaryTree<String> peterpan = 
                new LinkedBinaryTree<String>("Peter Pan", young, goodwill);
        LinkedBinaryTree<String> hpotter = 
                new LinkedBinaryTree<String>("Harry Potter");

        LinkedBinaryTree<String> bluey = 
                new LinkedBinaryTree<String>("Bluey",
                redey, peterpan);
        LinkedBinaryTree<String> whitley = 
                new LinkedBinaryTree<String>("Whitley",
                null, hpotter);
        LinkedBinaryTree<String> nick = new LinkedBinaryTree<String>("Nick",
                bluey, whitley);
        
        return nick;
    }
   
    /**
     * Entry method
     * @param argv  none
     */
    public static void main(String[] argv) {
        Main app = new Main();

        LinkedBinaryTree<String> tree = app.createMentoringTree();
        System.out.println(tree.toString());
        System.out.println("Size: " + tree.size());
        System.out.println("Contain H. Potter: "
                + tree.contains("H. Potter"));
        System.out.println("#(leaves): "
                + tree.leafCounter());
    }
}
