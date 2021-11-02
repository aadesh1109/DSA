import java.util.Arrays;

public class Partition2Boolean {
    public static void main(String[] args) {
        int[] A = { 1,5,11,5 };
        System.out.println(partition(A));
    }

    private static boolean partition(int[] a) {
        int totSum = Arrays.stream(a).sum();
        if (totSum%2!=0)
            return false;
        int targetSum = totSum/2;
        return canPartition(0,targetSum,a);

    }

    private static boolean canPartition(int i, int targetSum, int[] a) {

        if (targetSum==0)
            return true;

        if (i==a.length)
            return false;

        boolean include = false;

        if (targetSum-a[i]>=0)
            include = canPartition(i+1,targetSum-a[i],a);

        if (include)
            return true;

        boolean exclude = canPartition(i+1,targetSum,a);

        return exclude;

    }
}
