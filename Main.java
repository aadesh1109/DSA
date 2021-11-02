import java.util.*;

// Data structure to store graph edges
class Edge
{
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

// Class to represent a graph object
class Graph
{
    // A List of Lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // add edges to the undirected graph
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}

class Main
{
    // Function to perform DFS Traversal
    public static boolean DFS(Graph graph, int v,
                              boolean[] discovered, int parent)
    {
        // mark current node as discovered
        discovered[v] = true;

        // do for every edge (v -> w)
        for (int w : graph.adjList.get(v))
        {
            // w is not discovered
            if (!discovered[w])
            {
                if (DFS(graph, w, discovered, v))
                    return true;
            }

            // w is discovered and w is not a parent
            else if (w != parent)
            {
                // we found a back-edge (cycle)
                return true;
            }
        }

        // No back-edges found in the graph
        return false;
    }

    // Check if an undirected graph contains cycle or not
    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(2, 3),
                new Edge(3, 4), new Edge(4, 7),
                new Edge(7, 8), new Edge(4, 6),
                new Edge(6, 5), new Edge(5, 9),
                new Edge(6, 10), new Edge(10, 11),
                new Edge(11, 12), new Edge(11, 13)
                // edge (11->12) introduces a cycle in the graph
        );

        // Set number of vertices in the graph
        final int N = 13;

        // create a graph from edges
        Graph graph = new Graph(edges, N);

        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];

        // Do DFS traversal from first vertex
        if (DFS(graph, 1, discovered, -1))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain any cycle");
    }
}