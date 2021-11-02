public class LargestSubarraySizeOfGivenSum {
    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
        int sum = 5;
        int maxSize = findLargestSubarraySizeOfGivenSum(arr, sum);
        System.out.println(maxSize);
    }

    private static int findLargestSubarraySizeOfGivenSum(int[] arr, int sum) { // sliding window algo doesn't work if negative numbers are also present
        int j = 0, i = 0, currSum = 0, maxLen = 0;
        while (j < arr.length) {
            currSum += arr[j];
            if (currSum > sum) {
                while (i < j && currSum > sum) {
                    currSum -= arr[i];
                    i++;
                }
            }
            if (currSum == sum)
                maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}
