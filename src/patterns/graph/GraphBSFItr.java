package patterns.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphBSFItr {
    private int V; //vertices
    private LinkedList<Integer> adj[]; //adj list

    GraphBSFItr(int v) {
        V=v;
        adj = new LinkedList[v];
        for(int i=0; i<v; ++i) {
            adj[i] = new LinkedList();
        }
    }
    //add an edge into the graph
    void addEdge(int v, int e) {
        adj[v].add(e);
    }
    //print BFS traversal from a given source s
    void BSF(int s){
        boolean visited[]=new boolean[V];
        //create queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        //mark current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while(queue.size() != 0) {
           s = queue.poll();
           System.out.print(s + " ");

          //get all adjacent vertices for the dequeued vertex 's'
           Iterator<Integer> itr = adj[s].listIterator();
           while(itr.hasNext()) {
            int n = itr.next();
            //if adjacent has not been visited, them mark it visited
            //and enqueue it.
            if(!visited[n]){
                visited[n]=true;
                queue.add(n);
            }
           }
        }
    }

    public static void main(String args[]) {
        GraphBSFItr g = new GraphBSFItr(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        g.BSF(2);
    }
}
