public class StaircaseProblem1 {
    public static void main(String[] args) {
        int n = 60;
        int waysToClimb = findWaysToClimb(n);
        System.out.println(waysToClimb);
    }

    private static int findWaysToClimb(int n) {
        if (n==0)
            return 1;
        else if (n<0)
            return 0;
        return findWaysToClimb(n-1)+findWaysToClimb(n-2);
    }
}
