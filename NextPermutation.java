import java.util.Arrays;
import java.util.PriorityQueue;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {6,2,1,5,4,3,0};
        nextPermutation(arr);
    }

    private static void nextPermutation(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = arr.length-1;
        int index = 0;
        while (arr[i]<arr[i-1])
        {
            pq.add(arr[i]);
            i--;

        }
        pq.add(arr[i]);
        index = i-1;
        boolean set = false;
        while (i<arr.length)
        {
            int num = pq.poll();
            if (num>arr[index] && !set)
            {
                set=true;
                pq.add(arr[index]);
                arr[index]=num;
            }
            else
            {
                arr[i]=num;
                i++;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
