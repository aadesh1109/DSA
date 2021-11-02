import java.util.Arrays;
import java.util.HashMap;

public class CheckTripletWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 0, 7, 5, 1, 3};
        int sum = 16;
        boolean isTripletPresent = checkTripletWithGivenSum(arr, sum);
        System.out.println(isTripletPresent);
    }

    private static boolean checkTripletWithGivenSum(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int keyToFindInMap = sum - (arr[i] + arr[j]);
                if (map.containsKey(keyToFindInMap)) {
                    if (map.get(keyToFindInMap) != i && map.get(keyToFindInMap) != j)
                        return true;
                }
            }
        }
        return false;
    }

//    private static boolean checkTripletWithGivenSum(int[] arr, int sum) { //TWO POINTER ALGORITHM - better solution than recursive solution
//        Arrays.sort(arr);
//        for (int i = 0; i < arr.length - 2; i++) {
//            int j = i + 1, k = arr.length - 1;
//            while (j < k) {
//                if (arr[i] + arr[j] + arr[k] == sum)
//                    return true;
//                else if (arr[i] + arr[j] + arr[k] < sum)
//                    j++;
//                else
//                    k--;
//            }
//        }
//        return false;
//    }

//    private static boolean checkTripletWithGivenSum(int[] arr, int sum) {
//        return checkTripletWithGivenSum(0, 3, arr, sum);
//    }

//    private static boolean checkTripletWithGivenSum(int ind, int k, int[] arr, int sum) { //better solution is to sort the array and apply 2 pointer algorithm technique
//
//        if (k == 0) {
//            return sum == 0;
//        }
//
//        if (ind == arr.length || sum < 0) {
//            return false;
//        }
//
//        return checkTripletWithGivenSum(ind + 1, k - 1, arr, sum - arr[ind]) || checkTripletWithGivenSum(ind + 1, k, arr, sum);
//    }
}
