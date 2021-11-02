//SLIDING WINDOW QUESTION(DYNAMIC WINDOW SIZE)
public class SmallestSubarraySizeWithGivenSumGreaterThanEqualsToK {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 7, 8, 1, 2, 8, 10};
        int targetSum = 8;
        int smallestSubArraySize = findSmallestSubArraySize(arr, targetSum);
        System.out.println(smallestSubArraySize);
    }

    private static int findSmallestSubArraySize(int[] arr, int targetSum) {
//        int i = 0;
//        int j = 0;
//        int currSum = 0;
//        int minSize = Integer.MAX_VALUE;
//        while (j < arr.length) {
//            currSum += arr[j];
//            if (currSum >= targetSum) {
//                minSize = Math.min(minSize, j - i + 1);
//                if (i + 1 <= j) {
//                    currSum -= arr[i] + arr[j];
//                    i++;
//                }
//            } else
//                j++;
//        }
//        return minSize;

        int i = 0;
        int currSum = 0;
        int minSize = Integer.MAX_VALUE;
        for (int j = 0; j < arr.length; j++) {
            currSum += arr[j];
            while (i <= j && currSum >= targetSum) {
                minSize = Math.min(minSize, j - i + 1);
                currSum -= arr[i];
                i++;
            }
        }
        return minSize;
    }
}
