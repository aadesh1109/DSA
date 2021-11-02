import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

//K sorted means that each element is displaced at most k distance away from the original sorted position
public class SortAKSortedArray {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = { 2, 6, 3, 12, 56, 8 };
        kSort(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    private static void kSort(int[] arr, int k) {
        int j=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (i>=k)
                arr[j++]=pq.poll();
        }
        while (!pq.isEmpty())
            arr[j++]=pq.poll();
    }
}
