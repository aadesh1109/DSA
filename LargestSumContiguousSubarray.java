import java.util.Arrays;

public class LargestSumContiguousSubarray {
    public static void main(String[] args) {
        int[] arr = {-2,-3};
        int sum = findMaxSumContiguousSubarray(arr);
        System.out.println(sum);

    }

    private static int findMaxSumContiguousSubarray(int[] arr) { //KADANE's ALGORITHM....time complexity-O(n), space complexity-O(1)
        int maxSum = arr[0];
        int currSum = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            if (currSum+arr[i]<arr[i])
                currSum=arr[i];
            else
                currSum+=arr[i];
            if (maxSum<currSum)
                maxSum=currSum;
        }
        return maxSum;
    }

//    private static int findMaxSumContiguousSubarray(int[] arr) { //DYNAMIC PROGRAMMING APPROACH...time complexity-O(n), space complexity-O(n)
//        int[] sumArray = new int[arr.length];
//        sumArray[0]=arr[0];
//        for (int i = 1; i < arr.length ; i++) {
//            sumArray[i]=Math.max(arr[i],arr[i]+sumArray[i-1]);
//        }
//        int max = Integer.MIN_VALUE;
//        for (int i : sumArray) {
//            if (i>max)
//                max=i;
//        }
//        return max;
//    }

//    private static int findMaxSumContiguousSubarray(int[] arr) { //taking out sum of every window....time complexity-O(n2)
//        int maxSum = Integer.MIN_VALUE;
//        for (int i = 0; i < arr.length ; i++) {
//            int currSum = 0;
//            for (int j = i; j < arr.length ; j++) {
//                currSum+=arr[j];
//                if (maxSum<currSum)
//                    maxSum=currSum;
//            }
//        }
//        return maxSum;
//    }
}
