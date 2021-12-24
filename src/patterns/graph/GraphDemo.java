package patterns.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphDemo {
    public static void main(String[] args) {
        int V=5; //vertex
        List<List<Integer>> adj = new ArrayList<List<Integer>>(V);
        for(int i=0; i<V; i++)
            adj.add(new ArrayList<Integer>());

        //Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);
    }

    static void addEdge(List<List<Integer>> adj, int u, int v) {
         adj.get(u).add(v);
         adj.get(v).add(u);
    }

    static void printGraph(List<List<Integer>> adj) {
        System.out.println("vertext=>edges");
        for(int i=0; i<adj.size(); i++) {
            System.out.print("["+i+"]=>");
            for(int j=0; j<adj.get(i).size(); j++) {
                System.out.print("->"+adj.get(i).get(j));
            }
            System.out.println();
       }
    }


}
