public class DistinctCombinationsOfGivenLength_2 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int k = 2;
        generateCombinations(A, k);
    }

    private static void generateCombinations(int[] a, int k) {
        generateCombinations(0, a, k, "");
    }

    private static void generateCombinations(int ind, int[] a, int k, String str) {

        if (k == 0) {
            System.out.println(str);
            return;
        }

        if (ind == a.length)
            return;


        generateCombinations(ind + 1, a, k - 1, str + a[ind] + " ");
        generateCombinations(ind + 1, a, k, str);
    }
}
