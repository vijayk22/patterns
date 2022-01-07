package patterns.graph;

import java.util.ArrayDeque;
import java.util.Deque;

//https://hellokoding.com/breadth-first-search-algorithm-on-graph/
public class GraphBSFItr {
    //v is starting vertex not V (# of vertices)
    static void bfsItr(GraphUndirectedByAdjList g, int v) {
        boolean[] visited = new boolean[g.getV()];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(v);

        while (!queue.isEmpty()) {
            v = queue.poll();

            if (!visited[v]) {
                visited[v] = true;
                System.out.printf("%d ", v);

                for (Integer w : g.getAdj().get(v)) {
                    queue.offer(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphUndirectedByAdjList g = new GraphUndirectedByAdjList((5));
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        bfsItr(g, 0);
    }
}