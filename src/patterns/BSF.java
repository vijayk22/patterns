package patterns;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.journaldev.com/44201/breadth-first-search-depth-first-search-bfs-dfs
class TreeNode {
    TreeNode(int data){
        this.data = data;
        left = right = null;
    }
    int data;
    TreeNode left;
    TreeNode right;
}
class BSF {
    // Iterative
    static List<List<Integer>> printLevelOrderItr(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
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
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        System.out.println("\nLevelorder traversal");
        printLevelOrderItr(root);

    }
}
