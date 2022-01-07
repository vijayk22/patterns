package patterns.graph;

import java.util.ArrayDeque;
import java.util.Deque;

//https://hellokoding.com/depth-first-search-algorithm-on-graph/

//See also: for different types of graphs
//https://hellokoding.com/graph-data-structure/

public class GraphDFSItr {
    static void dfsByIterative(GraphUndirectedByAdjList g, int v) {
        boolean[] visited = new boolean[g.getV()];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            v = stack.pop();

            if (!visited[v]) {
                visited[v] = true;
                System.out.printf("%d ", v);

                for(Integer w : g.getAdj().get(v)) {
                    stack.push(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphUndirectedByAdjList g = new GraphUndirectedByAdjList(5);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        dfsByIterative(g, 0);
    }
}
