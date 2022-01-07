package patterns.graph;

import java.util.ArrayList;
import java.util.List;

//https://hellokoding.com/depth-first-search-algorithm-on-graph/
public class GraphUndirectedByAdjList {
    private int V;
    private List<List<Integer>> adj;

    public GraphUndirectedByAdjList(int V) {
        this.V = V;

        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public Integer getV() {
        return this.V;
    }

    public List<List<Integer>> getAdj() {
        return this.adj;
    }

    public void addEdge(int source, int dest) {
        adj.get(source).add(dest);
        adj.get(dest).add(source);
    }

    public void printadj() {
        for (int i = 0; i < V; i++) {
            System.out.printf("Adjacency list of vertex %d is %s %s", i,
                adj.get(i), System.lineSeparator());
        }
    }

    public static void main(String[] args) {
        GraphUndirectedByAdjList graph = new GraphUndirectedByAdjList(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.printadj();
    }
}
