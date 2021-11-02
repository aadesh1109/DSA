import java.util.Arrays;

public class DistinctCombinationsOfGivenLength_1 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int k = 2;
        generateCombinations(A, k);
    }

    private static void generateCombinations(int[] a, int k) {
//        Arrays.sort(a);
        generateCombinations(a, k, "", 0);
    }

    private static void generateCombinations(int[] a, int k, String str, int start) {
        if (k == 0) {
            System.out.println(str);
            return;
        }

        for (int i = start; i < a.length; i++) {
                generateCombinations(a, k - 1, str + a[i] + " ", i + 1);
//            while (i < a.length - 1 && a[i] == a[i + 1]) { // to handle duplicates
//                i++;
            }
        }
    }
