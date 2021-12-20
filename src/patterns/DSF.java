package patterns;

import java.util.Stack;

public class DSF {

    static void preorder(TreeNode node){
        if(node == null)
            return;
        System.out.println(node.data + "->");
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(TreeNode node){
        if(node == null)
            return;
        inorder(node.left);
        System.out.println(node.data + "->");
        inorder(node.right);
    }

    static void preorderIter(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.println(curr.data + " ");
            if(curr.right !=null)
                stack.push(curr.right);
            if(curr.left !=null)
                stack.push(curr.left);
        }
    }
    //iterative
    //https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/
    static void inorderItr(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root; //start from root but see below...
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


    static void postorderItr(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        //create another stack to store postorder traversal
        Stack<Integer> out = new Stack<>();
        while(!stack.empty()) {
            TreeNode curr = stack.pop(); //again put root node out/or on sie.
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
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

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
