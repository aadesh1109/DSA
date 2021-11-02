//SLIDING WINDOW ALGORITHM QUESTION(FIXED SIZE)
public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 2};
        int k = 3;
        int maxSum = findMaxSum(arr, k);
//        System.out.println();
        System.out.println(maxSum);
    }

    private static int findMaxSum(int[] arr, int k) {
        if (arr.length < k)
            return -1;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (i >= k - 1) {
//                System.out.print(currSum + " ");
                maxSum = Math.max(maxSum, currSum);
                currSum -= arr[i - (k - 1)];

            }
        }
        return maxSum;
    }
}
