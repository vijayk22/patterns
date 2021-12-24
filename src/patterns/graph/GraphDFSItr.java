package patterns.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
public class GraphDFSItr {

    static void dfs(int V, LinkedList<Integer>[] adj){
        List<Boolean> visited = new ArrayList<>(V);
        //mark all the vertices as not visited
        for(int i=0; i< V; i++)
            visited.add(false);

        for(int i=0; i< V; i++)
            if(!visited.get(i))
                dfsHelper(i, visited, adj);
    }

    static void dfsHelper(int s, List<Boolean> visited, LinkedList<Integer>[] adj) {
        //stack for DFS
        Stack<Integer> stack = new Stack<>();
        //push the current source node
        stack.push(s);
        while(!stack.empty()){
            //pop the vertex from stack and print it
            s = stack.peek();
            stack.pop();
            //stack may contain same vertex twice
            //so print vertex only if not visited
            if(!visited.get(s)) {
                System.out.print(s + " ");
                visited.set(s, true);
            }
            //get adjacent vertices for the popped vertext 's'
            Iterator<Integer> itr = adj[s].iterator();
            while(itr.hasNext()) {
                int v = itr.next();
                //if adjacent has not been visited, then push it to the stack
                if(!visited.get(v)){
                    stack.push(v);
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(1, 0);
        g.addEdge(2, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 0);

        System.out.println("Following is Depth First Traversal");
        dfs(g.V, g.adj);
    }
}
