public class TripletExistsOrNot {
    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5};
        int sum = 9;
        System.out.println(tripletExists(A,sum));
    }

    private static boolean tripletExists(int[] a, int sum) {
        return tripletExists(0,a,sum,0);
    }

    private static boolean tripletExists(int i ,int[] a, int sum , int count) {
        if (sum==0 && count==3)
            return true;

        if (i==a.length || count==3)
            return false;

        boolean x = true ;
        if (sum-a[i]>=0)
            x= tripletExists(i+1,a,sum-a[i],count+1);

        boolean y= tripletExists(i+1,a,sum,count);

        return x || y;
    }


}
