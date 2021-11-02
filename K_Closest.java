import java.util.*;

public class K_Closest {
    public static void main(String[] args) {
        int[] arr = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};
        int k = 4;
        int x = 35;
        findClosestElements(arr,k,x);

    }
    public static void findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0;i<arr.length;i++){
            if(i<k)
                pq.add(x-arr[i]);
            else
            {
                if(Math.abs(pq.peek())>Math.abs(x-arr[i]))
                {
                    pq.poll();
                    pq.add(x-arr[i]);
                }
            }
        }


        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty())
            list.add(x-pq.poll());

        for (int i:
             list) {
            System.out.println(i);
        }


    }
}
