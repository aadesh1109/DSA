import javax.net.ssl.SNIHostName;
import java.util.*;

public class GraphImplement {
    public static void main(String[] args) {

        Map<String,ArrayList<NodeDisPair>> map = new HashMap<>();

        addVertex(map,"1");
        addVertex(map,"2");
        addVertex(map,"3");
        addVertex(map,"4");


        addEdge(map,"1","2", 5);
        addEdge(map,"1","4", 4);
        addEdge(map,"2","3", 3);
        addEdge(map,"3","4", 6);
        addEdge(map,"2","4", 2);



    }

    private static void removeEdge(Map<String, ArrayList<NodeDisPair>> map, String src, String des) {
        for (String s : map.keySet()) {
            for (NodeDisPair p: map.get(s)) {
                if (s.equals(src) && p.name.equals(des))
                    map.get(s).remove(p);
                if (s.equals(des) && p.name.equals(src))
                    map.get(s).remove(p);
            }
        }
    }

    private static void MSTKruskalAlgo(Map<String, ArrayList<NodeDisPair>> map) {
        PriorityQueue<NEdge> pq = new PriorityQueue<>();
        for (String s : map.keySet()) {
            for (NodeDisPair p : map.get(s)) {

                if (!(pq.contains(new NEdge(s,p.name,p.dis)) || pq.contains(new NEdge(p.name,s,p.dis))))
                {
                    pq.add(new NEdge(s, p.name, p.dis));
                }
            }
        }

        boolean[] booleans = new boolean[map.size()+1];
        Map<String,ArrayList<NodeDisPair>> MST = new HashMap<>();
        for (int i = 1; i <= map.size()-1 ; i++) {
            NEdge e = pq.poll();
            if (!MST.containsKey(e.src))
                addVertex(MST, e.src);

            if (!MST.containsKey(e.dest))
                addVertex(MST,e.dest);


            if (booleans[Integer.parseInt(e.src)] && booleans[Integer.parseInt(e.dest)])
            {
                i--;
                continue;
            }
            booleans[Integer.parseInt(e.src)]=true;
            booleans[Integer.parseInt(e.dest)]=true;
            addEdge(MST,e.src,e.dest, e.weight);

        }

        for (String s: MST.keySet()) {
            for (NodeDisPair p : MST.get(s)) {
                System.out.println(s + " " + p.name +" " + "("+p.dis +")");
            }
        }



    }


    private static void DFS(String s, Map<String, ArrayList<NodeDisPair>> map) {
        Set<String> set = new HashSet<>();
        DFSHelper(set,s,map);
    }

    private static void DFSHelper(Set<String> set, String s, Map<String, ArrayList<NodeDisPair>> map) {
        set.add(s);
        System.out.println(s);

        for (int i = 0; i < map.get(s).size() ; i++) {
            if (!set.contains(map.get(s).get(i).name))
                DFSHelper(set,map.get(s).get(i).name,map);
        }
    }

    private static void BellmanFord(String src, Map<String, ArrayList<NodeDisPair>> map) {

        Map<String,Integer> finalMap = new HashMap<>();
        ArrayList<Edge> edgeList = new ArrayList<>();
        for (String s: map.keySet()) {
            if(!s.equals(src))
                finalMap.put(s,Integer.MAX_VALUE);
            else
                finalMap.put(s,0);

            for (NodeDisPair p :map.get(s)) {
                edgeList.add(new Edge(s,p.name, p.dis));
            }
        }

        for (int i = 0; i < edgeList.size(); i++) {
            for (Edge e : edgeList) {
                if (finalMap.get(e.src)+e.weight<finalMap.get(e.des))
                    finalMap.put(e.des,finalMap.get(e.src)+e.weight);
            }
        }

        for (String S : finalMap.keySet()) {
            System.out.println(S + " : " + finalMap.get(S));
        }
    }

    private static void DijkstraAlgo(Map<String, ArrayList<NodeDisPair>> map, String src) {
        PriorityQueue<disPair> pq = new PriorityQueue<>();
        boolean[] done = new boolean[map.size()];
        Map<String,Integer> stringToBooleanDone = new HashMap<>();int i =0;
        Map<String,Integer> finalList = new HashMap<>();
        for (String s: map.keySet()) {
            stringToBooleanDone.put(s,i);
            i++;
            if (!s.equals(src))
            {
                pq.add(new disPair(s,Integer.MAX_VALUE));
                finalList.put(s,Integer.MAX_VALUE);
            }
            else
            {
                pq.add(new disPair(s,0));
                finalList.put(s,0);
            }
        }

        while (!pq.isEmpty())
        {
            disPair p = pq.poll();
            if (!done[stringToBooleanDone.get(p.NodeName)])
            {
                for (NodeDisPair pair : map.get(p.NodeName)) {
                    if (p.dis+ pair.dis<finalList.get(pair.name))
                    {
                        finalList.put(pair.name,p.dis+ pair.dis);
                        pq.add(new disPair(pair.name, p.dis+ pair.dis));
                    }
                }
                done[stringToBooleanDone.get(p.NodeName)]=true;
            }
        }

        for (String s:
             finalList.keySet()) {
            System.out.println(s + " " + finalList.get(s));
        }












       /* Map<String,Integer> shortestDistance = new HashMap<>();
        LinkedList<disPair> list = new LinkedList<>();
        for (String s : map.keySet()) {
            if(s.equals(src))
                list.add(new disPair(s,0));
            else
                list.add(new disPair(s,Integer.MAX_VALUE));
        }

        while (!list.isEmpty())
        {

            disPair currNode = Collections.min(list);
            for (NodeDisPair p: map.get(currNode.NodeName)) {
                if (currNode.dis+p.dis<getValue(p.Node,list))
                {
                    setValue(currNode.dis+p.dis,p.Node,list);
                }
            }
            shortestDistance.put(currNode.NodeName, currNode.dis);
            list.remove(currNode);
        }

        for (String s: shortestDistance.keySet()) {
            System.out.println(s + " : " + shortestDistance.get(s));
        }*/
    }

/*    private static void setValue(int newValue, String node, LinkedList<disPair> list) {
        for (disPair p: list) {
            if (p.NodeName.equals(node))
            {
                p.dis=newValue;
                break;
            }
        }
    }

    private static int getValue(String node, LinkedList<disPair> list) {
        for (disPair p: list) {
            if (p.NodeName.equals(node))
                return p.dis;
        }
        return 0;
    }*/


    private static void addEdge(Map<String,ArrayList<NodeDisPair>> map, String src, String des,int dis) {

        map.get(src).add(new NodeDisPair(des,dis));
        map.get(des).add(new NodeDisPair(src,dis));

    }

    private static void addVertex(Map<String,ArrayList<NodeDisPair>> map, String node) {

        map.put(node,new ArrayList<>());

    }




/*    private static void DFSRec(int i, Map<Integer, ArrayList<Integer>> map) {
        Set<Integer> visited = new HashSet<>();
        DFSRec(i,map,visited);
    }

    private static void DFSRec(int i, Map<Integer, ArrayList<Integer>> map,Set<Integer> visited) {

        visited.add(i);
        System.out.println(i);

        for (int j = map.get(i).size()-1; j >= 0; j--) {

            if(!visited.contains(map.get(i).get(j)))
                DFSRec(map.get(i).get(j),map,visited);

        }

    }


    private static void DFS(int curr, Map<Integer, ArrayList<Integer>> map) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer>stack = new Stack<>();
        stack.push(curr);

        while (!stack.isEmpty())
        {
            int out = stack.pop();
            if (!visited.contains(out))
            {
                System.out.println(out);
                visited.add(out);
            }

            for (int i : map.get(out)) {
                if(!visited.contains(i))
                    stack.push(i);

            }
        }


    }

    private static void BFS(int curr, Map<Integer, ArrayList<Integer>> map) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr);

        while (!queue.isEmpty())
        {
            int Node = queue.poll();

            if (!visited.contains(Node))
            {
                System.out.println(Node);
                visited.add(Node);
            }

            for (int i: map.get(Node)) {
                if(!visited.contains(i))
                    queue.add(i);

            }
        }

    }*/




}
class disPair implements Comparable<disPair>{
    String NodeName;
    int dis;

    public disPair(String nodeName, int dis) {
        NodeName = nodeName;
        this.dis = dis;
    }



    public int compareTo(disPair o) {
        return this.dis-o.dis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        disPair disPair = (disPair) o;
        return dis == disPair.dis &&
                Objects.equals(NodeName, disPair.NodeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NodeName, dis);
    }
}


class NodeDisPair{
    String name;
    int dis;

    public NodeDisPair(String name, int dis) {
        this.name = name;
        this.dis = dis;
    }
}

class Edge  {
    String src;
    String des;
    int weight;

    public Edge(String src, String des, int weight) {
        this.src = src;
        this.des = des;
        this.weight = weight;
    }

}