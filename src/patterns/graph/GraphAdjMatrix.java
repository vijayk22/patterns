package patterns.graph;

//https://www.programiz.com/dsa/graph-adjacency-matrix
public class GraphAdjMatrix {

    private boolean adjMatrix[][];
    private int v;

    //initialize the matrix
    public GraphAdjMatrix(int v) {
        this.v = v;
         adjMatrix = new boolean[v][v];
    }

    //add edges
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    //remove edges
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    //print the matrix
    public String print() {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<v; i++) {
            sb.append(i + " : ");
            for(boolean j: adjMatrix[i]) {
                sb.append((j ? 1 : 0) + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        GraphAdjMatrix g = new GraphAdjMatrix(4);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);

        System.out.println(g.print());

    }

}

