import java.util.ArrayList;

public class MaximumProductSubset {
    public static void main(String[] args) {
        int[] arr = {0, -3, -5, -6};
        int maximum = findMaximumProductSubset(arr);
        System.out.print("The maximum product of a subset is " + maximum);
    }

    private static int findMaximumProductSubset(int[] arr) {
        return findMaximumProductSubset(0, arr, new ArrayList<>(), Integer.MIN_VALUE);
    }

    private static int findMaximumProductSubset(int i, int[] arr, ArrayList<Integer> list, int maxProd) {
        if (i == arr.length) {
            int prod = 1;
            for (int j : list) {
                prod = prod * j;
            }
            if (list.size() > 0)
                maxProd = Math.max(prod, maxProd);
            return maxProd;
        }

        list.add(arr[i]);
        int include = findMaximumProductSubset(i + 1, arr, list, maxProd);
        list.remove(list.size() - 1);
        int exclude = findMaximumProductSubset(i + 1, arr, list, maxProd);
        return Math.max(include, exclude);
    }
}
