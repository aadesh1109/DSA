public class LongestDecreasingSubsequence {
    public static void main(String[] args) {
        int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        System.out.println("Length of LDS is " +
                LDS(A, 0, Integer.MAX_VALUE));
    }

    private static int LDS(int[] a, int i, int prevValue) {
        if (i==a.length)
            return 0;

        int exclude = LDS(a,i+1,prevValue);
        int include = 0;
        if (prevValue>a[i])
            include = 1 + LDS(a,i+1,a[i]);

        return Math.max(exclude,include);


    }
}
