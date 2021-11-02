import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSorted {
    public static void main(String[] args) {
        int[] arr = {6,5,3,2,8,10,9};
        int k = 3;
        sort(arr,k);
    }

    private static void sort(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i<=k)
            {
                minHeap.add(arr[i]);
            }
            else
            {
                arr[j++]=minHeap.poll();
                minHeap.add(arr[i]);
            }

        }
        while (!minHeap.isEmpty())
        {
            arr[j++]=minHeap.poll();
        }
        System.out.println(Arrays.toString(arr));

    }
}
