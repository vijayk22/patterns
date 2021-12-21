package patterns;

import java.util.Stack;

public class DFS {

    static void preorder(Node node){
        if(node == null)
            return;
        System.out.println(node.data + "->");
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node){
        if(node == null)
            return;
        inorder(node.left);
        System.out.println(node.data + "->");
        inorder(node.right);
    }

    static void preorderIter(Node root) {
        if(root==null)
            return;
        Stack<Node> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.println(curr.data + " ");
            if(curr.right !=null)
                stack.push(curr.right);
            if(curr.left !=null)
                stack.push(curr.left);
        }
    }
    //iterative
    //https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/
    static void inorderItr(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root; //start from root but see below...
        while(!stack.isEmpty() || curr != null) {
            if(curr !=null) {
                //if curr node exists, push it into the stack (defer it)
                //remember : In Order
                stack.push(curr);
                curr=curr.left; //move to its left child (and start with it).
            } else { //once reached to bottom
                curr=stack.pop(); //if curr null, pop from stack
                System.out.println(curr.data + " "); //print current val
                curr = curr.right; //finally, move to right
            }
        }
    }


    static void postorderItr(Node root) {
        if(root==null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        //create another stack to store postorder traversal
        Stack<Integer> out = new Stack<>();
        while(!stack.empty()) {
            Node curr = stack.pop(); //again put root node out/or on sie.
            out.push(curr.data);
            //push the left and right child of popped node into stack.
            if(curr.left !=null)
                stack.push(curr.left);
            if(curr.right != null)
                stack.push(curr.right);

            //print post order traversal
            while(!out.isEmpty()) {
                System.out.println(out.pop() + " ");
            }
        }
    }

    public static void main(String args[]) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        System.out.println("Inorder traversal");
        inorder(root);

        System.out.println("\nInorder Itr traversal");
        //inorderItr(root);

        System.out.println("\nPreorder traversal ");
        preorder(root);

        System.out.println("\nPreorder Itr traversal ");
        preorderIter(root);

        System.out.println("\nPostorder traversal");
       // postorder(root);

    }
}
