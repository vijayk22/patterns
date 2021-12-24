package patterns.graph;

import java.util.Iterator;
import java.util.LinkedList;
public class GraphDFS {
    private int V;
    private LinkedList<Integer> adj[];

    GraphDFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i< v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    void dfsHelper(int v, boolean visited[])  {
        visited[v] =  true;
        System.out.print(v + " ");

        Iterator<Integer> itr = adj[v].listIterator();
        while(itr.hasNext()) {
            int n = itr.next();
            if(!visited[n])
                dfsHelper(n, visited);
        }
    }
    void dfs() {
        boolean visited[] = new boolean[V];
        //This for loop helps for disconnected graph as well
        for(int i=0; i<V; ++i) {
            if(!visited[i])
                dfsHelper(i, visited);
        }
    }


    public static void main(String args[]) {
        GraphDFS g = new GraphDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal");
        g.dfs();
    }
}
