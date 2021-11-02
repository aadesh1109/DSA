import java.util.*;

public class SlidingWindowMaximum{
    public static void main(String[] args) {
        int[] nums = {4,3,1,2};
        int k =4;
        int[] max = findMaxInWindows(nums,k);
        System.out.println(Arrays.toString(max));
    }

    private static int[] findMaxInWindows(int[] nums, int k) { //Using DOUBLY ENDED QUEUE... time complexity-O(N)
        if (nums.length<1 || k==1)
            return nums;
        int[] max = new int[nums.length-k+1];
        int maxArrayCurrIndex = 0;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()]<nums[i])
                    dq.pollLast();
            dq.addLast(i);
            if (i>=k-1)
            {
                if (!dq.isEmpty() && dq.peekFirst()<i-k+1)
                    dq.pollFirst();
                max[maxArrayCurrIndex]=nums[dq.peekFirst()];
                maxArrayCurrIndex++;
            }
        }
        return max;
    }

//    private static int[] findMaxInWindows(int[] nums, int k) { //Using PRIORITY QUEUE... time complexity-O(N Log k)
//        int[] max = new int[nums.length-k+1];
//        int maxIndexNum = 0;
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        for (int i = 0; i < nums.length ; i++) {
//                pq.add(nums[i]);
//            if (i>=k-1)
//            {
//                max[maxIndexNum]=pq.peek();
//                maxIndexNum++;
//                pq.remove(nums[i-k+1]);
//
//            }
//        }
//        return max;
//    }
}
