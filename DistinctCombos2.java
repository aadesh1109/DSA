import java.util.Arrays;

public class DistinctCombos2
{
    public static void main(String[] args)
    {
        int[] A = { 0,1,2};
        int k = 2;
        recur(A, "", 0, k);
    }

    public static void recur(int[] A, String out, int i, int k)
    {
        if (out.length()==k) {
            System.out.println(Arrays.toString(out.toCharArray()));
            return;
        }

        for (int j = i; j < A.length; j++)
        {
            recur(A, out+(A[j]) , j + 1, k );
        }
    }
}