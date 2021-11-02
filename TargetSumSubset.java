public class TargetSumSubset {
    public static void main(String[] args) {
        int[] set = {4,2,7,1,3};
        int sum = 10;
        boolean sumPresent = find(set,sum);
        System.out.println(sumPresent);
    }

    private static boolean find(int[] set, int sum) {
        return find(0,set,sum);
    }

    private static boolean find(int i, int[] set, int sum) {
        if (sum==0)
            return true;
        if (sum<0 || i==set.length)
            return false;

        return find(i+1,set,sum-set[i]) || find(i+1,set,sum);
    }
}
