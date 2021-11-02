import java.util.*;

public class ArrivalAndDepartureTimeOfNodeInDFS {
    public static void main(String[] args) {
        Map<String, ArrayList<Pair>> graph = new HashMap<>();
        addVertex("1",graph);
        addVertex("2",graph);
        addVertex("3",graph);
        addVertex("4",graph);
        addVertex("5",graph);
        addVertex("6",graph);
        addVertex("7",graph);
        addVertex("8",graph);
        addVertex("9",graph);
        addVertex("10",graph);
        addVertex("11",graph);
        addVertex("12",graph);
        addVertex("13",graph);
        addEdge("1","2",graph);
        addEdge("2","3",graph);
        addEdge("5","9",graph);
        addEdge("4","7",graph);
        addEdge("7","8",graph);
        addEdge("6","10",graph);
        addEdge("10","11",graph);
        addEdge("11","12",graph);
        addEdge("11","13",graph);
        addEdge("3","4",graph);
        addEdge("4","6",graph);
        addEdge("5","6",graph);
        addEdge("13","13",graph);//??self loop
        System.out.println(cycleDetectionInUndirected(graph));



    }

    private static boolean cycleDetectionInUndirected(Map<String, ArrayList<Pair>> graph) { //directed graph
        Set<String> visited = new HashSet<>();
            return cycleDetectionInUndirected("1","-1",graph,visited);
    }

    private static boolean cycleDetectionInUndirected(String s, String prev ,Map<String, ArrayList<Pair>> graph, Set<String> visited) {
        visited.add(s);

        for (int i = 0; i < graph.get(s).size() ; i++) {
            if (!prev.equals(graph.get(s).get(i).vertex))
            {

                if (visited.contains(graph.get(s).get(i).vertex))
                    return true;
                boolean b =  cycleDetectionInUndirected(graph.get(s).get(i).vertex,s,graph,visited);
                if (b)
                    return true;
            }
        }

        visited.remove(s);

        return false;


    }






    private static boolean cycleDetectionInDirected(Map<String, ArrayList<Pair>> graph) { //directed graph
        Set<String> visited = new HashSet<>();
        for (String s : graph.keySet()) {
            boolean cycle = cycleDetectionInDirected(s,graph,visited);
            if (cycle)
                return true;
        }
        return false;

    }

    private static boolean cycleDetectionInDirected(String s, Map<String, ArrayList<Pair>> graph, Set<String> visited) {
        visited.add(s);

        for (int i = 0; i < graph.get(s).size() ; i++) {
            if (visited.contains(graph.get(s).get(i).vertex))
                return true;
            cycleDetectionInDirected(graph.get(s).get(i).vertex,graph,visited);
        }

        visited.remove(s);

        return false;


    }

    private static void findArrivalDeparture(Map<String, ArrayList<Pair>> graph) {
        Map<String,Integer> arrival = new HashMap<>();
        Map<String,Integer> dept = new HashMap<>();
        Set<String> visited = new HashSet<>();
        int time = -1 ;
        for (String s :graph.keySet()) {
            if (!visited.contains(s)) //use this in bfs dfs if graph has components(broken)
                time = dfsFindArrivalDepartureHelper(time,s,graph,visited,arrival,dept);

        }
        for (String s :graph.keySet()) {
            System.out.println(s + " arrival="+arrival.get(s)+" departure="+dept.get(s));
        }


    }

    private static int dfsFindArrivalDepartureHelper(int time, String s, Map<String, ArrayList<Pair>> graph,
                                                     Set<String> visited, Map<String, Integer> arrival,
                                                     Map<String, Integer> dept) {
        arrival.putIfAbsent(s,++time);
        visited.add(s);
        for (int i = 0; i < graph.get(s).size(); i++) {
            if (!visited.contains(graph.get(s).get(i).vertex))
                time = dfsFindArrivalDepartureHelper(time,graph.get(s).get(i).vertex,graph,visited,arrival,dept);
        }
        dept.putIfAbsent(s,++time);
        return time;


    }

    private static void addEdge(String a, String b, Map<String, ArrayList<Pair>> directedGraph) {
        directedGraph.get(a).add(new Pair(b,0));
        if (!a.equals(b)) //for self loop it will add itself 2 times
            directedGraph.get(b).add(new Pair(a,0));
    }

    private static void addVertex(String i, Map<String, ArrayList<Pair>> directedGraph) {
        if (!directedGraph.containsKey(i))
            directedGraph.put(i,new ArrayList<>());
        else
            System.out.println("vertex already present!");
    }
}
