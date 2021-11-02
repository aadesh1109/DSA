import java.util.*;

//based on SET
// https://www.youtube.com/watch?v=PSpuM9cimxA&list=PLKKfKV1b9e8ps6dD3QA5KFfHdiWj9cB1s&index=49&ab_channel=ApniKaksha
public class ZeroSumSubarray {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 4, 4, -6, -7, 3};
        boolean isPresent = findZeroSumSubarray(nums);
        System.out.println(isPresent);
    }

    private static boolean findZeroSumSubarray(int[] nums) {
        HashSet<Integer> sumsSoFarSet = new HashSet<>();
        int currSum = 0;
        sumsSoFarSet.add(currSum);
        for (int num : nums) {
            System.out.println(sumsSoFarSet);
            currSum += num;
            if (!sumsSoFarSet.add(currSum)) {
                return true;
            }
        }
        return false;
    }
}