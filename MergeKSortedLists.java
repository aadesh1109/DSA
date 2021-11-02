import java.util.*;

public class MergeKSortedLists {
    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(10, 20, 30, 40),
                Arrays.asList(15, 25, 35),
                Arrays.asList(27, 29, 37, 48, 93),
                Arrays.asList(32, 33)
        );
        List<Integer> result = printSorted(list);
        System.out.println(result);
    }

    private static List<Integer> printSorted(List<List<Integer>> list) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.num - o2.num;
            }
        });
        int i = 0;
        for (List<Integer> l : list) {
            pq.add(new Node(l.get(0), 0, i++));
        }
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            result.add(node.num);
            if (node.index + 1 < list.get(node.listNum).size())
                pq.add(new Node(list.get(node.listNum).get(node.index + 1), node.index + 1, node.listNum));
        }


        return result;
    }
}

class Node {
    int num;
    int index;
    int listNum;

    Node(int num, int index, int listNum) {
        this.num = num;
        this.index = index;
        this.listNum = listNum;
    }
}
