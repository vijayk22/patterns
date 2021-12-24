package patterns.tree;

public class BSTValidation {

    static boolean isBSTRecur(Node root) {
        return isBSTRecur(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    //helper function
    static boolean isBSTRecur(Node node, int minKey, int maxKey) {
        if(node==null)
            return true;
        //check if data is valid range
        if(node.data < minKey || node.data > maxKey)
            return false;
        //pass correct data
        return isBSTRecur(node.left, minKey, node.data)
            && isBSTRecur(node.right, node.data, maxKey);
    }
    //another approach: in order traversal pre node val < root/right node
    public static boolean isBST(Node root, Node prev) {
        if (root == null)
            return true;
        boolean left = isBST(root.left, prev);
        if (root.data <= prev.data)
            return false;
        prev.data = root.data; //prev node becomes root and then right node
        return left && isBST(root.right, prev);
    }

    // Function to determine whether a given binary tree is a BST
    public static boolean isBST(Node node) {
        return isBST(node, new Node(Integer.MIN_VALUE));
    }

    //utility functions for test cases
    static Node insert(Node root, int key) {
        if(root==null)
            return new Node(key);
        if(key < root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }

    static void swap(Node root) {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String args[]) {
        int[] keys={15, 10, 20, 8, 12, 16, 25};
        Node root = null;
        for(int key: keys)
            root=insert(root, key);
        //swap left and right nodes to create invalid tree
        swap(root);
        boolean isBSTRecur = isBSTRecur(root);
        System.out.println("is BST:" + isBSTRecur);
    }
}

