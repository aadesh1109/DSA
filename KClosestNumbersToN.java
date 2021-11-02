import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestNumbersToN {
    public static void main(String[] args) {
        int arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int K = 4, X = 35;
        int[] res = printKClosest(arr, K, X);
        System.out.println(Arrays.toString(res));
    }

//    private static int[] printKClosest(int[] arr, int k, int x) { //USING BINARY SEARCH
//        int[] res = new int[k];
//        int i = findingFloorIndexOfNum(arr, x);
//        int j = i + 1;
//        if (arr[i] == x)
//            i--;
//        int ind = 0;
//        while (i >= 0 && j < arr.length && k > 0) {
//            if (Math.abs(arr[i] - x) < Math.abs(arr[j] - x))
//                res[ind++] = arr[i--];
//            else
//                res[ind++] = arr[j++];
//            k--;
//        }
//        while (k > 0 && i >= 0) {
//            res[ind++] = arr[i--];
//            k--;
//        }
//
//        while (k > 0 && j < arr.length) {
//            res[ind++] = arr[j++];
//            k--;
//        }
//
//        return res;
//    }

//    private static int findingFloorIndexOfNum(int[] arr, int x) {
//        int l = 0;
//        int h = arr.length - 1;
//        while (l <= h) {
//            int mid = l + (h - l) / 2;
//            if (arr[mid] == x)
//                return mid;
//            else if (arr[mid] < x)
//                l = mid + 1;
//            else
//                h = mid - 1;
//        }
//        return h;
//    }


    private static int[] printKClosest(int[] arr, int k, int x) { //USING HEAP
        int[] res = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while (pq.size() < k) {
            if (arr[i] != x) {
                pq.add(arr[i]);
            }
            i++;
        }
        for (int j = i; j < arr.length; j++) {
            if (arr[j] == x)
                continue;
            if (Math.abs(x - pq.peek()) > Math.abs(x - arr[j])) {
                pq.poll();
                pq.add(arr[j]);
            }
        }
        i = 0;
        while (!pq.isEmpty())
            res[i++] = pq.poll();
        return res;
    }
}
