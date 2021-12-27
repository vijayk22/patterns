package patterns.tree;

import java.util.Stack;

public class DFS {

    static void preorder(Node node){
        if(node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node){
        if(node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    static void postorder(Node node){
        if(node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    //Iterative solution
    /*
        - pre and post solutions are similar
        - they both push left and right node on stack
        - they both don't need curr pointer but do above push directly on stack
        - post need an additional stack (out), that means two total stacks.
        - post print after the while loop from out stack
        - pre prints inside while loop right after pop
     */
    static void preorderIter(Node root) {
        if(root==null) return;

        Stack<Node> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");
            if(curr.right !=null) stack.push(curr.right); //stack, so put right first to prcess last
            if(curr.left !=null) stack.push(curr.left);//will be processed before right
        }
    }

    static void postorderItr(Node root) {
        if(root==null)  return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Stack<Integer> out = new Stack<>(); //create another stack to store postorder traversal, store root data only

        while(!stack.empty()) {
            Node curr = stack.pop();//pop node from stack
            out.push(curr.data);//puhs into out stack

            //push the left and right child of popped node into stack.
            if(curr.left !=null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }
        while(!out.isEmpty()) { //print post order traversal from out stack traversal from out stack
            System.out.print(out.pop() + " ");
        }
    }
    /*
        - pre/in/post: defined by what is popped from stack (not by what is pushed to stack).
        -
     */

    //Good explanation: https://stackoverflow.com/questions/49409193/understanding-the-logic-in-iterative-postorder-traversal-implementation-on-a-bin/50611267#50611267
    //iterative
    //https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/
    static void inorderItr(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root; //start from root but don't loose reference during traversal
        while(!stack.isEmpty() || curr != null) {
            if(curr !=null) {
                stack.push(curr); //if curr node exists, push it into the stack (defer it), remember : In Order
                curr=curr.left; //traverse the left side of tree
            } else { //once reached to the left bottom
                curr=stack.pop(); //pop the root now and print it
                System.out.print(curr.data + " ");
                curr = curr.right; //finally, move to right
            }
        }
    }



    public static void main(String args[]) {
//        Node root = new Node(0);
//        root.left = new Node(1);
//        root.right = new Node(2);
//        root.left.left = new Node(3);
//        root.left.right = new Node(4);
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Inorder traversal");
        inorder(root);

        System.out.println("\nInorder Itr traversal");
        inorderItr(root);

        System.out.println("\nPreorder traversal ");
        preorder(root);

        System.out.println("\nPreorder Itr traversal ");
        preorderIter(root);

        System.out.println("\nPostorder traversal");
        postorder(root);

        System.out.println("\nPostorder Itr traversal");
        postorderItr(root);

    }
}
