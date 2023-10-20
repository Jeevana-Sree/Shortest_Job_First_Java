package dsproject;
// Binary Search Tree Node
public class Node {
    Process process; // The process stored in the node
    Node left, right; // The left and right child of the node
    // Constructor to initialize the node fields
    public Node(Process process) {
        this.process = process;
        left = right = null;
    }
}