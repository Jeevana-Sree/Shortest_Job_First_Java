package dsproject;
// Binary Search Tree for Priority Queue
public class PriorityQueue {
    Node root; // The root of the BST
    // Constructor to initialize the root as null
    public PriorityQueue() {
        root = null;
    }
    // Insert a process into the Priority Queue based on execution time
    public void insert(Process process) {
        root = insertRec(root, process); // Call the recursive helper method
    }
    // A recursive helper method to insert a process into the BST
    private Node insertRec(Node root, Process process) {
        if (root == null) { // If the tree is empty, create a new node
            root = new Node(process);
            return root;
        }
        // If the execution time of the process is smaller, insert in the left subtree
        if (process.executionTime < root.process.executionTime)
            root.left = insertRec(root.left, process);
            // If the execution time of the process is larger, insert in the right subtree
        else if (process.executionTime > root.process.executionTime)
            root.right = insertRec(root.right, process);

        return root; // Return the updated root
    }
    // Get the process with the shortest execution time
    public Process getShortestJob() {
        Node current = root; // Start from the root
        while (current.left != null) // Traverse to the leftmost node
            current = current.left;
        return current.process; // Return the process with the smallest execution time
    }
    // Delete a process from the Priority Queue
    public void delete(Process process) {
        root = deleteRec(root, process); // Call the recursive helper method
    }
    // A recursive helper method to delete a process from the BST
    private Node deleteRec(Node root, Process process) {
        if (root == null) // If the tree is empty, return null
            return null;
        // If the process's execution time is smaller, it lies in the left subtree
        if (process.executionTime < root.process.executionTime)
            root.left = deleteRec(root.left, process);
            // If the process's execution time is larger, it lies in the right subtree
        else if (process.executionTime > root.process.executionTime)
            root.right = deleteRec(root.right, process);
        else {
            // Process to be deleted is found
            if (root.left == null) // If node has only right child or no child, replace with right child
                return root.right;
            else if (root.right == null) // If node has only left child or no child, replace with left child
                return root.left;
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.process = minValue(root.right); // Copy the data of inorder successor to this node
            // Delete the inorder successor from the right subtree
            root.right = deleteRec(root.right, root.process);
        }
        return root; // Return the updated root
    }
    // Helper function to find the node with the smallest value in a BST
    private Process minValue(Node node) {
        Process minValue = node.process; // Initialize min value as node's data
        while (node.left != null) { // Traverse to the leftmost node
            minValue = node.left.process; // Update min value as left child's data
            node = node.left; // Move to left child
        }
        return minValue; // Return min value
    }
}
