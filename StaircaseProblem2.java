public class StaircaseProblem2 {
    public static void main(String[] args) {
        int minMoves = findMinimumMovesToClimbStairs(3);
        System.out.println(minMoves);
    }

    private static int findMinimumMovesToClimbStairs(int stepsLeft) {
        if (stepsLeft == 0) return 0;
        else if (stepsLeft < 0) return Integer.MAX_VALUE;
        else
            return 1 + Math.min(findMinimumMovesToClimbStairs(stepsLeft - 1), findMinimumMovesToClimbStairs(stepsLeft - 2));

    }
}
