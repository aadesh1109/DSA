import java.util.*;

public class Check {
    public static void main(String[] args) {
        PriorityQueue<NEdge> pq = new PriorityQueue<>();
        Map<NEdge,Boolean> map = new HashMap<>();
        String s = "2";
        String d = "1";
        int w = 2;
        pq.add(new NEdge("1","2",2));
        pq.add(new NEdge("1","2",3));
        System.out.println(pq.poll());
        System.out.println(pq.poll());

    }
}

class NEdge implements Comparable<NEdge>{
    String src, dest;
    int weight;

    public NEdge(String src, String dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NEdge nEdge = (NEdge) o;
        return weight == nEdge.weight &&
                Objects.equals(src, nEdge.src) &&
                Objects.equals(dest, nEdge.dest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(src,dest,weight);
    }

    @Override
    public int compareTo(NEdge o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "NEdge{" +
                "src='" + src + '\'' +
                ", dest='" + dest + '\'' +
                ", weight=" + weight +
                '}';
    }
}

