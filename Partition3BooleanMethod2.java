import java.util.Arrays;

public class Partition3BooleanMethod2 {
    public static void main(String[] args) {
        int[] A = { 1,1,2,2 };
        boolean a =  canPartition(A);
        System.out.println(a);
    }

    private static boolean canPartition(int[] a) {
        int totSum = Arrays.stream(a).sum();
        if (totSum%3!=0)
            return false;
        else
        {
            return canPartition(0,totSum/3,totSum/3,a);
        }
    }

    private static boolean canPartition(int i, int s1, int s2, int[] a) {
        if (s1==0 && s2==0)
            return true;

        if (i==a.length)
            return false;

        boolean x =false;
        boolean y =false;
        boolean exclusive;

        if (s1-a[i]>=0)
            x=canPartition(i+1,s1-a[i],s2,a);

        if (x)
            return true;


        if (s2-a[i]>=0)
            y=canPartition(i+1,s1,s2-a[i],a);

        if (y)
            return true;

        exclusive=canPartition(i+1,s1,s2,a);

        return exclusive;

    }
}
