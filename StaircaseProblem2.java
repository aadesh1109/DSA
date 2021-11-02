import java.util.HashMap;
import java.util.Map;

public class StaircaseProblem2 {
    public static void main(String[] args) {
        int minMoves = findMinimumMovesToClimbStairs(9);
        System.out.println(minMoves);
    }

    private static int findMinimumMovesToClimbStairs(int stepsLeft) {
        return findMinimumMovesToClimbStairs(stepsLeft, new HashMap<>());

    }

    private static int findMinimumMovesToClimbStairs(int stepsLeft, Map<Integer, Integer> map) {
        if (stepsLeft == 0) return 0;
        else if (stepsLeft < 0) return Integer.MAX_VALUE;
        else {
            if (!map.containsKey(stepsLeft))
                map.put(stepsLeft, 1 + Math.min(findMinimumMovesToClimbStairs(stepsLeft - 1, map), findMinimumMovesToClimbStairs(stepsLeft - 2, map)));
            return map.get(stepsLeft);
        }

    }
}
