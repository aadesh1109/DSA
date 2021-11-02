import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class K_Smallest {
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int k = 3;
        int[] res = findKSmallest(arr,k);
        System.out.println(Arrays.toString(res));

    }

    private static int[] findKSmallest(int[] arr, int k) {
        int[] res = new int[k];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length ; i++) {
            if (i<k)
                pq.add(arr[i]);
            else
            {
                if (pq.peek()>arr[i])
                {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
        }
        int i = res.length-1;
        while (!pq.isEmpty())
        {
            res[i]=pq.poll();
            i--;
        }
        return res;
    }
}
