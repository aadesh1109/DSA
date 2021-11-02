import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationProblem {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 1, 2, 2, 3, 4, 4};
        int k = 2;
        generateCombos(A, k);
    }

    private static void generateCombos(int[] a, int k) {
        Arrays.sort(a);
        generateCombos(0, a, k, new ArrayList<>());
    }

    private static void generateCombos(int i, int[] a, int k, ArrayList<Integer> list) {
        if (list.size() == k) {
            System.out.println(list);
            return;
        }

        for (int j = i; j < a.length; j++) {
            while (j < a.length - 1 && a[j] == a[j + 1])
                j++;

            list.add(a[j]);
            generateCombos(j, a, k, list);
            list.remove(list.size() - 1);
        }
    }
}
