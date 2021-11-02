import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class K_Frequent {
    public static void main(String[] args) {
        int[] arr = {1,3,2,2,1,2,1};
        int k = 2;
        topKFrequent(arr,k);
    }

    private static void topKFrequent(int[] arr, int k) {
        Arrays.sort(arr);
        
    }
}
class Pair implements Comparable<Pair>{
    int num;
    int count;

    public Pair(int num, int count) {
        this.num = num;
        this.count = count;
    }


    @Override
    public int compareTo(Pair o) {
        return this.count-o.count;
    }
}
