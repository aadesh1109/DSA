import java.util.*;
//for undirected graph dfs traversal(rec) maintain prev node(from which we came on curr node) in stack frame

public class GraphRev {
    public static void main(String[] args) {
        Map<String, ArrayList<Pair>> graph = new HashMap<>();
        addVertex("1",graph);
        addVertex("2",graph);
        addVertex("3",graph);
        addVertex("4",graph);
        addVertex("5",graph);
        addVertex("6",graph);
        addEdge("1","2",graph);
        addEdge("1","3",graph);
        addEdge("2","3",graph);
        addEdge("4","6",graph);
        addEdge("5","6",graph);
        addEdge("5","4",graph);
        addEdge("2","4",graph);
        addEdge("3","5",graph);




    }

    private static void dfs(Map<String, ArrayList<Pair>> directedGraph, String a) {
        Stack<String> stack = new Stack<>();
        Set<String> seen = new HashSet<>();
        stack.add(a);
        while (!stack.isEmpty())
        {
            String s = stack.pop();
            if (!seen.contains(s))
            {
                System.out.println(s);
                seen.add(s);
                for (Pair p : directedGraph.get(s)) {
                    if (!seen.contains(p.vertex))
                        stack.push(p.vertex);
                }
            }
        }
    }

    private static void addEdge(String a, String b, Map<String, ArrayList<Pair>> directedGraph) {
        directedGraph.get(a).add(new Pair(b,0));
        /*directedGraph.get(b).add(new Pair(a,0));*/
    }

    private static void addVertex(String i, Map<String, ArrayList<Pair>> directedGraph) {
        if (!directedGraph.containsKey(i))
            directedGraph.put(i,new ArrayList<>());
        else
            System.out.println("vertex already present!");
    }
}
class Pair{
    String vertex ;
    int weight ;

    public Pair(String vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
