import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumElementOfAllSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        findMaximumElementOfAllSubarrayOfSizeK(arr, k);
    }

    private static void findMaximumElementOfAllSubarrayOfSizeK(int[] arr, int k) { // USING DOUBLY ENDED QUEUE (DEQUE) time complexity-->O(N)....space complexity-->O(K)
        if (arr.length==0 || arr.length<k)
        {
            System.out.println(-1);
            return;
        }
        if (arr.length==k)
        {
            System.out.println(Arrays.stream(arr).max().getAsInt());
            return;
        }
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
                dq.removeLast();
            dq.addLast(i);
        }
        System.out.print(arr[dq.peekFirst()] + " ");
        for (int i = k; i < arr.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.removeFirst();
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
                dq.removeLast();
            dq.addLast(i);
            System.out.print(arr[dq.peekFirst()] + " ");
        }
    }

//    private static void findMaximumElementOfAllSubarrayOfSizeK(int[] arr, int k) { // USING MAX HEAP (PRIORITY QUEUE) time complexity-->O(N*LogK)....space complexity-->O(K)
//        if (arr.length==0 || arr.length<k)
//        {
//            System.out.println(-1);
//            return;
//        }
//        if (arr.length==k)
//        {
//            System.out.println(Arrays.stream(arr).max().getAsInt());
//            return;
//        }
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        for (int i = 0; i < k; i++) {
//            pq.add(arr[i]);
//        }
//        System.out.print(pq.peek()+" ");
//        for (int i = k; i < arr.length ; i++) {
//            pq.add(arr[i]);
//            pq.remove(arr[i-k]);
//            System.out.print(pq.peek()+" ");
//        }
//    }
}
