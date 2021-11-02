import java.util.Arrays;

public class GenerateAllKPartitionWithEqualSum {
    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 12, 2, 1, 5, 3, 8, 4, 6, 4};
        int k = 4;
        boolean canPartition = canPartitionIntoKEqualSubsets(arr, k);
        System.out.println(canPartition);
    }

    private static boolean canPartitionIntoKEqualSubsets(int[] arr, int k) {
        int sum = Arrays.stream(arr).sum();
        if (k == 0 || sum % k != 0)
            return false;
        int[] liesInList = new int[arr.length];
        Arrays.fill(liesInList, 1);
        return canPartitionIntoKEqualSubsets(0, arr, k, 0, sum / k, new boolean[arr.length], liesInList);
    }

    private static boolean canPartitionIntoKEqualSubsets(int i, int[] arr, int k, int curSum, int targetSum, boolean[] used, int[] liesInList) {
        if (k == 1) {
            System.out.println(Arrays.toString(liesInList));
            return true;
        }

        if (curSum > targetSum)
            return false;

        if (curSum == targetSum)
            return canPartitionIntoKEqualSubsets(0, arr, k - 1, 0, targetSum, used, liesInList);

        if (i == arr.length)
            return false;

        if (!used[i]) {
            used[i] = true;
            liesInList[i] = k;
            if (canPartitionIntoKEqualSubsets(i + 1, arr, k, curSum + arr[i], targetSum, used, liesInList))
                return true;
            used[i] = false;
            liesInList[i] = 1;
        }
        return canPartitionIntoKEqualSubsets(i + 1, arr, k, curSum, targetSum, used, liesInList);
    }
}
