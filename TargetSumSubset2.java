public class TargetSumSubset2 { //Containing negative numbers
    public static void main(String[] args) {
        int[] set = {5, 3, 5, -6, 7, 10, 6};
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

        if (i==set.length)
            return false;

        return find(i+1,set,sum-set[i]) || find(i+1,set,sum);
    }
}
