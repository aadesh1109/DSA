import java.util.ArrayList;

public class MaxSumSubsequenceNoAdjacent {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 9, 4, 5, 0, 4, 11, 6 };
        System.out.println(maxSumSubSeq(0,arr,0));

    }

    private static int maxSumSubSeq(int i, int[] arr, int prev) {
        if (i==arr.length)
            return 0;

        int include = 0;
        if (i==0)
            include=arr[i]+maxSumSubSeq(i+1,arr,arr[i]);

        if ( i!=0 && prev!=arr[i-1])
        {
         include = arr[i]+maxSumSubSeq(i+1,arr,arr[i]);
        }

        int exclude = maxSumSubSeq(i+1,arr,prev);

        return Math.max(include,exclude);

    }
}
