import java.util.Arrays;

public class KEqualPartition {
    public static void main(String[] args) {
        int[] arr = {2,1,1,5,4,6,1,10};
        int k = 3;
        boolean canPartition = canPartitionIntoKEqualSubsets(arr, k);
        System.out.println(canPartition);
    }

    private static boolean canPartitionIntoKEqualSubsets(int[] arr, int k) {
        int sum = Arrays.stream(arr).sum();
        if (k == 0 || sum % k != 0)
            return false;
        else
            return canPartitionIntoKEqualSubsets(0, arr, k, 0, sum / k, new boolean[arr.length]);
    }

    private static boolean canPartitionIntoKEqualSubsets(int i, int[] arr, int k, int curSum, int targetSum, boolean[] used) {
        if (k == 1)
            return true;

        if (curSum > targetSum)
            return false;

        if (curSum == targetSum)
            return canPartitionIntoKEqualSubsets(0, arr, k - 1, 0, targetSum, used);

        if (i == arr.length)
            return false;

        if (!used[i]) {
            used[i] = true;
            if (canPartitionIntoKEqualSubsets(i + 1, arr, k, curSum + arr[i], targetSum, used))
                return true;
            used[i] = false;
        }
        return canPartitionIntoKEqualSubsets(i + 1, arr, k, curSum, targetSum, used);
    }
}
