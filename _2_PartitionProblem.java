import java.util.Arrays;

public class _2_PartitionProblem {
    public static void main(String[] args) {
        int[] arr = {3, 1, 1, 2, 2, 1};
        if (partition(arr)) {
            System.out.println("Can be partitioned");
        } else {
            System.out.println("Cannot be partitioned");
        }
    }

    private static boolean partition(int[] arr) {
        if (arr.length < 2)
            return false;
        int sum = Arrays.stream(arr).sum();
        return (sum % 2 == 0) && partition(0, arr, sum / 2);

    }

    private static boolean partition(int i, int[] arr, int s1) {

        if (s1 < 0)
            return false;

        if (s1 == 0)
            return true;

        if (i == arr.length)
            return false;


        return partition(i + 1, arr, s1 - arr[i]) || partition(i + 1, arr, s1);
    }

//    private static boolean partition(int i, int[] arr, int s1, int s2) {
//        if (s1 < 0 || s2 < 0)
//            return false;
//
//        if (i == arr.length)
//            return (s1 == 0 && s2 == 0);
//
//        return partition(i + 1, arr, s1 - arr[i], s2) || partition(i + 1, arr, s1, s2 - arr[i]);
//    }
}
