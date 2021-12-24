package patterns.graph;

import java.util.LinkedList;

class Graph {
    int V;
    LinkedList<Integer>[] adj;

    Graph(int v) {
        this.V = v;
        adj = new LinkedList[V];
        for(int i=0; i<adj.length; i++)
            adj[i] = new LinkedList<Integer>();
    }

    void addEdge(int v , int e) {
        adj[v].add(e);
    }
}