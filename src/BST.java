import jdk.nashorn.api.tree.ArrayLiteralTree;

import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {

        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));

    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return searchHelper(root, val);
    }
    public boolean searchHelper(BSTNode current, int val)
    {
        if(current == null){
            return false; //base case
        }
        if(current.getVal() == val){
            return true;
        }
        //check > or <
        //recur
        if(current.getVal() > val)
        {
            return searchHelper(current.getLeft(), val);
        }
        return searchHelper(current.getRight(), val);
    }


    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        getInorderHelper(root, list);
        return list;
    }
    public void getInorderHelper(BSTNode current, ArrayList<BSTNode> list)
    {
        if(current == null){
            return;
        }
        getInorderHelper(current.getLeft(), list);
        list.add(current);
        getInorderHelper(current.getRight(), list);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        getPreorderHelper(root, list);
        return list;
    }

    public void getPreorderHelper(BSTNode current, ArrayList<BSTNode> list){
        if(current == null){
            return;
        }
        list.add(current);
        getPreorderHelper(current.getLeft(), list);
        getPreorderHelper(current.getRight(), list);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        getPostorderHelper(root, list);
        return list;
    }
    public void getPostorderHelper(BSTNode current, ArrayList<BSTNode> list)
    {
        if(current == null)
        {
            return;
        }
        getPostorderHelper(current.getLeft(), list);
        getPostorderHelper(current.getRight(), list);
        list.add(current);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        BSTNode current = root;
        while(current != null){
            if(current.getVal() == val){
                return;
            }
            if (current.getVal() < val)
            {
                if(current.getRight() == null){
                    current.setRight(new BSTNode(val));
                    return;
                }
                current = current.getRight();
            } else {
                if(current.getLeft() == null)
                {
                    current.setLeft(new BSTNode(val));
                }
                current = current.getLeft();
            }
        }

    }



    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!

        //call getInorder
        //check if the arraylist is sorted

        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        int v1 = 15;
        int v2 = 22;

        System.out.println("\nSearching for " + v1 + " in the tree");
        System.out.println(tree.search(v1));

        System.out.println("\nSearching for " + v2 + " in the tree");
        System.out.println(tree.search(v2));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        int v3 = 0;
        System.out.println("inserting " + v3);
        tree.insert(v3);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
