public class MaximumProductSubsetProblem {
    public static void main(String[] args) {
        int[] A = {-2, -3, -2, 4, 8, 0, 0};
        int maxProd = findMaximumProductSubsetProblem(A);
        System.out.println(maxProd);
    }

    private static int findMaximumProductSubsetProblem(int[] a) {
        if (a.length == 0) return 0;
        if (a.length == 1) return a[0];
        int minNegativeAbsoluteSoFar = Integer.MAX_VALUE;
        int maxProd = 1, negativeProduct = 1;
        int positiveCount = 0, negativeCount = 0;
        boolean containsZero = false;
        for (int i : a) {
            if (i < 0) {
                negativeCount++;
                negativeProduct = negativeProduct * i;
                minNegativeAbsoluteSoFar = Math.min(Math.abs(i), minNegativeAbsoluteSoFar);
            } else if (i > 0) {
                positiveCount++;
                maxProd = maxProd * i;
            } else {
                containsZero = true;
            }
        }
        minNegativeAbsoluteSoFar = -minNegativeAbsoluteSoFar;
        if (positiveCount == 0 && negativeCount % 2 != 0 && containsZero)
            return 0;
        else {
            if (negativeProduct > 0)
                return maxProd * negativeProduct;
            else
                return maxProd * (negativeProduct / minNegativeAbsoluteSoFar);
        }
    }
}
