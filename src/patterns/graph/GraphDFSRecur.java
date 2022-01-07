package patterns.graph;

//Time complexity: O(V+E)
//Space complexity: O(V)
//https://hellokoding.com/depth-first-search-algorithm-on-graph/
public class GraphDFSRecur {

    static void traversal(GraphUndirectedByAdjList g) {
        boolean visited[] = new boolean[g.getV()];

        for (int i = 0; i < g.getV(); i++) {
            if (!visited[i])
                dfs(g, i, visited);
        }
    }

    //v is vertex index and not the value but happens to be same while printing
    static void dfs(GraphUndirectedByAdjList g, int v, boolean[] visited) {
        visited[v] = true;
        System.out.printf("%d ", v);

        //get vertex value by index v
        for(int w : g.getAdj().get(v)) {
            if(!visited[w])
                dfs(g, w, visited);
        }
    }


    public static void main(String[] args) {
        GraphUndirectedByAdjList g = new GraphUndirectedByAdjList(5);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        traversal(g);
    }
}