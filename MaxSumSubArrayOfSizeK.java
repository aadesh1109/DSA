import java.util.Arrays;

public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {2,5,1,8,2,9,1};
        int k = 3;
        System.out.println(findMaxSumSubArrayOfSizeK(arr, k));
    }

    private static int findMaxSumSubArrayOfSizeK(int[] arr, int k) {
        if (k > arr.length)
            return -1;
        if (k == arr.length)
            return Arrays.stream(arr).sum();

        int maxSum = Integer.MIN_VALUE, currSum = 0, j = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (i == k - 1)
                maxSum = Math.max(maxSum, currSum);
            if (i >= k) {
                currSum -= arr[j];
                j++;
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

}
