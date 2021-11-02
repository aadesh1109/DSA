import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CheckQuadrupletWithGivenSum {
    public static void main(String[] args) {
        int[] A = {2, 7, 4, 0, 6, 8, 12, 2};
        int sum =8;

        if (hasQuadruplet(A, sum)) {
            System.out.print("Quadruplet Exists");
        } else {
            System.out.print("Quadruplet Doesn't Exist");
        }
    }

    private static boolean hasQuadruplet(int[] a, int sum) {
        Arrays.sort(a);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int val = sum - (a[i] + a[j]);
                if (map.containsKey(val)) {
                    int iIndex = map.get(val).get(0);
                    int jIndex = map.get(val).get(1);
                    if (i != iIndex && i != jIndex && j != iIndex && j != jIndex)
                        return true;
                } else
                    map.put(a[i] + a[j], new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return false;
    }

//    private static boolean hasQuadruplet(int[] a, int sum) {
//        if (a.length < 4)
//            return false;
//        return hasQuadruplet(0, a, 4, sum);
//    }
//
//    private static boolean hasQuadruplet(int i, int[] a, int k, int sum) {
//        if (k == 0) {
//            return sum == 0;
//        }
//        if (i == a.length || sum < 0)
//            return false;
//
//        return hasQuadruplet(i + 1, a, k - 1, sum - a[i]) || hasQuadruplet(i + 1, a, k, sum);
//    }
}
