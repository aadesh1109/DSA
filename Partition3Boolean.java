import java.util.Arrays;

public class Partition3Boolean {
    public static void main(String[] args) {
        int[] A = { 7, 3, 2, 1, 5, 4, 8 };
        boolean a =  canPartition(A);
        System.out.println(a);
    }

    private static boolean canPartition(int[] a) {
        int totSum = Arrays.stream(a).sum();
        if (totSum%3!=0)
            return false;
        else
        {
            return canPartition(0,totSum/3,totSum/3,totSum/3,a);
        }
    }

    private static boolean canPartition(int i, int s1, int s2, int s3, int[] a) {

        if (i==a.length)
        {
            if (s1==0 && s2==0 && s3==0)
                return true;
            return false;
        }
        boolean x = false;
        boolean y = false;
        boolean z = false;


        if (s1-a[i]>=0)
            x=canPartition(i+1,s1-a[i],s2,s3,a);

        if (x)
            return true;

        if (s2-a[i]>=0)
            y=canPartition(i+1,s1,s2-a[i],s3,a);

        if (y)
            return true;

        if (s3-a[i]>=0)
            z=canPartition(i+1,s1,s2,s3-a[i],a);


        return z;

    }
}
