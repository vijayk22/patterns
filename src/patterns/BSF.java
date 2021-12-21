package patterns;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.journaldev.com/44201/breadth-first-search-depth-first-search-bfs-dfs
class Node {
    Node(int data){
        this.data = data;
        left = right = null;
    }
    int data;
    Node left;
    Node right;
}
class BSF {
    // Iterative
    static List<List<Integer>> printLevelOrderItr(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(temp.data + " ");

            //add left child to the queue
            if(temp.left != null)
                queue.add(temp.left);
            //add right child to the queue
            if(temp.right != null)
                queue.add(temp.right);
        }
        return null;
    }

    //Recursion version

   //TODO add pre/post/in order from above url
    public static void main(String args[]) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        System.out.println("\nLevelorder traversal");
        printLevelOrderItr(root);

    }
}
